
// Satellite.java
// Satellite state with defensive programming
import java.util.Arrays;

public class Satellite {
    private String orientation;
    private boolean panelsActive;
    private int dataCollected;

    public Satellite() {
        this.orientation = "North";
        this.panelsActive = false;
        this.dataCollected = 0;
    }

    public void rotate(String direction) throws InvalidCommandException {
        if (direction == null || direction.isBlank()) {
            throw new InvalidCommandException("Direction cannot be empty.");
        }
        if (Arrays.asList("North", "South", "East", "West").contains(direction)) {
            orientation = direction;
            Logger.getInstance().log("Satellite rotated to " + direction);
        } else {
            throw new InvalidCommandException("Invalid direction: " + direction);
        }
    }

    public void activatePanels() {
        if (!panelsActive) {
            panelsActive = true;
            Logger.getInstance().log("Solar panels activated.");
        } else {
            Logger.getInstance().log("Panels already active.");
        }
    }

    public void deactivatePanels() {
        if (panelsActive) {
            panelsActive = false;
            Logger.getInstance().log("Solar panels deactivated.");
        } else {
            Logger.getInstance().log("Panels already inactive.");
        }
    }

    public void collectData() {
        if (panelsActive) {
            boolean success = false;
            for (int i = 0; i < 3; i++) { // retry logic
                try {
                    dataCollected += 10;
                    Logger.getInstance().log("Data collected. Total = " + dataCollected);
                    success = true;
                    break;
                } catch (Exception e) {
                    Logger.getInstance().log("Transient error in data collection, retrying...");
                }
            }
            if (!success) {
                Logger.getInstance().log("Failed to collect data after retries.");
            }
        } else {
            Logger.getInstance().log("Error: Cannot collect data, panels inactive.");
        }
    }

    public void printStatus() {
        System.out.println("=== Satellite Status ===");
        System.out.println("Orientation: " + orientation);
        System.out.println("Solar Panels: " + (panelsActive ? "Active" : "Inactive"));
        System.out.println("Data Collected: " + dataCollected);
        System.out.println("========================");
    }
}
