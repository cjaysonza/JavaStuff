public class Student extends Person{

    // SETTERS
    public String getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public String getSection() {
        return section;
    }

    public int getYrlvl() {
        return yrlvl;
    }

    
    // GETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setYrlvl(int yrlvl) {
        this.yrlvl = yrlvl;
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String course) {
        this.id = id;
        this.course = course;
    }

    public Student(String id, String course, String section) {
        this.id = id;
        this.course = course;
        this.section = section;
    }

    public Student(String id, String course, String section, int yrlvl) {
        this.id = id;
        this.course = course;
        this.section = section;
        this.yrlvl = yrlvl;
    }
    
    public Student(String id, String course, String section, int yrlvl, String name, String age, String address) {
        super(name, age, address);
        this.id = id;
        this.course = course;
        this.section = section;
        this.yrlvl = yrlvl;
    }

    private String id;
    private String course;
    private String section;
    private int yrlvl;
}