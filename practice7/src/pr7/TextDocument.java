package pr7;

public class TextDocument extends File implements Printable {
    public TextDocument(String name, double size) {
        this.name = name;
        this.size = size;
        this.format = "docx";
    }

    @Override
    public String print() {
        return "\"" + name + "." + format + "\"" + " is being printed.";
    }
}
