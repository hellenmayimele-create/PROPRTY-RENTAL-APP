import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Section B: Unit Tests for the Property Rental Application.
 * Tests cover Search, Update, Delete, and Amount Validation operations.
 */
public class PropertyTest {
    private Property propertyManager;

    @BeforeEach
    public void setUp() {
        propertyManager = new Property();
        // Seed initial property data for testing
        PropertyModel p1 = new PropertyModel("101", "10 Main Road, 6001", 3800.0, "Jane Doe");
        PropertyModel p2 = new PropertyModel("102", "15 Sea Street, 6070", 3100.0, "Joe Bloggs");
        propertyManager.getPropertyList().add(p1);
        propertyManager.getPropertyList().add(p2);
    }

    /**
     * Test: SearchProperty_ReturnsProperty()
     * Purpose: Verify that supplying a valid Property ID returns the correct property.
     */
    @Test
    public void SearchProperty_ReturnsProperty() {
        PropertyModel result = propertyManager.findPropertyById("101");
        assertNotNull(result, "Search should return a property object when ID exists.");
        assertEquals("101", result.getPropertyId());
        assertEquals("10 Main Road, 6001", result.getPropertyAddress());
        assertEquals(3800.0, result.getPropertyRentalAmount());
        assertEquals("Jane Doe", result.getAgentName());
    }

    /**
     * Test: SearchProperty_NotFound()
     * Purpose: Verify that supplying an invalid Property ID returns null.
     */
    @Test
    public void SearchProperty_NotFound() {
        PropertyModel result = propertyManager.findPropertyById("999");
        assertNull(result, "Search should return null when property ID is not found.");
    }

    /**
     * Test: UpdateProperty_ReturnsSuccess()
     * Purpose: Verify that property details are successfully updated in memory.
     */
    @Test
    public void UpdateProperty_ReturnsSuccess() {
        boolean success = propertyManager.performUpdate("101", "10 Main Road, 6001", 4200.0, "Jane Done");
        assertTrue(success, "Update operation should return true on success.");

        PropertyModel updated = propertyManager.findPropertyById("101");
        assertEquals(4200.0, updated.getPropertyRentalAmount());
        assertEquals("Jane Done", updated.getAgentName());
    }

    /**
     * Test: DeleteProperty_ReturnsSuccess()
     * Purpose: Verify that supplying a valid ID removes the property from memory.
     */
    @Test
    public void DeleteProperty_ReturnsSuccess() {
        boolean deleted = propertyManager.performDelete("101");
        assertTrue(deleted, "Delete operation should return true when property is removed.");

        PropertyModel result = propertyManager.findPropertyById("101");
        assertNull(result, "Property should no longer exist in memory after deletion.");
    }

    /**
     * Test: PropertyAmountValidation_AmountIsValid()
     * Purpose: Verify that a rental amount >= R1 500 is accepted as valid.
     */
    @Test
    public void PropertyAmountValidation_AmountIsValid() {
        boolean isValid = propertyManager.validateRentalAmount(2500.0);
        assertTrue(isValid, "Rental amount >= R1 500 should be valid.");
    }

    /**
     * Test: PropertyAmountValidation_AmountInvalid()
     * Purpose: Verify that a rental amount < R1 500 is rejected as invalid.
     */
    @Test
    public void PropertyAmountValidation_AmountInvalid() {
        boolean isValid = propertyManager.validateRentalAmount(900.0);
        assertFalse(isValid, "Rental amount < R1 500 should be invalid.");
    }
}