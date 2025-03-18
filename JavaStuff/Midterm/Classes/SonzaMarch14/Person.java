

public class Person {
    String name;
    String age;
    String address;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    
    public Person() {
    }

    // public static void intro() {
    //     JOptionPane.showMessageDialog(null,
    //         "Hello, I am " + getName() +
    //         "I am " + getAge() +
    //         "I live in " + getAddress()
    //     );
    // }
}
