/**
 * The PropertyModel class represents a property rental entity.
 * It encapsulates property ID, address, monthly rental amount, and agent name.
 */
public class PropertyModel {
    private String propertyId;
    private String propertyAddress;
    private double propertyRentalAmount;
    private String agentName;

    /**
     * Parameterised constructor to initialize a new PropertyModel object.
     * 
     * @param propertyId           Unique identifier for the property.
     * @param propertyAddress      Physical address of the property.
     * @param propertyRentalAmount Monthly rental fee.
     * @param agentName            Name of the assigned estate agent.
     */
    public PropertyModel(String propertyId, String propertyAddress, double propertyRentalAmount, String agentName) {
        this.propertyId = propertyId;
        this.propertyAddress = propertyAddress;
        this.propertyRentalAmount = propertyRentalAmount;
        this.agentName = agentName;
    }

    // Getters and Setters
    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public double getPropertyRentalAmount() {
        return propertyRentalAmount;
    }

    public void setPropertyRentalAmount(double propertyRentalAmount) {
        this.propertyRentalAmount = propertyRentalAmount;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * Overrides the default toString method to match the assignment sample format.
     * 
     * @return Formatted property information string.
     */
    @Override
    public String toString() {
        return "PROPERTY ID: " + propertyId +
               "\nPROPERTY ADDRESS: " + propertyAddress +
               "\nPROPERTY RENTAL AMOUNT: R" + propertyRentalAmount +
               "\nPROPERTY AGENT: " + agentName;
    }
}