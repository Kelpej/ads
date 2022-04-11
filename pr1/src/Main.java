import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            StudentsGrades grades = new StudentsGrades(inputGrades());

            System.out.println(grades);

            if (DataInput.getChar("\nDo you want to add any grades? (y/a): \n") == 'y') {
                grades.addGrades(inputGrades());
                System.out.println(grades);
            }

            if (DataInput.getChar("\nDo you want to sort ascending? (y/a): \n") == 'y') {
                grades.sortAscending();
            } else {
                grades.sortDescending();
            }

            System.out.println(grades);
    }

    private static int[] inputGrades() {
        int size = DataInput.checkInt(DataInput.getInt("Enter number of grades: "), 0, 100);

        int[] temp = new int[size];

        System.out.println("Enter values: ");

        for (int i = 0; i < temp.length; i++) {
            temp[i] = DataInput.getInt("");
        }
        return temp;
    }
}
