public class Main {

    public static void main(String[] args) {
        TextDocument report = new TextDocument("zvit", 45);
        Spreadsheet tables = new Spreadsheet("tablici", 32);

        System.out.println(report);
        System.out.println(tables);

        Printer printer = new Printer("HP LaserJet");
        printer.printOut(report);
        printer.printOut(tables);
    }
}
