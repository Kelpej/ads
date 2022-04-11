abstract class Person {
    private String name;
    private String position;

    public Person(String name, int age, String position) {
        this.name = name;
        this.position = position;
    }

    public abstract void startWork();

    public abstract void endWork();

    public void greetPerson(Person another) {
        System.out.println(this.name + " вітається з " + another.name + '.');
    }

    public void greetBack() {
        System.out.println(this.name + " вітається у відповідь");
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
