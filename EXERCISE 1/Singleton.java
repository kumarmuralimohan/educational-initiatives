
// Singleton Pattern Example - Logger with User Input
import java.util.Scanner;

class Logger {
    private static Logger instance;

    private Logger() { }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

public class Singleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        System.out.println("Enter three log messages:");
        for (int i = 0; i < 3; i++) {
            String msg = scanner.nextLine();
            logger.log(msg);
        }

        Logger another = Logger.getInstance();
        System.out.println("Singleton check: logger == another ? " + (logger == another));
        scanner.close();
    }
}
