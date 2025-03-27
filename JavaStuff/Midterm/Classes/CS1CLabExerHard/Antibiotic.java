public class Antibiotic extends PrescriptionDrug{
    private String antibioticType;
    private int durationInDays;

    public String getAntibioticType() {
        return antibioticType;
    }

    public void setAntibioticType(String antibioticType) {
        this.antibioticType = antibioticType;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    
    public Antibiotic(String product_name, String manufacturer, String activeIngredient, int dosageInMg, String antibioticType, int durationInDays) {
        super(product_name, manufacturer, activeIngredient, dosageInMg);
        this.antibioticType = antibioticType;
        this.durationInDays = durationInDays;
    }

    public Antibiotic() {
        super();
    }

    @Override
    public String introduction() {
        return        
        "Name: " + getProduct_name() +  "\n" + 
        "Manufacturer: " + getManufacturer() +  "\n" + 
        "Active Ingredient: " + getActiveIngredient() +  "\n" + 
        "Dosage in MG: " + getDosageInMg() +  "\n" + 
        "Antibiotic Type: " + getAntibioticType() +  "\n" + 
        "Intake Duration (Days): " + getDurationInDays();
    }

    
}
