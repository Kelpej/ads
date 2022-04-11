public abstract class File {
    protected String name;
    protected String format;
    protected double size;

    public String open() {
        return "\"" + name + "." + format + "\"" + " file is opened.";
    }

    public String delete() {
        return "\"" + name + "." + format + "\"" + " file was deleted.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "\nFile information: " + '\n' +
                "Name: " + name + '\n' +
                "Format: " + format + '\n' +
                "Size: " + size + " kb";
    }
}
