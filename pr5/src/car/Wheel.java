package car;

public class Wheel {
    String brand;
    int diameter;
    String disc;

    public Wheel(int diameter, String brand, String disc) {
        this.brand = brand;
        this.diameter = diameter;
        this.disc = disc;
    }

    public Wheel(Object[] params) {
        this.brand = (String) params[0];
        this.diameter = (Integer) params[1];
        this.disc = (String) params[2];
    }

    @Override
    public String toString() {
        return "car.Wheel{" +
                "brand='" + brand + '\'' +
                ", diameter=" + diameter +
                ", disc='" + disc + '\'' +
                '}';
    }
}
