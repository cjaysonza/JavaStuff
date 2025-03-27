// package Tribemen1B;

public abstract class Tribemen{
    private String name;
    private String tribe;
    static int tribeNo = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public Tribemen(){
        tribeNo++;
    }

    public Tribemen(String name, String tribe) {
        this.name = name;
        this.tribe = tribe;
    }

    public abstract String introduction(); 
}