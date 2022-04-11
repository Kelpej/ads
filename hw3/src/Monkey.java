public class Monkey extends Animal {
    private static final int hungerLimit = 50;
    private static int option = 1;

    public Monkey(String name, int age, int hunger) {
        super(name, age, hunger);
    }

    @Override
    public void wakeUp() {
        System.out.println(super.getName() +
                " прокидається у своєму вольєрі та вальяжно спускається з кремезного дерева, що слугує їй і домом, і парком розваг.");
    }

    @Override
    public void eat() {
        if (super.getHunger() < 30) {
            System.out.println(super.getName() + " почувається справді голодним/-ою, тому з превеликим завзяттям зʼїв/-ла обідню порцію бананів.");
            super.setHunger(Math.min(super.getHunger() + 20, hungerLimit));
            super.printHunger(hungerLimit);
        } else {
            System.out.println(super.getName() + " не зовсім голодний/-а, тому відклав/-ла банани до свого сховку.");
            super.printHunger(hungerLimit);
        }
    }

    @Override
    public void idle() {
        switch (option) {
            case 1 -> System.out.println(super.getName() + " весело хитався/-лась на гілці.");
            case 2 -> System.out.println(super.getName() + " вражав/-ла глядачів своєю емоційністю.");
        }
        option++;
    }

    @Override
    public String toString() {
        return "Мавпа " + super.getName() + ", " + getAge() + " років. " + (isSleeping() ? "Спить." : "Не спить.");
    }
}
