public class Task1 {
    public static void main(String[] args) {
        while (true) {
            int param = DataInput.checkInt(DataInput.getInt("Enter a parameter from 0 to 50: "), -1, 50);
            Factorial factorial = new Factorial(param);
            System.out.println(factorial);
        }
    }
}
