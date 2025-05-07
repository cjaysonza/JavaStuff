import java.util.ArrayList;

public class Section {
    public String sectionName;
    public ArrayList<Student> students;

    public Section() {
        students = new ArrayList<>();
    }

    public Section(String sectionName) {
        this.sectionName = sectionName;
        this.students = new ArrayList<>();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    @Override
    public String toString() {
        String output = sectionName + "\n";
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            output += String.format("%d. %s, %s: %s\n", i, student.surname, student.firstname, student.getStudentID());
        }
        return output;
    }

}