package pr11;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

public class Student {
    private String name;
    private int major;
    private int group;
    private double gpa;
    private String address;

    @Override
    public String toString() {
        return "Student {" + '\n' +
                "name: " + name + '\n' +
                "major: " + major + '\n' +
                "group: " + group + '\n' +
                "gpa: " + gpa + '\n' +
                "address: " + address + '\n' +
                '}';
    }

    public static List<Student> readStudents() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/pr11/students.json"));
            List<Student> students = new Gson().fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            reader.close();
            return students;
        } catch (IOException io) {
            io.printStackTrace();
        }
        return null;
    }

    public Student(String name, int major, int group, double gpa, String address) {
        this.name = name;
        this.major = major;
        this.group = group;
        this.gpa = gpa;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
