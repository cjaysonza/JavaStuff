public class Painkillers extends PrescriptionDrug {
    private String painReliefType;

    public String getPainReliefType() {
        return painReliefType;
    }

    public void setPainReliefType(String painReliefType) {
        this.painReliefType = painReliefType;
    }

    public Painkillers(String product_name, String manufacturer, String activeIngredient, int dosageInMg, String painReliefType) {
        super(product_name, manufacturer, activeIngredient, dosageInMg);
        this.painReliefType = painReliefType;
    }

    public Painkillers() {
        super();
    }

    @Override
    public String introduction() {
       return
       "Name: " + getProduct_name() +  "\n" + 
       "Manufacturer: " + getManufacturer() +  "\n" + 
       "Active Ingredient: " + getActiveIngredient() +  "\n" + 
       "Dosage in MG: " + getDosageInMg() +  "\n" + 
       "Pain Relief Type: " + getPainReliefType();
    }



}
