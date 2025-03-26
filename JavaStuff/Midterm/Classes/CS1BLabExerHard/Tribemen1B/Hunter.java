// package Tribemen1B;

public class Hunter extends Tribemen{
    private String weapon;
    private int skillLvl;
    static int hunterNo = 0;


    public String getWeapon() {
        return weapon;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
    public int getSkillLvl() {
        return skillLvl;
    }
    public void setSkillLvl(int skillLvl) {
        this.skillLvl = skillLvl;
    }
    
    public Hunter(String name, String tribe, String weapon, int skillLvl) {
        super(name, tribe);
        this.weapon = weapon;
        this.skillLvl = skillLvl;
    }

    public Hunter() {
        super();
        hunterNo++;
    }

    @Override
    public String introduction() {
        return "Hunter Name: " + getName() + 
        "\nWeapon: " + getWeapon() + 
        "\nSkill lvl: " + getSkillLvl();
    }


}
