package pr8;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private int id;
    private List<Student> students;

    private static Comparator<Student> comparator = Comparator.comparingDouble(Student::getGpa);

    public Group() {}

    public Group(int id) {
        this.id = id;
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

    public static Group[] arrayOf(Collection<Student> source) {
        ArrayList<Group> groups = new ArrayList<>();
        Map<Integer, List<Student>> groupMap = source.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.toList()));

        for (Map.Entry<Integer, List<Student>> entry : groupMap.entrySet()) {
            groups.add(new Group(entry.getKey(), entry.getValue()));
        }

        return groups.toArray(Group[]::new);
    }

    public Student getMax() {
        return Collections.max(this.students, comparator);
    }

    public Student getMin() {
        return Collections.min(this.students, comparator);
    }

    public boolean addStudent(Student student) {
       return this.students.add(student);
    }

    public boolean addStudents(Student[] students) {
        return this.students.addAll(List.of(students));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
