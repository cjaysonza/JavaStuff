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


        while(inputDrinks){
            String makeDrinkOfType = Displays.typeOfDrink();
                switch (makeDrinkOfType.toLowerCase()) {
                    case "drink" :
                        Drink newDrink;
                        newDrink = Displays.createDrink();
                        JOptionPane.showMessageDialog(null, newDrink.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkSelect += String.format("%d $%.2f %s\n", drinkNo, newDrink.price, newDrink.name);
                        drinkNo++;
                    break;
                    case "beer" :
                        Beer newBeer;
                        newBeer = Displays.createBeer();
                        JOptionPane.showMessageDialog(null, newBeer.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newBeer.price, newBeer.name);
                        drinkSelect += String.format("%d $%.2f %s\n", drinkNo, newBeer.price, newBeer.name);
                        drinkNo++;
                    break;
                    case "wine" :
                        Wine newWine;
                        newWine = Displays.createWine();
                        JOptionPane.showMessageDialog(null, newWine.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newWine.price, newWine.name);
                        drinkSelect += String.format("%d $%.2f %s\n", drinkNo, newWine.price, newWine.name);
                        drinkNo++;
                    break;
                    case "juice" :
                        Juice newJuice;
                        newJuice = Displays.createJuice();
                        JOptionPane.showMessageDialog(null, newJuice.introduction());
                        drinksData += String.format("%d %.2f %s\n", drinkNo, newJuice.price, newJuice.name);
                        drinkSelect += String.format("%d $%.2f %s\n", drinkNo, newJuice.price, newJuice.name);
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
                userInput = Integer.parseInt(JOptionPane.showInputDialog("[MUST BE INT INPUT]\n[0] Complete Purchase\n" + drinkSelect));
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
