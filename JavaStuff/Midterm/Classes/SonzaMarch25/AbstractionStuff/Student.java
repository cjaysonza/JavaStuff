public class Student extends Person{
    String studentID;

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String name, String address, String age) {
        super(name, address, age);
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public Student(){
        super();
    }

    @Override
    public String intro(){
        return "Welcome To School, Student";
    }
    
}
