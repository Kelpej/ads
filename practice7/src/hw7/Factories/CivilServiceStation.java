package hw7.Factories;

import hw7.Vehicles.Car;
import hw7.Vehicles.Vehicle;

public class CivilServiceStation implements VehicleFactory<Car> {
    @Override
    public Vehicle createVechicle(String model, int productionYear) {
        return new Car(model, productionYear);
    }
}
