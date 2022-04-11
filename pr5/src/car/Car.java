package car;

import java.util.Arrays;

public class Car extends Vehicle{
    Engine engine;
    Seat[] seats;
    Wheel[] wheels;

    public Car(String brand, String model, Engine engine, Wheel[] wheels, Seat... seats) {
        super.brand = brand;
        super.model = model;
        this.engine = engine;
        this.seats = seats;
        this.wheels = wheels;
    }

    public void start() {
        System.out.println(engine.sound);
    }

    public void start(boolean withKey) {
        if (withKey)
            System.out.println(engine.sound);
        else
            System.out.println("А голову ти вдома не забув?");
    }

    @Override
    public String toString() {
        return "car.Car{\n" +
                "brand= " + brand + ", " +
                "model= " + model + ", " +
                "\n engine=" + engine +
                ", \nseats=" + Arrays.toString(seats) +
                ", \nwheels=" + Arrays.toString(wheels) +
                '}';
    }
}
