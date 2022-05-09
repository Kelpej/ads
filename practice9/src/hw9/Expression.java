package hw9;

import java.util.Random;

public class Expression {
    private static Random ran = new Random();
    String equation;
    int operatorsNum;
    int maxNum;
    int expected;

    public Expression(int maxNum) {

        int choice = ran.nextInt(2);
        if (choice == 0) {
            int res = maxNum + 1;
            while (!(0 <= res && res <= maxNum)) {
                this.equation = "";
                res = ran.nextInt(maxNum + 1);
                equation += res;
                int op = ran.nextInt(2);
                int num = ran.nextInt(maxNum + 1);
                if (op == 0) {
                    equation += " - " + num;
                    res -= num;
                } else {
                    equation += " + " + num;
                    res += num;
                }
                op = ran.nextInt(2);
                num = ran.nextInt(maxNum + 1);
                if (op == 0) {
                    equation += " - " + num;
                    res -= num;
                } else {
                    equation += " + " + num;
                    res += num;
                }
                this.expected = res;
            }


        } else if (choice == 1) {
            int res = maxNum + 1;
            while (!(0 <= res && res <= maxNum)) {
                this.equation = "";
                res = ran.nextInt(maxNum + 1);
                equation += res;
                int op = ran.nextInt(2);
                int num = ran.nextInt(maxNum + 1);
                if (op == 0) {
                    equation += " - " + num;
                    res -= num;
                } else {
                    equation += " + " + num;
                    res += num;
                }
                op = ran.nextInt(2);
                num = ran.nextInt(maxNum + 1);
                if (op == 0) {
                    equation += " - " + num;
                    res -= num;
                } else {
                    equation += " + " + num;
                    res += num;
                }

                op = ran.nextInt(2);
                num = ran.nextInt(maxNum + 1);
                if (op == 0) {
                    equation += " - " + num;
                    res -= num;
                } else {
                    equation += " + " + num;
                    res += num;
                }
                this.expected = res;
            }
        }

    }

    @Override
    public String toString() {
        return equation;
    }

    public int getExpected() {
        return expected;
    }
}