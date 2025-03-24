import java.io.*;
import javax.swing.JOptionPane;

public class MidtermSonza {
     public static void main(String[] args) throws FileNotFoundException, IOException {
            String receipt = "";
            double subtotal = 0;
    
            while (true) {
                Drink drink = Displays.createDrink();
                if (drink == null) break;
                
                JOptionPane.showMessageDialog(null, drink.introduction());
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
                double cost = drink.price * quantity;
                subtotal += cost;
                receipt += drink.name + " x" + quantity + " - $" + String.format("%.2f", cost) + "\n";
            }
    
            double tax = subtotal * 0.14;
            double total = subtotal + tax;
            receipt += "\nSubtotal: $" + String.format("%.2f", subtotal) +
                       "\nTax (14%): $" + String.format("%.2f", tax) +
                       "\nTotal: $" + String.format("%.2f", total);
    
            JOptionPane.showMessageDialog(null, receipt);
            saveReceipt(receipt);
        }
    
        private static void saveReceipt(String content) throws IOException {
            try (FileWriter writer = new FileWriter("receipt.txt")) {
                writer.write(content);
            }
        }
}