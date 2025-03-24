import java.util.Random;

public class Drink {
    protected String name;
    protected double liters;
    protected boolean bottled;
    protected double price; 

    public Drink(String name, double liters, boolean bottled) {
        this.name = toTitleCase(name);
        this.liters = liters;
        this.bottled = bottled;

        // NOTE: Random() is part of java.util
        this.price = new Random().nextDouble() * (10 - 3) + 3; // Random price between $3 - $10
    }

    public String introduction(){
        return "This drink is called " + name + ", with " + liters + "L, " + (bottled ? "bottled" : "not bottled");
    }

    protected String toTitleCase(String input) {
        return Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
    }
}
