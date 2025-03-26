public class Staff extends Person{
    String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Staff(String position) {
        this.position = position;
    }

    public Staff(String name, String address, String age, String position) {
        super(name, address, age);
        this.position = position;
    }

    public Staff(){
        super();
    }

    public String intro(){
        return "Clocked in for Today";
    }
    
}
