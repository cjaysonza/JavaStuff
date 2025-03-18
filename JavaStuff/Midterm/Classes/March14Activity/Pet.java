public class Pet {
    String species;
    String kingdom;
    
    public Pet() {
    }

    public Pet(String species) {
        this.species = species;
    }
    public Pet(String species, String kingdom) {
        this.species = species;
        this.kingdom = kingdom;
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
}
