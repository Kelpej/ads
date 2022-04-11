import java.math.BigInteger;

public class Factorial {
    private int parameter;
    private BigInteger value;
    public static int counter;

    public Factorial(int parameter) {
        this.parameter = parameter;
        this.value = calc();
    }

    public Factorial(Factorial factorial, int parameter) {
        this.parameter = ++parameter;
        this.value = calc(factorial, this.parameter);
    }

    public BigInteger calc() {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= parameter; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public BigInteger calc(Factorial factorial, int parameter) {
        BigInteger result = factorial.getValue().multiply(BigInteger.valueOf(parameter));
        return result;
    }

    @Override
    public String toString() {
        return "Factorial{" +
                "parameter=" + parameter +
                ", value=" + value +
                '}';
    }

    public int getParameter() {
        return parameter;
    }

    public BigInteger getValue() {
        return value;
    }
}
