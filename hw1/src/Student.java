import java.util.Arrays;

public class Student {

    String pib, faculty;
    int age, yofs, major;
    double average;
    int[] grades;

    public Student(String pib, int age, String faculty, int major, int yofs, int[] grades) {
        this.pib = pib;
        this.age = age;
        this.faculty = faculty;
        this.major = major;
        this.yofs = yofs;
        this.grades = grades;
        setAverage();
    }

    public String toString() {
        return "\nName: " + this.pib +
                "\nAge: " + this.age +
                "\nFaculty: " + this.faculty +
                "\nMajor: " + this.major +
                "\nYear: " + this.yofs +
                "\nGrades: " + Arrays.toString(this.grades) +
                "\nAverage: " + Math.ceil(average) ;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage() {
        int sum = 0;

        for (int grade : grades)
            sum += grade;
        this.average = sum / (double) grades.length;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setYofs(int yofs) {
        this.yofs = yofs;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String getPib() {
        return pib;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYofs() {
        return yofs;
    }

    public int getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }
}
