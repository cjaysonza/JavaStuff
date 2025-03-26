public class Gatherer extends Tribemen{
    private boolean collectsMedicinalPlants;
    private String prefferedSeason;
    static int gathererNo = 0;

    public boolean isCollectsMedicinalPlants() {
        return collectsMedicinalPlants;
    }

    public void setCollectsMedicinalPlants(boolean collectsMedicinalPlants) {
        this.collectsMedicinalPlants = collectsMedicinalPlants;
    }

    public String getPrefferedSeason() {
        return prefferedSeason;
    }

    public void setPrefferedSeason(String prefferedSeason) {
        this.prefferedSeason = prefferedSeason;
    }

    public Gatherer(String name, String tribe, boolean collectsMedicinalPlants, String prefferedSeason) {
        super(name, tribe);
        this.collectsMedicinalPlants = collectsMedicinalPlants;
        this.prefferedSeason = prefferedSeason;
    }

    public Gatherer() {
        super();
        gathererNo++;
    }

    @Override
    public String introduction() {
        return "Gatherer Name: " + getName() + 
        "\nCollects Medicinal Plants: " + isCollectsMedicinalPlants() + 
        "\nPreffered Season: " + getPrefferedSeason();
    }


}
