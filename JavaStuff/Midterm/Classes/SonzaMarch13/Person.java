

public class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public Person(String line) {
    //     Scanner scanneer = new Scanner(line);
    //     // todo
    // }

    @Override
    public String toString() {
        return String.format("Person named %s", name);
    }
}
