/*
 * 
 *  MY ATTEMPT SA 1B shenanigans
 *  DO NOT STEAL CODE PLEASE :)
 *              -csonza, 1A
 * 
 */


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CSOneB {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileWriter outFileWriter = new FileWriter("allTribesmen.txt");

        boolean makeNewTribeman = true;
        //  String allTribesmen = "";
        String 
        hunterHeader = String.format("%-3s. %-10s\t\t%-16s\t%-16s\t%-16s\n", "No", "NAME", "TRIBE", "Weapon", "Skill level"),
        farmerHeader = String.format("%-3s. %-10s\t\t%-16s\t%-16s\t%-16s\n", "No", "NAME", "TRIBE", "Field Size", "Crop"),
        gatherHeader = String.format("%-3s. %-10s\t\t%-16s\t%-16s\t%-16s\n", "No", "NAME", "TRIBE", "Col. Med Plant?", "Pref. Season");

        String allHunters = "", allFarmers = "", allGatherers = "";

        while(makeNewTribeman){
            String makeTribesman = Displays.typeOfRole();
            switch(makeTribesman.toLowerCase()) {
                case "hunter":
                    Hunter hunter = Displays.createHunter();
                    JOptionPane.showMessageDialog(null, hunter.introduction());
                    allHunters += String.format("%-3d. %-10s\t\t%-16s\t%-16s\t%-16d\n", Hunter.hunterNo, hunter.getName(), hunter.getTribe(), hunter.getWeapon(), hunter.getSkillLvl());
                break;
                case "farmer":
                    Farmer farmer = Displays.createFarmer();
                    JOptionPane.showMessageDialog(null, farmer.introduction());
                    allFarmers += String.format("%-3d. %-10s\t\t%-16s\t%-16.2f\t%-16s\n", Farmer.farmerNo, farmer.getName(), farmer.getTribe(), farmer.getFieldSize(), farmer.getCrop());
                break;
                case "gatherer":
                    Gatherer gatherer = Displays.createGatherer();
                    JOptionPane.showMessageDialog(null, gatherer.introduction());
                    allGatherers += String.format("%-3d. %-10s\t\t%-16s\t%-16b\t%-16s\n", Gatherer.gathererNo, gatherer.getName(), gatherer.getTribe(), gatherer.isCollectsMedicinalPlants(), gatherer.getPrefferedSeason());
                break;
                case "exit" :
                    makeNewTribeman = false;
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input Type");
                break;
            }
        }
        int totalTribesmen = Tribemen.tribeNo;
        JOptionPane.showMessageDialog(null, compileAllClasses(hunterHeader, allHunters, farmerHeader, allFarmers, gatherHeader, allGatherers, totalTribesmen));
        outFileWriter.write(compileAllClasses(hunterHeader, allHunters, farmerHeader, allFarmers, gatherHeader, allGatherers, totalTribesmen));
        outFileWriter.close();
    }

    // Check for Totals if it has 
    public static String verifyContent(String x){
        if (x == null || x.equals("")) {
            return "NONE\n";
        }
        else {
            return x;
        }
    }

    // Random border shiz
    public static String border(){
        return "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
    }

    // Compiles everything
    public static String compileAllClasses(String hunterHeader, String allHunters, String farmerHeader, String allFarmers, String gatherHeader, String allGatherers, int totalTribesmen){
        String FinalOutput = String.format(
            "HUNTERS\n%s%s\n%s" +
            "\nFARMERS\n%s%s\n%s" +
            "\nGATHERERS\n%s%s\n%s" +
            "\n\nTotal No. of Tribesmen made: %d",
            hunterHeader,
            border(),
            verifyContent(allHunters),
            farmerHeader,
            border(),
            verifyContent(allFarmers),
            gatherHeader,
            border(),
            verifyContent(allGatherers),
            totalTribesmen
        );

        return FinalOutput;
    }

}
