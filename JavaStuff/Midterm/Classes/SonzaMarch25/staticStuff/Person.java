public class Person {
    String name;
    String address;
    String age;
    static int personCounter;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public Person(){
        personCounter++;
    }

    public Person(String name, String address, String age) {
        personCounter++;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    
}
