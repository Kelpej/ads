package parallelepiped;

public class Parallelepiped {
    private Vector a, b, aa1;
    private double height, a1Angle, abAngle;
    private double baseArea, volume;

    public Parallelepiped(Point A, Point B, Point C, Point A1) {
        aa1 = new Vector(A, A1);
        if (A.getX() == A1.getX() && A.getY() == A1.getY())
            height = aa1.length;
        else
            throw new IllegalArgumentException("Цей конструктор призначений для прямого паралелепіпеда.");

        a = new Vector(B, A);
        b = new Vector(B, C);

        abAngle = Vector.angle(this.a, this.b);
        if (abAngle >= 180)
            throw new IllegalArgumentException("Кут " + abAngle + " між ребрами основи є неприпустимим.");

        a1Angle = 90;
        baseArea = a.length * b.length * Math.sin((Math.min(abAngle, Math.PI - abAngle)));
        volume = baseArea * height;
    }

    public Parallelepiped(Point B, Point A, Point D, double AA1, double AA1Angle) {
        if (AA1Angle <= 0 || AA1Angle > 90)
            throw new IllegalArgumentException("Кут " + AA1Angle + " є неприпустимим для паралелепіпеда.");
        else
            this.a1Angle = AA1Angle;

        this.a = new Vector(A, B);
        this.b = new Vector(A, D);

        this.abAngle = Vector.angle(a, b);
        if (abAngle >= 180)
            throw new IllegalArgumentException("Кут " + abAngle + " між ребрами основи є неприпустимим.");

        height = AA1 * Math.sin(Math.toRadians(AA1Angle));
        baseArea = a.length * b.length * Math.sin((Math.min(abAngle, Math.PI - abAngle)));
        volume = baseArea * height;
    }

    public Parallelepiped(Point A, double AB, double AD, double abAngle, double AA1, double AA1Angle) {
        if (AA1Angle <= 0 || AA1Angle > 90)
            throw new IllegalArgumentException("Кут " + AA1Angle + " є неприпустимим для паралелепіпеда.");
        else
            this.a1Angle = AA1Angle;

        if (abAngle >= 180)
            throw new IllegalArgumentException("Кут " + abAngle + " між ребрами основи є неприпустимим.");
        else
            this.abAngle = abAngle;

        height = AA1 * Math.sin(Math.toRadians(AA1Angle));
        baseArea = AB * AD * Math.sin((Math.min(abAngle, Math.PI - abAngle)));
        volume = baseArea * height;
    }

    public double getBaseArea() {
        return baseArea;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return String.format("Parallelepiped{" +
                "base area= " + "%.3f" + " " +
                "height= " + "%.3f" + " " +
                "volume= " + "%.3f" +
                '}',
                baseArea, height, volume);
    }
}
