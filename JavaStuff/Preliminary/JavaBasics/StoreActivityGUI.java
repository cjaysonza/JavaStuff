import javax.swing.JOptionPane;

public class StoreActivityGUI {
    public static void main(String[] args) {
        String storeName;
        String item1 = "";
        String item2 = "";
        String price1 = "";
        String price2 = "";
        String tax = "";
        
        double PRICE1 = 0; 
        double PRICE2 = 0;
        double TAX = 0.0d;

        String outputMessage = "";

        int itemNumber = 1;

        storeName = JOptionPane.showInputDialog("Enter the Store Name: ");
        item1 = JOptionPane.showInputDialog("Enter Item #" + itemNumber + ":");
        price1 = JOptionPane.showInputDialog("Enter Item #" + itemNumber+ " Price:");
        PRICE1 = Double.parseDouble(price1);
        itemNumber++;

        item2 = JOptionPane.showInputDialog("Enter Item #" + itemNumber + ":");
        price2 = JOptionPane.showInputDialog("Enter Item #" + itemNumber+ " Price:");
        PRICE2 = Double.parseDouble(price2);
        
        tax = JOptionPane.showInputDialog("Enter Tax (0.0-1.0):");
        TAX = Double.parseDouble(tax);

        double total = (PRICE1 + PRICE2);
        double taxTotal = (total * TAX);
        double taxPercent = (TAX * 100.0);
        double finalTotal = (total + taxTotal);

        outputMessage = String.format(storeName + "\nItem 1:%s  Price:%.2f\nItem 2:%s  Price:%.2f\n\n" +
        "TOTAL: %.2f\nTAX: %.2f  (%.2f%%)\nFINAL TOTAL: %.2f", item1, PRICE1, item2, PRICE2, total, taxTotal, taxPercent, finalTotal);


        JOptionPane.showMessageDialog(null, outputMessage);
      
    }
 
}
