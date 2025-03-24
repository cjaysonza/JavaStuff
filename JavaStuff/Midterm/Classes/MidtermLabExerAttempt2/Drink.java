import java.util.Random;

public class Drink {
    String name;
    double liters;
    boolean bottled;
    // The prices will just be random
    double price; 
    
    static int DrinkNo = 0;
    
    
    public Drink(){
        DrinkNo++;
    }
    
    // public Drink(){
    // }
    
    public Drink(String name) {
        this.name = name;
    }

    public Drink(String name, double liters) {
        this.name = name;
        this.liters = liters;
    }

    public static int getDrinkNo() {
        return DrinkNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLiters() {
        return liters;
    }

    public void setLiters(double liters) {
        this.liters = liters;
    }

    public boolean isBottled() {
        return bottled;
    }

    public void setBottled(boolean bottled) {
        this.bottled = bottled;
    }

    
    public Drink(String name, double liters, boolean bottled) {
        this.name = toTitleCase(name);
        this.liters = liters;
        this.bottled = bottled;
        // NOTE: Random() is part of java.util
        this.price = new Random().nextDouble() * (15 - 3) + 3; // Random price between $3 - $10
    }

    public String introduction(){
        return "This drink is called " + name + ", with " + liters + "L, " + (bottled ? "bottled" : "not bottled");
    }

    public String toTitleCase(String input) {
        return Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
    }

    public double getPrice() {
        return price;
    }

    // @Override
    // public String toString(){
    //     return String.format("%d %s %.2f%n", (getDrinkNo()+1), getName(), getPrice());
    // }

}
