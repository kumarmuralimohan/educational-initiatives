
// Decorator Pattern Example - Notifier with User Input
import java.util.Scanner;

interface Notifier {
    void send(String message);
}

class BasicNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Basic Notification: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;
    public NotifierDecorator(Notifier notifier) { this.wrappee = notifier; }
    public void send(String message) { wrappee.send(message); }
}

class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(Notifier notifier) { super(notifier); }
    public void send(String message) {
        super.send(message);
        System.out.println("SMS sent: " + message);
    }
}

class EmailDecorator extends NotifierDecorator {
    public EmailDecorator(Notifier notifier) { super(notifier); }
    public void send(String message) {
        super.send(message);
        System.out.println("Email sent: " + message);
    }
}

public class Decorator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your message: ");
        String msg = scanner.nextLine();

        Notifier notifier = new BasicNotifier();
        System.out.print("Add SMS? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            notifier = new SMSDecorator(notifier);
        }
        System.out.print("Add Email? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            notifier = new EmailDecorator(notifier);
        }

        notifier.send(msg);
        scanner.close();
    }
}
