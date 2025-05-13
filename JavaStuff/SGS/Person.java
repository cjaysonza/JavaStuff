public abstract class Person {
    public String surname;
    public String firstname;

    public Person() {}

    public Person(String surname, String firstname) {
        this.surname = surname;
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
