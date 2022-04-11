public class Test {
    public static final int test() {
        int i = 5;
        return i /= 2;
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
