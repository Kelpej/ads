package parallelepiped;

public class Point {
    double x, y, z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point createPoint() {
        double x = DataInput.getDouble("x -> ");
        double y = DataInput.getDouble("y -> ");
        double z = DataInput.getDouble("z -> ");
        return new Point(x, y, z);
    }

    public static Point getEndPoint(Point start, Vector vector) {
        return new Point(start.x + vector.x, start.y + vector.y, start.z + vector.z);
    }

    public double[] getCoordinates() {
        return new double[] {x, y, z};
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
