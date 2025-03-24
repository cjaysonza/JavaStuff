public class Wine extends Drink{
    private int alcoholPercent;
    private String brand;

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
