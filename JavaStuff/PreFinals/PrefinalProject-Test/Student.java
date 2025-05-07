import java.util.Arrays;

public class Student extends Person {
    private String studentID;
    private String major;
    private String[] courses;
    private String[] letterGrades;
    private double[] numGrades;

    public Student() {
        this.courses = new String[6];
        this.letterGrades = new String[]{"--", "--", "--", "--", "--", "--"};
        this.numGrades = new double[]{0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
    }

    public Student(String surname, String firstname, String studentID, String major, String[] courses) {
        super(surname, firstname);
        this.studentID = studentID;
        this.major = major;
        this.courses = courses;
        this.letterGrades = new String[]{"--", "--", "--", "--", "--", "--"};
        this.numGrades = new double[]{0.00, 0.00, 0.00, 0.00, 0.00, 0.00};
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
        return surname + ", " + firstname + ", " + studentID + ", " + major + ", " + Arrays.toString(courses) + ", " + Arrays.toString(letterGrades) + ", " + Arrays.toString(numGrades);
    }
}
