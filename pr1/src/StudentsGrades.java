import java.util.Arrays;

public class StudentsGrades {
    int[] grades;
    int a = 90, b = 70, c = 59;
    static int max, min, belowAvg, aboveAvg, great, good, well, bad;
    static double avg;

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("\nStudentsGrades{" +
                "grades=" + Arrays.toString(grades) +
                '}');
        res.append("\nMax: " + StudentsGrades.max);
        res.append("\nMin: " + StudentsGrades.min);
        res.append("\nAverage: " + StudentsGrades.avg);
        res.append("\nStudents below average: " + StudentsGrades.belowAvg);
        res.append("\nStudents above average: " + StudentsGrades.aboveAvg);
        res.append("\nGreat marks: " + StudentsGrades.great);
        res.append("\nGood marks: " + StudentsGrades.good);
        res.append("\nNot bad marks: " + StudentsGrades.well);
        res.append("\nBad marks: " + StudentsGrades.bad + "\n");
        return res.toString();
    }

    public StudentsGrades(int[] grades) {
        this.grades = grades;
        setStaticFields();
    }

    public StudentsGrades() {
        this.grades = new int[10];
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
        setStaticFields();
    }

    private void fixGrades() {
        for (int i = 0; i < this.grades.length; i++) {
            if (this.grades[i] <= 0) {
                this.grades[i] = 0;
            } else if (this.grades[i] > 100) {
                this.grades[i] = 100;
            }
        }
    }

    public void sortAscending() {
        int temp;
        for (int i = 0; i < grades.length - 1; i++) {
            for (int j = 0; j < grades.length - i - 1; j++) {
                if (grades[j] > grades[j + 1]) {
                    temp = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = temp;
                }
            }
        }
    }

    public void sortDescending() {
        int temp;
        for (int i = 0; i < grades.length - 1; i++) {
            for (int j = 0; j < grades.length - i - 1; j++) {
                if (grades[j] < grades[j + 1]) {
                    temp = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = temp;
                }
            }
        }
    }

    public int[] getGrades() {
        return grades;
    }

    public void addGrade(int n) {
        int[] temp = Arrays.copyOf(this.grades, this.grades.length + 1);
        temp[temp.length-1] = n;
        this.grades = temp;
        setStaticFields();
    }

    public void addGrades(int[] n) {
        int[] temp = Arrays.copyOf(this.grades, this.grades.length + n.length);
        int count = 0;
        for (int i = this.grades.length; i < temp.length; i++) {
            temp[i] = n[count];
            count++;
        }
        this.grades = temp;
        setStaticFields();
    }

    private void setStaticFields() {
        fixGrades();
        setMax();
        setMin();
        setAvg();
        numAvg();
        setPerformance();
    }

    private void setMax() {
        int mark = this.grades[0];
        for (int i = 1; i < this.grades.length; i++) {
            if (this.grades[i] > mark) {
                mark = this.grades[i];
            }
        }
        max = mark;
    }

    private void setMin() {
        int mark = this.grades[0];
        for (int i = 1; i < this.grades.length; i++) {
            if (this.grades[i] < mark) {
                mark = this.grades[i];
            }
        }
        min = mark;
    }

    private void setPerformance() {
        bad = 0;
        well = 0;
        good = 0;
        great = 0;

        for (int i : this.grades) {
            if (i <= c) {
                bad++;
            } else if (i > c && i < b) {
                well++;
            } else if(i >= b && i <= a) {
                good++;
            }else if (i > a) {
                great++;
            }
        }
    }

    private void setAvg() {
        int sum = 0;
        for (int i : this.grades) {
            sum += i;
        }
        avg = sum / (double) this.grades.length;
    }

    private void numAvg() {
        belowAvg = 0;
        aboveAvg = 0;

        for (int i : this.grades) {
            if (i < avg) {
                belowAvg++;
            } else {
                aboveAvg++;
            }
        }
    }

}
