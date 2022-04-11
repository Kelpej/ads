public class Elephant extends Animal {
    private static final int hungerLimit = 100;
    private int option = 1;

    public Elephant(String name, int age, int hunger) {
        super(name, age, hunger);
    }

    @Override
    public void wakeUp() {
        System.out.println("З величчю Голіафа " + super.getName() + " підвівся на свої могутні ноги та привітав усіх гучним свистом.");
    }

    @Override
    public void eat() {
        if (super.getHunger() < 30) {
            System.out.println(super.getName() + " почувається справді голодним/-ою, тому з великим апетитом зʼїв/-ла величезний гарбуз.");
            super.setHunger(Math.min(super.getHunger() + 30, hungerLimit));
            super.printHunger(hungerLimit);
        } else {
            System.out.println(super.getName() + " не зовсім голодний/-а, тому відклав/-ла гарбуз на чорний день.");
            super.printHunger(hungerLimit);
        }
    }

    @Override
    public void idle() {
        switch (option) {
            default -> System.out.println(super.getName() + " задумливо малював картину своїм хоботом.");
        }
        option++;
    }

    @Override
    public String toString() {
        return "Слон " + super.getName() + ", " + getAge() + " років. " + (isSleeping() ? "Спить." : "Не спить.");
    }
}
