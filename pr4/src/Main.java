import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static char[] encrypt(char[] input, int shift) {
        char[] result = new char[input.length];
        for (int i = 0; i < input.length; i++)
           result[i] = (char) (input[i] + shift);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter text: ");
            char[] input = scanner.nextLine().toCharArray();
            System.out.println("Enter shift: ");
            int shift = Integer.parseInt(scanner.nextLine());
            char[] encrypted = encrypt(input, shift);
            System.out.println(Arrays.toString(encrypted));
            System.out.println("Do you want to decrypt? (y/a): ");
            if (scanner.nextLine().equals("y")) {
                System.out.println("Enter shift: ");
                shift = Integer.parseInt(scanner.nextLine());
                System.out.println(encrypt(encrypted, -shift));
            }
        }
    }
}
