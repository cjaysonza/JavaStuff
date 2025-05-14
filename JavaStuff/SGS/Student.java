import java.util.Arrays;
import java.util.Scanner;

public class Student extends Person {
    private String studentID;
    private String major;
    private String[] courses;
    private String[] letterGrades;
    private double[] numGrades;

    public Student(String surname, String firstname, String studentID, String major, String[] courses, String[] letterGrades, double[] numGrades) {
        super(surname, firstname);
        this.studentID = studentID;
        this.major = major;
        this.courses = courses;
        this.letterGrades = letterGrades;
        this.numGrades = numGrades;
    }

    // Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public String[] getLetterGrades() {
        return letterGrades;
    }

    public void setLetterGrades(String[] letterGrades) {
        this.letterGrades = letterGrades;
    }

    public double[] getNumGrades() {
        return numGrades;
    }

    public void setNumGrades(double[] numGrades) {
        this.numGrades = numGrades;
    }

    @Override
    public String toString() {
        return surname + ", " + firstname + ", " + studentID + ", " + major + ", " + Arrays.toString(courses).replaceAll(",", ";") + ", " + Arrays.toString(letterGrades).replaceAll(",", ";") + ", " + Arrays.toString(numGrades).replaceAll(",", ";");
    }

    public static Student fromString(String line) {
        Scanner scan = new Scanner(line);
        scan.useDelimiter(",");
        String surname = scan.next().trim();
        String firstname = scan.next().trim();
        String studentID = scan.next().trim();
        String major = scan.next().trim();
        String[] courses = Utility.parseArray(scan.next().trim());
        String[] letterGrades = new String[]{"--", "--", "--", "--", "--", "--"};
        double[] numGrades = new double[]{0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
        if (scan.hasNext()) {
            letterGrades = Utility.parseArray(scan.next().trim());
            numGrades = Utility.parseDoubleArray(scan.next().trim());
        }
        scan.close();
        return new Student(surname, firstname, studentID, major, courses, letterGrades, numGrades);
    }

    // public static String getFullName(Student student) {
    //     return student.getFirstname() + " " + student.getSurname();
    // }
}
