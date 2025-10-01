
// CommandInvoker.java
public class CommandInvoker {
    public void runCommand(Command command) {
        try {
            command.execute();
        } catch (Exception e) {
            Logger.getInstance().log("Exception: " + e.getMessage());
        }
    }
}
