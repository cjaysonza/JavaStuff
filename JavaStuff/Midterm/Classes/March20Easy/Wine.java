// Wine.java
import java.util.Random;

public class Wine {
    private String name, brand, taste;
    private int quality;
    private double price;
    
    public Wine(){
        
    }

    public Wine(String name, String brand, String taste, int quality) {
        this.name = toProperCase(name);
        this.brand = brand;
        this.taste = taste;
        this.quality = quality;
        this.price = generateRandomPrice();
    }
    
    public String introduce() {
        return "Wine: " + name + " (Brand: " + brand + ", Taste: " + taste + ", Quality: " + quality + ") - $" + price;
    }
    
    private String toProperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    
    private double generateRandomPrice() {
        return 5.0 + new Random().nextDouble() * 20.0;
    }
}