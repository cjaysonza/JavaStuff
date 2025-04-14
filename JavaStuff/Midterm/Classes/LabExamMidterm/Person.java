public abstract class Person {
    protected String name;
    protected int age;
    protected String contactNumber;

    public Person(String name, int age, String contactNumber) {
        this.name = formatProperCase(name);
        this.age = age;
        this.contactNumber = contactNumber;
    }

    protected String formatProperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public abstract String summary();
}