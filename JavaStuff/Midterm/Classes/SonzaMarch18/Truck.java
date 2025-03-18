public class Truck extends Vehicle{
    private double kgsLimit;
    private String color;

    public Truck(){}

    
    public Truck(String dateManufacture, double kgsLimit, String color) {
        super(dateManufacture);
        this.kgsLimit = kgsLimit;
        this.color = color;
    }

    public Truck(String dateManufacture, double miles_driven, double kgsLimit, String color) {
        super(dateManufacture, miles_driven);
        this.kgsLimit = kgsLimit;
        this.color = color;
    }

    public Truck(String dateManufacture, double miles_driven, String placeManufacture, double kgsLimit, String color) {
        super(dateManufacture, miles_driven, placeManufacture);
        this.kgsLimit = kgsLimit;
        this.color = color;
    }

    public double getKgsLimit() {
        return kgsLimit;
    }
    public void setKgsLimit(double kgsLimit) {
        this.kgsLimit = kgsLimit;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    
}
