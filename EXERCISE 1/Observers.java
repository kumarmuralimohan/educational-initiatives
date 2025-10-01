
// Observer Pattern Example - News Channel with User Input
import java.util.*;

interface Observer {
    void update(String news);
}

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String news);
}

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }

    public void notifyObservers(String news) {
        for (Observer o : observers) {
            o.update(news);
        }
    }

    public void setNews(String news) {
        System.out.println("Agency publishes: " + news);
        notifyObservers(news);
    }
}

class NewsChannel implements Observer {
    private String name;
    public NewsChannel(String name) { this.name = name; }

    public void update(String news) {
        System.out.println(name + " breaking news: " + news);
    }
}

public class Observers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsAgency agency = new NewsAgency();

        System.out.print("Enter channel names (comma separated): ");
        String[] channels = scanner.nextLine().split(",");
        for (String c : channels) {
            agency.addObserver(new NewsChannel(c.trim()));
        }

        while (true) {
            System.out.print("Enter news update (or 'exit' to quit): ");
            String news = scanner.nextLine();
            if (news.equalsIgnoreCase("exit")) break;
            agency.setNews(news);
        }
        scanner.close();
    }
}
