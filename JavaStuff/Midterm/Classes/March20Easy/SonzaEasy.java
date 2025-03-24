// import java.io.*;
// import javax.swing.*;

// public class SonzaEasy {
//     private static final String FILE_NAME = "bar.txt";
    
//     public static void main(String[] args) {
//         while (true) {
//             String choice = JOptionPane.showInputDialog("Enter drink type (Wine, Juice, Beer) or 'exit' to quit:");
//             if (choice == null || choice.equalsIgnoreCase("exit")) {
//                 break;
//             }
            
//             switch (choice.toLowerCase()) {
//                 case "wine":
//                     createWine();
//                     break;
//                 case "juice":
//                     createJuice();
//                     break;
//                 case "beer":
//                     createBeer();
//                     break;
//                 default:
//                     JOptionPane.showMessageDialog(null, "Invalid choice. Try again.");
//             }
//         }
//         displayMenu();
//     }
    
//     private static void createWine() {
//         String name = JOptionPane.showInputDialog("Enter wine name:");
//         String brand = JOptionPane.showInputDialog("Enter wine brand:");
//         String taste = JOptionPane.showInputDialog("Enter wine taste:");
//         int quality = Integer.parseInt(JOptionPane.showInputDialog("Enter wine quality (1-10):"));
        
//         Wine wine = new Wine(name, brand, taste, quality);
//         saveToFile(wine.introduce());
//         JOptionPane.showMessageDialog(null, wine.introduce());
//     }
    
//     private static void createJuice() {
//         String name = JOptionPane.showInputDialog("Enter juice name:");
//         String brand = JOptionPane.showInputDialog("Enter juice brand:");
//         String flavor = JOptionPane.showInputDialog("Enter juice flavor:");
//         boolean hasPulp = JOptionPane.showInputDialog("Does it have pulp? (yes/no)").equalsIgnoreCase("yes");
        
//         Juice juice = new Juice(name, brand, flavor, hasPulp);
//         saveToFile(juice.introduce());
//         JOptionPane.showMessageDialog(null, juice.introduce());
//     }
    
//     private static void createBeer() {
//         String name = JOptionPane.showInputDialog("Enter beer name:");
//         String brand = JOptionPane.showInputDialog("Enter beer brand:");
//         double alcoholContent = Double.parseDouble(JOptionPane.showInputDialog("Enter alcohol content (%):"));
        
//         Beer beer = new Beer(name, brand, alcoholContent);
//         saveToFile(beer.introduce());
//         JOptionPane.showMessageDialog(null, beer.introduce());
//     }
    
//     private static void saveToFile(String text) {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
//             writer.write(text);
//             writer.newLine();
//         } catch (IOException e) {
//             JOptionPane.showMessageDialog(null, "Error saving to file.");
//         }
//     }
    
//     private static void displayMenu() {
//         StringBuilder menu = new StringBuilder("Current Menu:\n");
//         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 menu.append(line).append("\n");
//             }
//         } catch (IOException e) {
//             menu.append("No drinks recorded yet.");
//         }
//         JOptionPane.showMessageDialog(null, menu.toString());
//     }
// }
