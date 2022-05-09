package pr7;

public class Printer {

    private String model;

    public void printOut(Printable toPrint) {
        System.out.println('\n' + model + " starts printing. \n"
                + toPrint.print());
    }

    public Printer(String model) {
        this.model = model;
    }
}
