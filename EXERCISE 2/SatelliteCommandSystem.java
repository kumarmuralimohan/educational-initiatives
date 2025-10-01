
// SatelliteCommandSystem.java
// Main application with clean menu loop (no while(true))
import java.util.Scanner;

public class SatelliteCommandSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Satellite satellite = new Satellite();
        CommandInvoker invoker = new CommandInvoker();
        boolean running = true;

        System.out.println("Satellite Command System started.");
        satellite.printStatus();

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Rotate");
            System.out.println("2. Activate Panels");
            System.out.println("3. Deactivate Panels");
            System.out.println("4. Collect Data");
            System.out.println("5. Show Status");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter direction (North/South/East/West): ");
                        String dir = scanner.nextLine();
                        invoker.runCommand(new RotateCommand(satellite, dir));
                        break;
                    case "2":
                        invoker.runCommand(new ActivatePanelsCommand(satellite));
                        break;
                    case "3":
                        invoker.runCommand(new DeactivatePanelsCommand(satellite));
                        break;
                    case "4":
                        invoker.runCommand(new CollectDataCommand(satellite));
                        break;
                    case "5":
                        satellite.printStatus();
                        break;
                    case "6":
                        running = false;
                        break;
                    default:
                        throw new InvalidCommandException("Invalid menu choice.");
                }
            } catch (InvalidCommandException e) {
                Logger.getInstance().log("Invalid input: " + e.getMessage());
            } catch (Exception e) {
                Logger.getInstance().log("Unexpected error: " + e.getMessage());
            }
        }

        System.out.println("Exiting Satellite Command System.");
        scanner.close();
    }
}
