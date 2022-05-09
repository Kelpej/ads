package hw7.Vehicles;

public class Tank implements Vehicle {
    String model;
    int productionYear;

    public Tank(String model, int productionYear) {
        this.productionYear = productionYear;
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(String.format("%s (%d) tank was started and ready to battle", model, productionYear));
    }

    @Override
    public void accelerate() {
        System.out.println(model + " is gaining speed.");
    }

    @Override
    public void brake() {
        System.out.println(model + " stopped.");
    }

    @Override
    public String toString() {
        return "Tank{" +
                "productionYear=" + productionYear +
                ", model='" + model + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}
