public class Animal extends Pet {

    // Just the name
    public Animal(String name){
        this.name = name;
    }

    // Name and Owner
    public Animal(String name, boolean hasOwner) {
        this.name = name;
        this.hasOwner = hasOwner;
    }

    // Name, Owner, Life Expectancy
    public Animal(String name, boolean hasOwner, int lifeExpectancy) {
        this.name = name;
        this.hasOwner = hasOwner;
        this.lifeExpectancy = lifeExpectancy;
    }

    public Animal(String name, boolean hasOwner, int lifeExpectancy, String species) {
        super(species);
        this.name = name;
        this.hasOwner = hasOwner;
        this.lifeExpectancy = lifeExpectancy;
    }

    public Animal(String name, boolean hasOwner, int lifeExpectancy, String species, String kingdom) {
        super(species, kingdom);
        this.name = name;
        this.hasOwner = hasOwner;
        this.lifeExpectancy = lifeExpectancy;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isHasOwner() {
        return hasOwner;
    }
    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }
    public int getLifeExpectancy() {
        return lifeExpectancy;
    }
    public void setLifeExpectancy(int lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    private String name;
    private boolean hasOwner;
    private int lifeExpectancy;

}
