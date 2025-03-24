class Juice extends Drink {
    private boolean hasPulp;
    private String flavor;

    public Juice(String name, double liters, boolean bottled, boolean hasPulp, String flavor) {
        super(name, liters, bottled);
        this.hasPulp = hasPulp;
        this.flavor = toTitleCase(flavor);
    }

    @Override
    public String introduction() {
        return "Juice: " + name + " with " + flavor + " flavor, " + (hasPulp ? "contains pulp." : "no pulp.");
    }
}
