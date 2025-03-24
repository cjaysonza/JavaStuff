public class Juice extends Drink {
    boolean hasPulp;
    String flavor;
 
    public boolean isHasPulp() {
       return this.hasPulp;
    }
 
    public void setHasPulp(boolean var1) {
       this.hasPulp = var1;
    }
 
    public String getFlavor() {
       return this.flavor;
    }
 
    public void setFlavor(String var1) {
       this.flavor = var1;
    }
 
    public Juice(String var1, double var2, boolean var4, boolean var5, String var6) {
       super(var1, var2, var4);
       this.hasPulp = var5;
       this.flavor = this.toTitleCase(var6);
    }

    @Override
    public String introduction() {
       return "Juice: " + this.name + " with " + this.flavor + " flavor, " + (this.hasPulp ? "contains pulp." : "no pulp.");
    }
 }
 