package hw7.Factories;

public class FactoryProvider {
    public static VehicleFactory getFactory(String choice) {
        if ("Car".equalsIgnoreCase(choice))
            return new CivilServiceStation();

        return null;
    }
}
