import java.io.*;
import java.util.Scanner;

public class ControlStruct {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner input = new Scanner(System.in);
        Scanner inFile = new Scanner(new FileReader("ConStrucInput.txt"));
        FileWriter outFile = new FileWriter("ConStrucOutput.txt");
        
        String group1 = "Group 1: ";
        String group2 = "Group 2: ";
        String group3 = "Group 3: ";
        String group4 = "Group 4: ";
        String finalText = "";
        while (inFile.hasNext()) { 
            String name = inFile.next();
            if ((name.startsWith("A") || name.startsWith("E") || name.startsWith("I") || name.startsWith("O") || name.startsWith("U"))
            && (name.endsWith("a") || name.endsWith("e") || name.endsWith("i") || name.endsWith("o") || name.endsWith("u"))) {
                group1 += name + " ";
            }
            else if (name.startsWith("A") || name.startsWith("E") || name.startsWith("I") || name.startsWith("O") || name.startsWith("U")) {
                group2 += name + " ";
            }
            else if (name.endsWith("a") || name.endsWith("e") || name.endsWith("i") || name.endsWith("o") || name.endsWith("u")) {
                group3 += name + " ";
            }
            else {
                group4 += name + " ";
            } 
        }
        

        finalText = String.format("%s\n%s\n%s\n%s\n", group1, group2, group3, group4);

        outFile.write(finalText);
        inFile.close();
        outFile.close();
        // int i = 0;
        // String star = "x ";

        // while (i <= 5) {
        //     System.out.println(star);
        //     star += "x ";
        //     i++;
        // }
            
        // Sentinel Controlled WHILE-LOOP
        // boolean found = false;

        // while (!found) {

        // }

        // int counter = 0;
        // while (counter < 5) {
        //     outFile.write("A ");
        //     counter++;
        // }

        // String value = JOptionPane.showInputDialog("1. Menu\n2. Options\n3. Exit Program");
        // String value = "";
        // while (!value.equals("3")) {
        //     value = JOptionPane.showInputDialog("1. Menu\n2. Options\n3. Exit Program");
        // }
        
        // do {
        //     value = JOptionPane.showInputDialog("1. Menu\n2. Options\n3. Exit Program");
        // } while (!value.equals("3"));

        // inFile.close();
        // outFile.close();
        // input.close();

        // Flag Control While Loops
        // boolean state = false;
        // while (!state) {
        //     String name = JOptionPane.showInputDialog("Enter your Name");
        //     if (name.equalsIgnoreCase("Mark")) {
        //         state = true;
        //     }
        // }   

        // File Input While Loop
        
        // String text = "";
        // while (inFile.hasNext()) {
        //     text += inFile.next() + " ";
        // }
         
        // Practice break and Continue
        // String text = "";
        // while (inFile.hasNext()) {
        //     String name = inFile.next();
        //     if (name.equalsIgnoreCase("Alberto")) {
        //         continue;
        //     }
        //     text += name + " ";
        // }
    }    
}
