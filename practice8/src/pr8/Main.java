package pr8;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final String INPUT_ERROR = "You entered invalid data! Try again: ";
    private static final String WRONG_FORMAT = "You should use capital letters.";
    private static final String NAME = "Name of a student: ";
    private static final String MAJOR = "Major of a student: ";
    private static final String GROUP = "Group of a student: ";
    private static final String GPA = "GPA of a student: ";
    private static final String ADDRESS = "Address of a student: ";

    private static final String MORE_STUDENTS = "Do you want to add more students? (y/a): ";
    private static final String GET_MAX_MIN = "Do you want to get students with max and min GPA from each group? (y/a): ";
    private static final String MAX_MIN_TEMPLATE = "Max & Min from a group nuber %d: ";
    private static final String STOP = "Do you want to stop execution?: (y/a)?: ";

    private static Student createStudent() {
        System.out.println(NAME);
        String name = scanner.nextLine();
        while (!name.matches("[A-Z][a-z]+\\s[A-Z][a-z]+")) {
            System.err.println(WRONG_FORMAT);
            System.err.println(INPUT_ERROR);
            name = scanner.nextLine();
        }

        System.out.println(MAJOR);
        int major = Integer.parseInt(scanner.nextLine());
        while (major < 0) {
            System.out.println(INPUT_ERROR);
            major = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(GROUP);
        int group = Integer.parseInt(scanner.nextLine());
        while (group < 0) {
            System.err.println(INPUT_ERROR);
            group = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(GPA);
        double gpa = Double.parseDouble(scanner.nextLine());
        while (gpa < 0 && gpa > 100) {
            System.err.println(INPUT_ERROR);
            gpa = Integer.parseInt(scanner.nextLine());
        }

        System.out.println(ADDRESS);
        String address = scanner.nextLine();
        while (!address.matches("[A-Z][a-z]+")) {
            System.err.println(WRONG_FORMAT);
            System.err.println(INPUT_ERROR);
            address = scanner.nextLine();
        }

        return new Student(name, major, group, gpa, address);
    }
    public static void main(String[] args) {
        Student[] students = Student.readStudents();

        Group[] groups = Group.arrayOf(List.of(students));

        boolean flag = true;
        do {
            System.out.println(MORE_STUDENTS);
            if (scanner.nextLine().toLowerCase().equals("y")) {
                Student student = createStudent();
                Optional<Group> toAdd = Arrays.stream(groups).filter(group -> group.getId() == student.getGroup()).findAny();
                if (toAdd.isPresent()) {
                    toAdd.get().addStudent(student);
                } else {
                    List<Group> newGroups = List.of(groups);
                    Group newGroup = new Group(student.getGroup());
                    newGroup.addStudent(student);
                    newGroups.add(newGroup);
                    groups = newGroups.toArray(Group[]::new);
                }
            }
            System.out.println(GET_MAX_MIN);
            if (scanner.nextLine().toLowerCase().equals("y")) {
                Arrays.stream(groups).forEach(group -> {
                    System.out.println(String.format(MAX_MIN_TEMPLATE, group.getId()));
                    System.out.println(group.getMax());
                    System.out.println(group.getMin());
                });
            }

            System.out.println(STOP);
            if (scanner.nextLine().toLowerCase().equals("y"))
                flag = false;

        } while (flag);
    }
}

