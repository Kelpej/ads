package pr11;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private final int id;
    private final List<Student> students;

    private static final Comparator<Student> comparator = Comparator.comparingDouble(Student::getGpa);

    public Group(int id) {
        this.id = id;
        this.students = new ArrayList<>();
    }

    public Group(int id, List<Student> students) {
        this.id = id;
        this.students = students;
    }

    public static Group of (int id, Collection<Student> source) {
        ArrayList<Student> students = (ArrayList<Student>) source.stream()
                .filter(student -> student.getGroup() == id)
                .collect(Collectors.toList());
        return new Group(id, students);
    }

    public static List<Group> listOf(Collection<Student> source) {
        ArrayList<Group> groups = new ArrayList<>();
        Map<Integer, List<Student>> groupMap = source.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.toList()));

        for (Map.Entry<Integer, List<Student>> entry : groupMap.entrySet()) {
            groups.add(new Group(entry.getKey(), entry.getValue()));
        }

        return groups;
    }

    public Student getMax() {
        return Collections.max(this.students, comparator);
    }

    public Student getMin() {
        return Collections.min(this.students, comparator);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public int getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }
}
