import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Property class manages the collection of PropertyModel objects in memory.
 * Contains all mandatory operations and validation logic per the assignment specification.
 */
public class Property {
    private ArrayList<PropertyModel> propertyList;
    private Scanner scanner;

    /**
     * Default Constructor initializing the property array list and scanner input.
     */
    public Property() {
        this.propertyList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Getter for property list (utilised by unit tests).
     * @return propertyList
     */
    public ArrayList<PropertyModel> getPropertyList() {
        return propertyList;
    }

    /**
     * 1.2 & 1.4: Prompts the user to enter new property details and saves to memory.
     */
    public void EnterProperty() {
        System.out.println("\nENTER A NEW PROPERTY FOR RENTAL");
        System.out.println("******************************************");

        System.out.print("Enter the property id: ");
        String id = scanner.nextLine();

        System.out.print("Enter the property address: ");
        String address = scanner.nextLine();

        double rentalAmount = PropertyAmountValidation();

        System.out.print("Enter the property agent: ");
        String agent = scanner.nextLine();

        PropertyModel newProperty = new PropertyModel(id, address, rentalAmount, agent);
        propertyList.add(newProperty);

        System.out.println("New property processed successfully!!!");
    }

    /**
     * 1.3: Interactive validation method ensuring rental amount is numeric and >= R1 500.
     * 
     * @return Validated double rental amount.
     */
    public double PropertyAmountValidation() {
        System.out.print("Enter the property rental price per month: ");
        while (true) {
            String input = scanner.nextLine();
            try {
                double amount = Double.parseDouble(input);
                if (validateRentalAmount(amount)) {
                    return amount;
                } else {
                    System.out.println("You have entered an invalid amount!!!");
                    System.out.print("Please re-enter the property rental amount >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an invalid amount!!!");
                System.out.print("Please re-enter the property rental amount >> ");
            }
        }
    }

    /**
     * Core business logic validator for rental amounts (used for unit testing).
     * 
     * @param amount The rental amount to test.
     * @return true if amount >= 1500; false otherwise.
     */
    public boolean validateRentalAmount(double amount) {
        return amount >= 1500.0;
    }

    /**
     * 1.5: Searches for a property by ID and displays details or a not found message.
     */
    public void SearchProperty() {
        System.out.print("\nEnter the property id to search: ");
        String id = scanner.nextLine();
        PropertyModel found = findPropertyById(id);

        if (found != null) {
            System.out.println("----------------------------------------");
            System.out.println(found);
            System.out.println("----------------------------------------");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("Rental property with property Id: " + id + " was not found!");
            System.out.println("----------------------------------------");
        }
    }

    /**
     * 1.6: Updates address, rental amount, and agent for an existing property.
     */
    public void UpdateProperty() {
        System.out.print("\nEnter the property id to update: ");
        String id = scanner.nextLine();
        PropertyModel found = findPropertyById(id);

        if (found == null) {
            System.out.println("Rental property with property Id: " + id + " was not found!");
            return;
        }

        System.out.print("Enter the property address: ");
        String address = scanner.nextLine();

        double rentalAmount = PropertyAmountValidation();

        System.out.print("Enter the property agent: ");
        String agent = scanner.nextLine();

        boolean updated = performUpdate(id, address, rentalAmount, agent);
        if (updated) {
            System.out.println("Property updated successfully!!!");
        }
    }

    /**
     * Logic method to perform update on property in memory (used by unit tests).
     */
    public boolean performUpdate(String id, String newAddress, double newAmount, String newAgent) {
        PropertyModel prop = findPropertyById(id);
        if (prop != null && validateRentalAmount(newAmount)) {
            prop.setPropertyAddress(newAddress);
            prop.setPropertyRentalAmount(newAmount);
            prop.setAgentName(newAgent);
            return true;
        }
        return false;
    }

    /**
     * 1.7: Prompts for Property ID, requests confirmation, and deletes property if confirmed.
     */
    public void DeleteProperty() {
        System.out.print("\nEnter the property id to delete: ");
        String id = scanner.nextLine();
        PropertyModel found = findPropertyById(id);

        if (found == null) {
            System.out.println("Rental property with property Id: " + id + " was not found!");
            return;
        }

        System.out.print("Are you sure you want to delete property " + id + " from the system? Yes (y) to delete: ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("y")) {
            boolean deleted = performDelete(id);
            if (deleted) {
                System.out.println("Property with Property Id: " + id + " WAS deleted!");
            }
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    /**
     * Logic method to perform deletion from memory (used by unit tests).
     */
    public boolean performDelete(String id) {
        PropertyModel prop = findPropertyById(id);
        if (prop != null) {
            return propertyList.remove(prop);
        }
        return false;
    }

    /**
     * 1.8: Prints a structured report of all properties currently stored in memory.
     */
    public void PropertyRentalReport() {
        if (propertyList.isEmpty()) {
            System.out.println("\nNo property data found.");
            return;
        }

        for (int i = 0; i < propertyList.size(); i++) {
            System.out.println("\nProperty " + (i + 1));
            System.out.println("----------------------------------------");
            System.out.println(propertyList.get(i));
            System.out.println("----------------------------------------");
        }
    }

    /**
     * Exits the application gracefully.
     */
    public void ExitPropertyApplication() {
        System.out.println("\nExiting Application. Goodbye!");
        System.exit(0);
    }

    /**
     * Helper method to search for a property by its ID.
     * 
     * @param id Property ID to search for.
     * @return Matched PropertyModel object or null if not found.
     */
    public PropertyModel findPropertyById(String id) {
        for (PropertyModel p : propertyList) {
            if (p.getPropertyId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}