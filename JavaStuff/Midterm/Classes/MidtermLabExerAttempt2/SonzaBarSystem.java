/* 
 * 
 * BIG NOTE: This was made in VSCode
 * If there are problems with compiling the program in Apache Neatbeans, please copy-paste code in a new project 
 * -CJ Sonza
 * :)
 * 
*/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SonzaBarSystem {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // INITIAL START OF THE PROGRAM
        FileWriter outFileWriter = new FileWriter("Data.txt");

        boolean inputDrinks = true;
        String drinksData = "", drinkSelect = "";
        String receipt = "No.   Drink Name\n";
        int drinkNo = 1;
        String selectHeader = String.format("%-5s\t$%-7s\t%-16s\n", "No.", "Price", "Drink Name");

        Drink newDrink;

        while(inputDrinks){
            String makeDrinkOfType = Displays.typeOfDrink();
                switch (makeDrinkOfType.toLowerCase()) {
                    case "drink" :
                        newDrink = Displays.createDrink();
                        JOptionPane.showMessageDialog(null, newDrink.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkSelect += String.format("%-7d\t$%-7.2f\t%-7s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkNo++;
                    break;  
                    case "beer" :
                        newDrink = Displays.createBeer();
                        JOptionPane.showMessageDialog(null, newDrink.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkSelect += String.format("%-7d\t$%-7.2f\t%-7s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkNo++;
                    break;
                    case "wine" :
                        newDrink = Displays.createWine();
                        JOptionPane.showMessageDialog(null, newDrink.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkSelect += String.format("%-7d\t$%-7.2f\t%-7s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkNo++;
                    break;
                    case "juice" :
                        newDrink = Displays.createJuice();
                        JOptionPane.showMessageDialog(null, newDrink.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkSelect += String.format("%-7d\t$%-7.2f\t%-7s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkNo++;
                    break;
                    case "exit" :
                        inputDrinks = false;
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Drink type input");
                    break;
            }
        }
        outFileWriter.write(drinksData);
        outFileWriter.close();

        // MENU CONTROL FOR THE PURCHASING
        boolean running = true;
        double subtotal = 0.0d;

        while (running) {
            int userInput;
            boolean validInput = false;
            
            while (!validInput) {
                userInput = Integer.parseInt(JOptionPane.showInputDialog("[MUST BE INT INPUT]\n[0] Complete Purchase\n\n" + selectHeader + drinkSelect));
                if (userInput == 0) {
                    running = false;
                    break;
                }
                
                Scanner drinks = new Scanner(new FileReader("Data.txt")); // Reopen file scanner for each loop
                while (drinks.hasNext()) {
                    int drinkId = drinks.nextInt();
                    double drinkPrice = drinks.nextDouble();
                    String drinkName = drinks.next();

                    if (drinkId == userInput) {
                        int boughtAmount = Integer.parseInt(JOptionPane.showInputDialog("How many?"));
                        JOptionPane.showMessageDialog(null, drinkName + " Has been Added to Bill");
                        subtotal += (drinkPrice * boughtAmount);
                        receipt += String.format("%dx    %s\n", boughtAmount, drinkName);
                        validInput = true;
                        break;
                    }
                }
                drinks.close();
                
                if (!validInput) {
                    JOptionPane.showMessageDialog(null, "Input Invalid. Please enter a valid option.");
                }
            }
        }


        // SHOW RECIEPT
        double taxedAmmount = subtotal * .14;
        double totalFinal = subtotal + taxedAmmount;
        receipt += String.format (
            "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=\n" +
            "Subtotal: $%.2f\n" +
            "Tax: $%.2f\n" +
            "Total: $%.2f\n",
            subtotal, taxedAmmount, totalFinal
        );

        JOptionPane.showMessageDialog(null, receipt);
        FileWriter saveReceipt = new FileWriter("Receipt.txt");
        saveReceipt.write(receipt);
        saveReceipt.close();

    }    



    // This is to properCase any words needed.
    private String toProperCase(String input) {
        return Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
    }
}
