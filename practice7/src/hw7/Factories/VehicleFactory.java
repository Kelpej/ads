package hw7.Factories;

import hw7.Vehicles.Vehicle;

public interface VehicleFactory<T> {
     Vehicle createVechicle(String model, int productionYear);
}

