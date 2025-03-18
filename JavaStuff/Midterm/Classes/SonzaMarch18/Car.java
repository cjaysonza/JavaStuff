public class Car extends Vehicle{
    private String brand;
    private String model;

    public Car(){
    }

    public Car(String brand) {
        this.brand = brand;
    }
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car(String dateManufacture, String brand, String model) {
        super(dateManufacture);
        this.brand = brand;
        this.model = model;
    }
    public Car(String dateManufacture, double miles_driven, String brand, String model) {
        super(dateManufacture, miles_driven);
        this.brand = brand;
        this.model = model;
    }
    public Car(String dateManufacture, double miles_driven, String placeManufacture, String brand, String model) {
        super(dateManufacture, miles_driven, placeManufacture);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }


}