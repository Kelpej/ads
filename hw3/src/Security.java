public class Security extends Person{
    public Security(String name, int age, String position) {
        super(name, age, position);
    }

    @Override
    public void startWork() {
        System.out.println("Охоронець " + super.getName() + " заступив на чергування.");
    }

    @Override
    public void endWork() {
        System.out.println(super.getName() + " пішов з чергування та поїхав додому.");
    }
}
