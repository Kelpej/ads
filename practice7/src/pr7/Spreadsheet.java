package pr7;

public class Spreadsheet extends File implements Printable{
    public Spreadsheet(String name, double size) {
        this.name = name;
        this.size = size;
        this.format = "xlxs";
    }

    @Override
    public String print() {
        return "\"" + name + "." + format + "\"" + " is being printed.";
    }
}
