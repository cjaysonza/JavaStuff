public class Beer extends Drink{
    String color;
    double alcoholContent;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(double alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

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
