package hw7;

import hw7.Factories.CivilServiceStation;
import hw7.Factories.TankServiceStation;
import hw7.Factories.VehicleFactory;
import hw7.Vehicles.Car;
import hw7.Vehicles.Tank;
import hw7.Vehicles.Vehicle;

import java.util.Arrays;

public class Main {
    private VehicleFactory<Tank> tankFactory = new TankServiceStation();
    private VehicleFactory<Car> carFactory = new CivilServiceStation();

    public static void main(String[] args) {
        Main application = new Main();
        Vehicle car = application.carFactory.createVechicle("Honda Civic", 2004);
        Vehicle tank = application.tankFactory.createVechicle("T-72 B3", 1984);

        Vehicle[] vehicles = {car, tank};
        Arrays.stream(vehicles).forEach(System.out::println);
    }

}
