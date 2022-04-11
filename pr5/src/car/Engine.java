package car;

public class Engine {
    int horsePowers;
    int cylinders;
    String sound;

    private static final String POWERFUL_SOUND = "WRRRRRUMMM, WRRUMMM!";
    private static final String WEAK_SOUND = "Prrr-rrr, prr-r, pr!";


    public Engine(int horsePowers, int cylinders) {
        this.horsePowers = horsePowers;
        this.cylinders = cylinders;
        this.sound = horsePowers > 300 ? POWERFUL_SOUND : WEAK_SOUND;
    }

    @Override
    public String toString() {
        return "car.Engine{" +
                "horsePowers=" + horsePowers +
                ", cylinders=" + cylinders +
                '}';
    }
}
