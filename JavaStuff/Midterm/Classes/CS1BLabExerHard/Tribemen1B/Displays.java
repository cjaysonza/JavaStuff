import javax.swing.JOptionPane;

public class Displays {
    public static String typeOfRole(){
        return JOptionPane.showInputDialog("Enter" + Tribemen.tribeNo + "Unit Class\n" +
        "(Hunter)\n" +
        "(Farmer)\n" +
        "(Gatherer)\n" +
        "(Exit)\n" +
        "[STRING INPUT]"
        );
    }

    public static Hunter createHunter(){
        String name = JOptionPane.showInputDialog("Enter Hunter Name:");
        String tribe = JOptionPane.showInputDialog("Enter Tribe Name:");
        String weapon = JOptionPane.showInputDialog("Enter Weapon Name:");
        int skillLvl = Integer.parseInt(JOptionPane.showInputDialog("Enter Skill level [INT]:"));
        return new Hunter(name, tribe, weapon, skillLvl);
    }

    public static Farmer createFarmer(){    
        String name = JOptionPane.showInputDialog("Enter Farmer Name:");
        String tribe = JOptionPane.showInputDialog("Enter Tribe Name:");
        double farmland = Double.parseDouble(JOptionPane.showInputDialog("Enter Field Size Owned [DOUBLE]:"));
        String crop = JOptionPane.showInputDialog("What Crop does it Farm?:");
        return new Farmer(name, tribe, farmland, crop);
    }

    public static Gatherer createGatherer(){    
        String name = JOptionPane.showInputDialog("Enter Farmer Name:");
        String tribe = JOptionPane.showInputDialog("Enter Tribe Name:");
        boolean collectsMedPlant = JOptionPane.showConfirmDialog(null, "Does it collect Medicinal Plants?: ", "Med. Plants", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        String crop = JOptionPane.showInputDialog("What Crop does it Farm?:");
        return new Gatherer(name, tribe, collectsMedPlant, crop);
    }
}
// COPY THIS THING FOR BOOLEANS
// boolean bottled = JOptionPane.showConfirmDialog(null, "Is it Bottled?", "Bottled Status", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
