import java.util.Arrays;
import java.util.Optional;

public class Task2 {
    private static Factorial[] factorials = new Factorial[20];

    private static Optional<Factorial> findFactorial(int parameter) {
        return Arrays.stream(factorials).filter(factorial -> factorial.getParameter() == parameter).findFirst();
    }

    public static void main(String[] args) {
        while (true) {
            int parameter = DataInput.checkInt(DataInput.getInt("\nEnter a parameter from 0 to 20: "), -1, 20);
            try {
                Optional<Factorial> cached = findFactorial(parameter);
                System.out.println("Factorial is found, here it is.");
                System.out.println(cached.get());
            } catch (Exception notFound) {
                try {
                    System.out.println("There is no cached value for parameter: " + parameter);
                    Optional<Factorial> cached = findFactorial(--parameter);
                    System.out.println("Trying to find for decremented parameter value.");
                    factorials[Factorial.counter++] = new Factorial(cached.get(), parameter);
                    System.out.println("Found decremented one, calculating.");
                } catch (Exception notFoundPrevious) {
                    System.out.println("Factorial is not found, calculating a new one.");
                    factorials[Factorial.counter++] = new Factorial(++parameter);
                }
            }
            System.out.println('\n' + Arrays.toString(factorials));
        }
    }
}