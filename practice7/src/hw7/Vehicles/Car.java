package hw7.Vehicles;

public class Car implements Vehicle {
    String model;
    int productionYear;

    public Car() {
    }

    public Car(String model, int productionYear) {
        this.model = model;
        this.productionYear = productionYear;
    }

    @Override
    public void start() {
        System.out.println(model + "'s engine was started.");
    }

    @Override
    public void accelerate() {
        System.out.println(model + " car's speed is has increased.");
    }

    @Override
    public void brake() {
        System.out.println(model + " stopped.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
