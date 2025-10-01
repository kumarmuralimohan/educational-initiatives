
// Adapter Pattern Example - Legacy Temperature Sensor with User Input
import java.util.Scanner;

interface TemperatureSensor {
    double getTemperatureCelsius();
}

// Legacy class returns Fahrenheit
class LegacyTemperatureSensor {
    private double tempF;
    public LegacyTemperatureSensor(double tempF) { this.tempF = tempF; }
    public double getTemperatureFahrenheit() { return tempF; }
}

// Adapter converts Fahrenheit -> Celsius
class TemperatureAdapter implements TemperatureSensor {
    private LegacyTemperatureSensor legacySensor;

    public TemperatureAdapter(LegacyTemperatureSensor legacySensor) {
        this.legacySensor = legacySensor;
    }

    public double getTemperatureCelsius() {
        return (legacySensor.getTemperatureFahrenheit() - 32) * 5.0 / 9.0;
    }
}

public class Adapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = scanner.nextDouble();
        LegacyTemperatureSensor legacy = new LegacyTemperatureSensor(f);
        TemperatureSensor adapter = new TemperatureAdapter(legacy);

        System.out.printf("Temperature in Celsius: %.2f%n", adapter.getTemperatureCelsius());
        scanner.close();
    }
}
