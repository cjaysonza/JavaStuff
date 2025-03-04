import java.io.*;
import java.util.Scanner;

public class ControlStructTwo {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        Scanner inFile = new Scanner(new FileReader("ConStrucInputTwo.txt"));
        FileWriter outFile = new FileWriter("ConStrucOutputTwo.txt");
        
        String group1 = "Group 1: ";
        String group2 = "Group 2: ";
        String group3 = "Group 3: ";
        String group4 = "Group 4: ";
        String group5 = "Group 5: ";
        String finalText = "";
        
        while (inFile.hasNext()) { 
            String name = inFile.next();
            
            if (name.length() % 2 == 0 && name.length() % 3 == 0) {
                group1 += name + " ";
            }
            
            if (name.length() > 7) {
                group2 += name + " ";
            }
            else if (name.length() % 5 == 0) {
                group3 += name + " ";
            }
            else if (name.length() % 2 == 0) {
                group4 += name + " ";
            }
            else if (name.length() % 2 == 1) {
                group5 += name + " ";
            }
        }
        
        finalText = String.format("%s\n%s\n%s\n%s\n%s\n", group1, group2, group3, group4, group5);

        outFile.write(finalText);
        inFile.close();
        outFile.close();
    }
}
