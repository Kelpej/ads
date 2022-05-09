package hw7.Factories;

import hw7.Vehicles.Tank;
import hw7.Vehicles.Vehicle;

public class TankServiceStation implements VehicleFactory<Tank> {
    public TankServiceStation() {
    }

    @Override
    public Vehicle createVechicle(String model, int productionYear) {
        return new Tank(model, productionYear);
    }
}
