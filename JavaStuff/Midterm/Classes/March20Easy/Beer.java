import java.util.Random;

public class Beer {
    private String name, brand;
    private double alcoholContent, price;
    
    public Beer(String name, String brand, double alcoholContent) {
        this.name = toProperCase(name);
        this.brand = brand;
        this.alcoholContent = alcoholContent;
        this.price = generateRandomPrice();
    }
    
    public String introduce() {
        return "Beer: " + name + " (Brand: " + brand + ", Alcohol Content: " + alcoholContent + "%)- $" + price;
    }
    
    private String toProperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    
    private double generateRandomPrice() {
        return 3.0 + new Random().nextDouble() * 15.0;
    }
}
