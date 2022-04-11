import java.util.Scanner;

public class Main {
    static int x1, y1, x2, y2, dx, dy;
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            Rectangle rect1 = createRect();
            System.out.println(rect1);
            Rectangle rect2 = createRect();
            System.out.println(rect2);
            System.out.println("Do you want to move first rectangle?");
            if (scanner.nextLine().equals("y")) {
                moveRect(rect1);
                System.out.println(rect1);
            }
            System.out.println("Do you want to move second rectangle?");
            if (scanner.nextLine().equals("y")) {
                moveRect(rect2);
                System.out.println(rect2);
            }
            System.out.println("Do you want to check a point?");
            if (scanner.nextLine().equals("y")) {
                int x = Integer.parseInt(scanner.nextLine());
                int y = Integer.parseInt(scanner.nextLine());
                if (rect1.isLaying(x, y))
                    System.out.println("The point is laying on the first rect.");
                else
                    System.out.println("The point is not laying on the first rect.");
                if (rect2.isLaying(x, y))
                    System.out.println("The point is laying on the second rect.");
                else
                    System.out.println("The point is not laying on the second rect.");
            }
            System.out.println("Merged:");
            System.out.println(rect1.merge(rect2));
            System.out.println("Intersection:");
            System.out.println(rect1.intersection(rect2));
            System.out.println();
        }
    }

    private static Rectangle createRect() {
        System.out.println("Enter x1: ");
        x1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter y1: ");
        y1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter x2: ");
        x2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter y2: ");
        y2 = Integer.parseInt(scanner.nextLine());
        return new Rectangle(x1, y1, x2, y2);
    }

    private static void moveRect(Rectangle rect) {
        System.out.println("Enter the shift by X axis: ");
        dx = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the shift by Y axis: ");
        dy = Integer.parseInt(scanner.nextLine());
        rect.move(dx, dy);
    }
}
