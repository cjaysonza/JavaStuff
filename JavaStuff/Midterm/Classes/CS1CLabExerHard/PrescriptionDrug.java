public class PrescriptionDrug extends Pharmaceutical {
    
    private String activeIngredient;
    private int dosageInMg;
    
    public String getActiveIngredient() {
        return activeIngredient;
    }
    
    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }
    
    public int getDosageInMg() {
        return dosageInMg;
    }
    
    public void setDosageInMg(int dosageInMg) {
        this.dosageInMg = dosageInMg;
    }
        
    public PrescriptionDrug(String product_name, String manufacturer, String activeIngredient, int dosageInMg) {
        super(product_name, manufacturer);
        this.activeIngredient = activeIngredient;
        this.dosageInMg = dosageInMg;
    }
    
    public PrescriptionDrug() {
        super();
    }

    @Override
    public String introduction() {
        return        
        "Name: " + getProduct_name() +  "\n" + 
        "Manufacturer: " + getManufacturer() +  "\n" + 
        "Active Ingredient: " + getActiveIngredient() +  "\n" + 
        "Dosage in MG: " + getDosageInMg();
    }

}
