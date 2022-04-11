import parallelepiped.DataInput;
import parallelepiped.Parallelepiped;
import parallelepiped.Point;

public class Main{
    public static void main(String[]args) {
        System.out.println("""
                   ________________
                  /⠡              / \\
               A1/__⠡____________/   \\
                 \\ B ⠡...........\\....\\ C
                  \\  ⠌            \\  /
                 A \\⠌______________\\/ D
                """);
        while (true) {
            System.out.println("""
                
                Оберіть з яким конструктором ви бажаєте працювати:
                1. Прямий паралелепіпед
                2. Похилий паралелепіпед (4 точки, довжина ребра та кут при основі)
                3. Похилий паралелепіпед (точка та два ребра основи, кут між ними)
                """);
            switch (DataInput.checkInt(DataInput.getInt("> "), 0, 3)) {
                case 1 -> {
                    System.out.println("Введіть координати точки A: ");
                    Point a = Point.createPoint();
                    System.out.println("Введіть координати точки B: ");
                    Point d = Point.createPoint();
                    System.out.println("Введіть координати точки C: ");
                    Point c = Point.createPoint();
                    System.out.println("Введіть координати точки A1: ");
                    Point a1 = Point.createPoint();
                    try {
                        Parallelepiped parallelepiped = new Parallelepiped(a, d, c, a1);
                        System.out.println(parallelepiped);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Введіть координати точки B: ");
                    Point b = Point.createPoint();
                    System.out.println("Введіть координати точки A: ");
                    Point a = Point.createPoint();
                    System.out.println("Введіть координати точки D: ");
                    Point d = Point.createPoint();
                    System.out.println("Введіть довжину ребра AA1: ");
                    double aa1 = DataInput.checkDouble(DataInput.getDouble("AA1 length -> "), 0);
                    System.out.println("Введіть кут нахилу ребра AA1: ");
                    double aa1Angle = DataInput.checkDouble(DataInput.getDouble("AA1 angle -> "), 0, 90);
                    try {
                        Parallelepiped parallelepiped = new Parallelepiped(b, a, d, aa1, aa1Angle);
                        System.out.println(parallelepiped);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Введіть координати точки A: ");
                    Point a = Point.createPoint();
                    System.out.println("Введіть довжину ребра AB: ");
                    double ab = DataInput.checkDouble(DataInput.getDouble("AB length -> "), 0);
                    System.out.println("Введіть довжину ребра AD: ");
                    double ad = DataInput.checkDouble(DataInput.getDouble("AD length -> "), 0);
                    System.out.println("Введіть кут BAD: ");
                    double abAngle = DataInput.checkDouble(DataInput.getDouble("BAD angle -> "), 0, 180);
                    System.out.println("Введіть довжину ребра AA1: ");
                    double aa1 = DataInput.checkDouble(DataInput.getDouble("AA1 length -> "), 0);
                    System.out.println("Введіть кут нахилу ребра AA1: ");
                    double aa1Angle = DataInput.checkDouble(DataInput.getDouble("AA1 angle -> "), 0, 90);
                    try {
                        Parallelepiped parallelepiped = new Parallelepiped(a, ab, ad, abAngle, aa1, aa1Angle);
                        System.out.println(parallelepiped);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }
}