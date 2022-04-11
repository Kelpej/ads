import car.Car;
import car.Engine;
import car.Seat;
import car.Wheel;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    static class Owner {
        String name;
        Car hisCar;
        boolean key;

        public Owner(String name, Car hisCar) {
            this.name = name;
            this.hisCar = hisCar;
        }

        public Owner(String name, Car hisCar, boolean key) {
            this.name = name;
            this.hisCar = hisCar;
            this.key = key;
        }

        public void loseKey() {
            this.key = false;
        }

        public void findKey() {
            this.key = true;
        }

        public void startCar() {
            hisCar.start(key);
        }
    }

    public static void main(String[] args) {
        Engine engine = new Engine(800, 6);
        Object[][] seat_param = {{"Porsche", "leather", true},
                                {"Porsche", "leather", false},
                                {"BMW", "velour", false}};
        Seat[] seats = Arrays.stream(seat_param)
                .map(s -> new Seat(s))
                .collect(Collectors.toList())
                .toArray(new Seat[0]);

        Object[][] wheels_param = new Object[][] {{"Porsche", 32, "chromium"},
                                            {"Porsche", 32, "chromium"},
                                            {"Porsche", 32, "chromium"},
                                            {"Porsche", 32, "chromium"}};
        Wheel[] wheels = Arrays.stream(wheels_param)
                .map(w -> new Wheel(w))
                .collect(Collectors.toList())
                .toArray(new Wheel[0]);

        Car car = new Car("Lada", "Priora", engine, wheels, seats);
        System.out.println(car);

        Car carWithOneSeat = new Car("Deawoo", "Lanos", engine, wheels, new Seat("Deawoo", "paralon", false));
        System.out.println(carWithOneSeat);

        Owner Vladik = new Owner("Vladik", car);
        Vladik.startCar();
        Vladik.findKey();
        Vladik.startCar();
    }
}
