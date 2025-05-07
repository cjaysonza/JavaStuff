
import java.util.ArrayList;

public class TeachingStaff extends Person {
    private String staffID;
    private String department;
    private ArrayList<String> sectionsHandled;
    private ArrayList<String> coursesTaught;
    private String teachingRecord;
    private String password;
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TeachingStaff(
        String surname,
        String firstname, 
        String staffID,
        String password,
        String department,
        ArrayList<String> sectionsHandled,
        ArrayList<String> coursesTaught,
        String teachingRecord
    ) {
        super(surname, firstname);
        this.staffID = staffID;
        this.password = password;
        this.department = department;
        this.sectionsHandled = sectionsHandled;
        this.coursesTaught = coursesTaught;
        this.teachingRecord = teachingRecord;
    }

    public ArrayList<String> getSectionsHandled() {
        return sectionsHandled;
    }

    public void setSectionsHandled(ArrayList<String> sectionsHandled) {
        this.sectionsHandled = sectionsHandled;
    }
    public String getStaffID() {
        return staffID;
    }
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public ArrayList<String> getCoursesTaught() {
        return coursesTaught;
    }
    public void setCoursesTaught(ArrayList<String> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public String getTeachingRecord() {
        return teachingRecord;
    }

    public void setTeachingRecord(String teachingRecord) {
        this.teachingRecord = teachingRecord;
    }

    @Override
    public String toString() {
        return String.format(
            "Teaching Staff: %s, %s\nStaff ID: %s\nDepartment: %s\nSections Handled: %s\nCourses Taught: %s\nTeaching Record: %s",
            getSurname(), getFirstname(), staffID, department, sectionsHandled, coursesTaught, teachingRecord
        );
    }

    
}
