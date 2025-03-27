public class OTCMedicine extends Pharmaceutical {
    
    private boolean requiresID;
    private String usageInstructions;

    public boolean isRequiresID() {
        return requiresID;
    }

    public void setRequiresID(boolean requiresID) {
        this.requiresID = requiresID;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public void setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
    }

    
    public OTCMedicine(String product_name, String manufacturer, boolean requiresID, String usageInstructions) {
        super(product_name, manufacturer);
        this.requiresID = requiresID;
        this.usageInstructions = usageInstructions;
    }
    
    public OTCMedicine() {
        super();
    }    

    @Override
    public String introduction() {
        return 
        "Name: " + getProduct_name() + "\n" + 
        "Manufacturer: " + getManufacturer() + "\n" + 
        "Requires ID: " + isRequiresID() + "\n" + 
        "Usage Instructions: " + getUsageInstructions();
    }
}
