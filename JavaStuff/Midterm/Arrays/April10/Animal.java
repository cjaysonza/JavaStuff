public class Animal {
    private String name;
    private String species;
    private String kingdom;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getKingdom() {
        return kingdom;
    }
    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }
    public Animal(String name, String species, String kingdom) {
        this.name = name;
        this.species = species;
        this.kingdom = kingdom;
    }

    public Animal(){

    }

    public String introduction(){
        return String.format("Name: %s\nSpecies: %s\nKingdom: %s\n", getName(), getSpecies(), getKingdom());
    }
}
