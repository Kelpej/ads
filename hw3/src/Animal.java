public abstract class Animal {
    private String name;
    private int age;
    private int hunger;
    private boolean isSleeping;
    private static int option = 1;

    public Animal(String name, int age, int hunger) {
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.isSleeping = false;
    }

    public abstract void wakeUp();

    public abstract void eat();

    public abstract void idle();

    void play(Animal another) {
        System.out.println(this.name + " почав/-ла гратись з " + another.name + '.');
    }

    void play(String toy) {
        System.out.println(this.name + " почав/-ла гратись з улюбленим " + toy + '.');
    }

    void printHunger(int hungerLimit) {
        System.out.println("Рівень голоду " + this.name + ": " + hunger + '/' + hungerLimit);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }
}
