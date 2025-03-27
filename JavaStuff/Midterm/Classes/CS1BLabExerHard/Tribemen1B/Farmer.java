public class Farmer extends Tribemen {
    private double fieldSize;
    private String crop;
    static int farmerNo = 1;


    public double getFieldSize() {
        return fieldSize;
    }
    public void setFieldSize(double fieldSize) {
        this.fieldSize = fieldSize;
    }
    public String getCrop() {
        return crop;
    }
    public void setCrop(String crop) {
        this.crop = crop;
    }

    
    public Farmer(String name, String tribe, double fieldSize, String crop) {
        super(name, tribe);
        this.fieldSize = fieldSize;
        this.crop = crop;
    }

    public Farmer() {
        super();
        farmerNo++;

    }
    
    @Override
    public String introduction() {
        return "Farmer Name: " + getName() + 
        "\nField Size Owned (^2): " + getFieldSize() + 
        "\nCrop Farmed: " + getCrop();
    }

}
