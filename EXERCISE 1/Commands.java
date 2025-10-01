
// Command Pattern Example - Remote Control with User Input
import java.util.Scanner;

interface Command {
    void execute();
}

class Light {
    public void turnOn() { System.out.println("Light is ON"); }
    public void turnOff() { System.out.println("Light is OFF"); }
}

class Fan {
    public void start() { System.out.println("Fan is spinning"); }
    public void stop() { System.out.println("Fan stopped"); }
}

class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

class FanStartCommand implements Command {
    private Fan fan;
    public FanStartCommand(Fan fan) { this.fan = fan; }
    public void execute() { fan.start(); }
}

class FanStopCommand implements Command {
    private Fan fan;
    public FanStopCommand(Fan fan) { this.fan = fan; }
    public void execute() { fan.stop(); }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void pressButton() { command.execute(); }
}

public class Commands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        Fan fan = new Fan();
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.print("Enter command (lighton, lightoff, fanstart, fanstop, exit): ");
            String cmd = scanner.nextLine();
            switch (cmd.toLowerCase()) {
                case "lighton": remote.setCommand(new LightOnCommand(light)); break;
                case "lightoff": remote.setCommand(new LightOffCommand(light)); break;
                case "fanstart": remote.setCommand(new FanStartCommand(fan)); break;
                case "fanstop": remote.setCommand(new FanStopCommand(fan)); break;
                case "exit": scanner.close(); return;
                default: System.out.println("Unknown command"); continue;
            }
            remote.pressButton();
        }
    }
}
