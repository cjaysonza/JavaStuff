// Juice.java
import java.util.Random;

public class Juice {
    private String name, brand, flavor;
    private boolean hasPulp;
    private double price;
    
    public Juice(){
    }

    public Juice(String name, String brand, String flavor, boolean hasPulp) {
        this.name = toProperCase(name);
        this.brand = brand;
        this.flavor = flavor;
        this.hasPulp = hasPulp;
        this.price = generateRandomPrice();
    }
    
    public String introduce() {
        return "Juice: " + name + " (Brand: " + brand + ", Flavor: " + flavor + ", Pulp: " + (hasPulp ? "Yes" : "No") + ") - $" + price;
    }
    
    private String toProperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    
    private double generateRandomPrice() {
        return 2.0 + new Random().nextDouble() * 10.0;
    }
}