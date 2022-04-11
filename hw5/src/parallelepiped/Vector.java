package parallelepiped;

class Vector {
  double x, y, z;
  double length;

  public Vector(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
    length = calcLength(x, y, z);
  }

  public Vector(Point a, Point b) {
    x = b.x - a.x;
    y = b.y - a.y;
    z = b.z - a.z;
    length = calcLength(a, b);
  }

  public static double angle(Vector a, Vector b) {
    return Math.acos((a.x * b.x + a.y * b.y + a.z * b.z)/(a.length * b.length));
  }

  private static double calcLength(double x, double y, double z) {
    return Math.sqrt(x*x + y*y + z*z);
  }

  private static double calcLength(Point a, Point b) {
    return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2) + Math.pow(b.z - a.z, 2));
  }

  public double[] getCoordinates() {
    return new double[] {x, y, z};
  }
}
