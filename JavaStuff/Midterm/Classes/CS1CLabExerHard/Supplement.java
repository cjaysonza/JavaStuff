public class Supplement extends Pharmaceutical{
    private double servingSize;
    private String vitaminType;
    
    public double getServingSize() {
        return servingSize;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }
    
    
    public String getVitaminType() {
        return vitaminType;
    }
    
    
    public void setVitaminType(String vitaminType) {
        this.vitaminType = vitaminType;
    }
        
    
    public Supplement(String product_name, String manufacturer, double servingSize, String vitaminType) {
        super(product_name, manufacturer);
        this.servingSize = servingSize;
        this.vitaminType = vitaminType;
    }

    public Supplement() {
        super();
    }

    @Override
    public String introduction() {
       return
        "Name: " + getProduct_name() +  "\n" + 
        "Manufacturer: " + getManufacturer() +  "\n" + 
        "Serving Size: " + getServingSize() +   "\n" + 
        "Vitamin Type: " + getVitaminType();
    }
}
