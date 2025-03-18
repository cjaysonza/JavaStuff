

public class Vehicle {
    private String dateManufacture;
    private double miles_driven;
    private String placeManufacture;

    //STATIC STUFF
    static int vehicleNo = 0;
    
    public Vehicle() {
        // This is usually empty, but then there is static stuff
        vehicleNo++;
    }

    public Vehicle(String dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public Vehicle(String dateManufacture, double miles_driven) {
        this.dateManufacture = dateManufacture;
        this.miles_driven = miles_driven;
    }

    public Vehicle(String dateManufacture, double miles_driven, String placeManufacture) {
        this.dateManufacture = dateManufacture;
        this.miles_driven = miles_driven;
        this.placeManufacture = placeManufacture;
    }
    
    public String getDateManufacture() {
        return dateManufacture;
    }
    public void setDateManufacture(String dateManufacture) {
        this.dateManufacture = dateManufacture;
    }
    public double getMiles_driven() {
        return miles_driven;
    }
    public void setMiles_driven(double miles_driven) {
        this.miles_driven = miles_driven;
    }
    public String getPlaceManufacture() {
        return placeManufacture;
    }
    public void setPlaceManufacture(String placeManufacture) {
        this.placeManufacture = placeManufacture;
    }

    // Override for Printing the raw class
    @Override
    public String toString(){
        return "A Vehicle! Manufactured in: " + getPlaceManufacture();
    }
}
