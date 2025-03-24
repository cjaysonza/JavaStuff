public class Beer extends Drink {
    private double alcoholContent;
    private String color;

    public Beer(String name, double liters, boolean bottled, double alcoholContent, String color) {
        super(name, liters, bottled);
        this.alcoholContent = alcoholContent;
        this.color = toTitleCase(color);
    }

    @Override
    public String introduction() {
        return "Beer: " + name + " (" + color + ") with " + alcoholContent + "% alcohol.";
    }
}
