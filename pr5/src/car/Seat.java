package car;

public class Seat {
    String brand;
    String material;
    boolean adjustable;

    public Seat(String brand, String material, boolean adjustable) {
        this.brand = brand;
        this.material = material;
        this.adjustable = adjustable;
    }

    public Seat(Object[] params) {
        this.brand = (String) params[0];
        this.material = (String) params[1];
        this.adjustable = (Boolean) params[2];
    }

    @Override
    public String toString() {
        return "car.Seat{" +
                "brand='" + brand + '\'' +
                ", material='" + material + '\'' +
                ", adjustable=" + adjustable +
                '}';
    }
}
