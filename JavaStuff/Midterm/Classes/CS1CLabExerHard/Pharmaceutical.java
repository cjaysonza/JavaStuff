// This is the mother class

public abstract class Pharmaceutical {
    private String product_name;
    private String manufacturer;
    static int PharmaNo = 0;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Pharmaceutical(String product_name, String manufacturer) {
        this.product_name = product_name;
        this.manufacturer = manufacturer;
    }

    public Pharmaceutical(){
        PharmaNo++;
    }

    public abstract String introduction();
}
