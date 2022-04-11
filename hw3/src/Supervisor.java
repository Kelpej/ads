public class Supervisor extends Person{
    public Supervisor(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void startWork() {
        System.out.println(super.getName() + " прийшов на робоче місце, вдягнув форму та підготував ласощі для тваринок.");
    }

    @Override
    public void endWork() {
        System.out.println("Закінчивши свою роботу, " + getPosition() + ' ' + getName() + " попрощався зі звірями та іншим персоналом.");
    }

    public void feed(Animal animal) {
        System.out.println(super.getName() + " підійшов до вольєру, де живе " + animal.getName() + "та пригостив її/його.");
        animal.eat();
    }

    public void makeGuidedTour() {
        System.out.println("Після чого " + super.getName() + " провів відвідувачам захоплюючу екскурсію, розповівши детально про кожного мешканця зоопарку.");
    }
}
