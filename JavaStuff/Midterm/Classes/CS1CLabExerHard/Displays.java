import javax.swing.JOptionPane;

public class Displays {
    public static String typeOfDrug(int noOfDrugsMade){
        return JOptionPane.showInputDialog("Enter [" + noOfDrugsMade + "] Drug Type\n" +
        "(OTC)\n" +
        "(Supplement)\n" +
        "(Prescription)\n" +
        "(Exit)\n" +
        "[STRING INPUT]"
        );
    }

    public static OTCMedicine createOTC(){
        String prodName = JOptionPane.showInputDialog("Enter Medicine Name: ");
        String manufacturer = JOptionPane.showInputDialog("Manufacturer Name: ");
        boolean requiresID = JOptionPane.showConfirmDialog(null, "Does this require ID?", "ID Req", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        String usageIns = JOptionPane.showInputDialog("Usage Instructions: ");
        return new OTCMedicine(prodName, manufacturer, requiresID, usageIns);
    }

    public static Supplement createSupplement(){
        String prodName = JOptionPane.showInputDialog("Enter Medicine Name: ");
        String manufacturer = JOptionPane.showInputDialog("Manufacturer Name: ");
        double servSize = Double.parseDouble(JOptionPane.showInputDialog("Serving Size [Double]"));
        String vitaminType = JOptionPane.showInputDialog("Vitamin Type: ");
        return new Supplement(prodName, manufacturer, servSize, vitaminType);
    }


    public static PrescriptionDrug createPrescriptionDrug(){
        String prodName = JOptionPane.showInputDialog("Enter Medicine Name: ");
        String manufacturer = JOptionPane.showInputDialog("Manufacturer Name: ");
        String activeIngred = JOptionPane.showInputDialog("Active Ingredient");
        int dosageMG = Integer.parseInt(JOptionPane.showInputDialog("Dosage in MG [Int]"));
        return new PrescriptionDrug(prodName, manufacturer, activeIngred, dosageMG);
    }

    public static Antibiotic createAntibiotic(){
        String prodName = JOptionPane.showInputDialog("Enter Medicine Name: ");
        String manufacturer = JOptionPane.showInputDialog("Manufacturer Name: ");
        String activeIngred = JOptionPane.showInputDialog("Active Ingredient");
        int dosageMG = Integer.parseInt(JOptionPane.showInputDialog("Dosage in MG [Int]"));
        String antiBioType = JOptionPane.showInputDialog("Antibiotic Type: ");
        int durationInDays = Integer.parseInt(JOptionPane.showInputDialog("Duration in Days [Int]"));
        return new Antibiotic(prodName, manufacturer, activeIngred, dosageMG, antiBioType, durationInDays);
    }

    public static Painkillers createPainkillers(){
        String prodName = JOptionPane.showInputDialog("Enter Medicine Name: ");
        String manufacturer = JOptionPane.showInputDialog("Manufacturer Name: ");
        String activeIngred = JOptionPane.showInputDialog("Active Ingredient");
        int dosageMG = Integer.parseInt(JOptionPane.showInputDialog("Dosage in MG [Int]"));
        String painRel = JOptionPane.showInputDialog("Pain Relief Method: ");
        return new Painkillers(prodName, manufacturer, activeIngred, dosageMG, painRel);
    }



}
