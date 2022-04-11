import java.io.IOException;

public class Main {
    private static Student[] students;
    private static int length;

    public static void main(String[] args) throws Exception {
        while (true) {
            String[] lines;

            if (DataInput.getChar("Do you want to enter data manually?: ") == 'y') {
                students = manualInput();
            } else {
                lines = DataInput.readFile("stud.txt");
                length = lines.length;
                explode(lines);
            }
            if (DataInput.getChar("Do you want to sort by name? (y/a): ") == 'y')
                if (DataInput.getChar("Do you want to sort ascending? (y/a): ") == 'y') {
                    insertionSortAscendingByName(students);
                } else {
                    insertionSortDescendingByName(students);
                }
            else if (DataInput.getChar("Do you want to sort ascending? (y/a): ") == 'y') {
                insertionSortAscendingByGrades(students);
            } else {
                insertionSortDescendingByGrades(students);
            }
            output(students);
        }
    }
    
    private static void explode(String[] lines) {
        students = new Student[length];

        for (int i = 0; i < length; i++) {
            String[] temp = lines[i].split(" ");
            int[] grades = new int[temp.length - 7];

            for (int j = 7; j < temp.length; j++)
                grades[j-7] = Integer.parseInt(temp[j]);

            Student st = new Student(temp[0] + " " + temp[1] + " " + temp[2],
                    Integer.valueOf(temp[3]), temp[4], Integer.valueOf(temp[5]), Integer.valueOf(temp[6]), grades);
            students[i] = st;
        }
    }

    private static void output(Student[] students) {
        for (int i = 0; i < length; i++) {
            System.out.println(students[i].toString());
        }
    }

    private static Student[] manualInput() throws IOException {
        String pib, faculty;
        int age, major, yofs, mark;
        int[] grades;

        length = DataInput.checkInt(DataInput.getInt("Enter number of students: "), 0, 100);
        Student[] students = new Student[length];

        for (int i = 0; i < length; i++) {
            pib = DataInput.getString("\nEnter full name: ");
            while (pib.split(" ").length < 3)
                pib = DataInput.getString("Try again: ");

            age = DataInput.checkInt(DataInput.getInt("Enter age: "), 16, 100);
            faculty = DataInput.getString("Enter faculty: ");
            major = DataInput.checkInt(DataInput.getInt("Enter major: "), 1, 200);
            yofs = DataInput.checkInt(DataInput.getInt("Enter year of study: "), 1, 6);

            mark = DataInput.checkInt(DataInput.getInt("How many marks do you want to add?: "), 0, 10);
            grades = new int[mark];

            for (int j = 0; j < mark; j++) {
                grades[j] = (DataInput.checkInt(DataInput.getInt("Enter a grade: "), 0, 100));
            }

            students[i] = new Student(pib, age, faculty, major, yofs, grades);
        }
        return students;
    }

    private static void insertionSortAscendingByName(Student[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            Student currentValue = inputArray[i];
            int j = i - 1;

            while (j >= 0 && inputArray[j].pib.split(" ")[0].compareToIgnoreCase(currentValue.pib.split(" ")[0]) > 0) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
    }

    private static void insertionSortDescendingByName(Student[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            Student currentValue = inputArray[i];
            int j = i - 1;

            while (j >= 0 && inputArray[j].pib.split(" ")[0].compareToIgnoreCase(currentValue.pib.split(" ")[0]) < 0) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
    }

    private static void insertionSortAscendingByGrades(Student[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            Student currentValue = inputArray[i];
            int j = i - 1;

            while (j >= 0 && inputArray[j].getAverage() > currentValue.getAverage()) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
    }

    private static void insertionSortDescendingByGrades(Student[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            Student currentValue = inputArray[i];
            int j = i - 1;

            while (j >= 0 && inputArray[j].getAverage() < currentValue.getAverage()) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
    }

    private static void search() throws IOException {
        char search = DataInput.getString("Enter a first letter of a surname: ").charAt(0);
        for (Student st : students) {
            if (st.getPib().charAt(0) == search) {
                System.out.println(st);
            }
        }
    }
}