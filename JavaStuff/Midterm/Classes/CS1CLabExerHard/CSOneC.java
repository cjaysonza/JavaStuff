
import javax.swing.JOptionPane;

public class CSOneC {
    public static void main(String[] args) {
        boolean programrun = true;
        int noOfDrugsMade = 0;

        while (programrun) {
            String drugtype = Displays.typeOfDrug(noOfDrugsMade);
            boolean madeDrug = false;
            drugtype = drugtype.toLowerCase();
            switch(drugtype){
                case "otc":
                    OTCMedicine otcmed = Displays.createOTC();
                    JOptionPane.showMessageDialog(null, otcmed.introduction());
                    madeDrug = true;
                break;

                case "supplement":
                    Supplement supp = Displays.createSupplement();
                    JOptionPane.showMessageDialog(null, supp.introduction());
                    madeDrug = true;
                break;

                case "prescription":
                    madeDrug = PrescriptionType();
                break;
              
                case "exit":
                    programrun = false;
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input Type");
                break;
            }
            if (madeDrug == true) noOfDrugsMade++;            
        }
    }


    public static boolean PrescriptionType(){
        String menu = "1 Just Prescription\n2 Antibiotic\n3 Painkillers\n[Just the Number]";  
        String input = JOptionPane.showInputDialog(menu);
        switch (input.charAt(0)) {
            case '1':
                PrescriptionDrug prescript = Displays.createPrescriptionDrug();
                JOptionPane.showMessageDialog(null, prescript.introduction());
                return true;
                // break;

            case '2':
                Antibiotic antibiotic = Displays.createAntibiotic();
                JOptionPane.showInputDialog(null, antibiotic.introduction());
                return true;
                // break;

            case '3':
                Painkillers painkillers = Displays.createPainkillers();
                JOptionPane.showMessageDialog(null, painkillers.introduction());
                return true;
                // break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Prescription Type");
            }
            return false;
    }

}