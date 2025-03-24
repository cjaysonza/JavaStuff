public class Wine extends Drink {
    int alcoholPercent;
    String brand;

    public int getAlcoholPercent() {
        return alcoholPercent;
    }

    public void setAlcoholPercent(int alcoholPercent) {
        this.alcoholPercent = alcoholPercent;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Wine(String name, double liters, boolean bottled, int alcoholPercent, String brand) {
        super(name, liters, bottled);
        this.alcoholPercent = alcoholPercent;
        this.brand = toTitleCase(brand);
    }

    @Override
    public String introduction() {
        return "Wine: " + name + " (" + brand + ") with " + alcoholPercent + "% alcohol.";
    }
}
