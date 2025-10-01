
// Factory Pattern Example - Notification Factory with User Input
import java.util.Scanner;

interface Notification {
    void notifyUser(String message);
}

class EmailNotification implements Notification {
    public void notifyUser(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotification implements Notification {
    public void notifyUser(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class PushNotification implements Notification {
    public void notifyUser(String message) {
        System.out.println("Push notification: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        switch (type.toLowerCase()) {
            case "email": return new EmailNotification();
            case "sms": return new SMSNotification();
            case "push": return new PushNotification();
            default: throw new IllegalArgumentException("Unknown notification type");
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter notification type (email/sms/push): ");
        String type = scanner.nextLine();
        System.out.print("Enter message to send: ");
        String msg = scanner.nextLine();

        try {
            Notification notification = NotificationFactory.createNotification(type);
            notification.notifyUser(msg);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
