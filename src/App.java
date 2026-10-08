import java.util.Scanner;

/**
 * Main application driver for the Property Rental Application (PROG6112 - 2025).
 */
public class App {

    public static void main(String[] args) {
        Property propertyApp = new Property();
        Scanner input = new Scanner(System.in);

        System.out.println("PROPERTY RENTALS - 2025");
        System.out.println("******************************************");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String launch = input.nextLine();

        if (!launch.equals("1")) {
            System.exit(0);
        }

        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Enter new property.");
            System.out.println("(2) Search for property.");
            System.out.println("(3) Update property");
            System.out.println("(4) Delete a property.");
            System.out.println("(5) Print property report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.print(">> ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    propertyApp.EnterProperty();
                    break;
                case "2":
                    propertyApp.SearchProperty();
                    break;
                case "3":
                    propertyApp.UpdateProperty();
                    break;
                case "4":
                    propertyApp.DeleteProperty();
                    break;
                case "5":
                    propertyApp.PropertyRentalReport();
                    break;
                case "6":
                    propertyApp.ExitPropertyApplication();
                    break;
                default:
                    System.out.println("Invalid selection! Please select an option between 1 and 6.");
                    break;
            }
        }
    }
}