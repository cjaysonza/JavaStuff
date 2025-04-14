import java.util.Random;

class Guest extends Person {
    private String guestID;
    private String email;

    public Guest(String name, int age, String contactNumber, String email) {
        super(name, age, contactNumber);
        this.email = email;
        this.guestID = generateGuestID();
    }

    private String generateGuestID() {
        return "GUEST2025" + (new Random().nextInt(9000) + 1000);
    }

    public String getGuestID() {
        return guestID;
    }

    @Override
    public String summary() {
        return "Guest ID: " + guestID + "\nName: " + name + "\nAge: " + age + "\nContact: " + contactNumber + "\nEmail: " + email;
    }
}