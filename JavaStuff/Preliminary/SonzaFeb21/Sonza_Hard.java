import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Sonza_Hard {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Scanner inFile1 = new Scanner(new FileReader("input.txt"));
        FileWriter outFile1 = new FileWriter("input.txt", true);
        String  bufInputs = "", g1 = "Group 1: ", g2 = "Group 2: "; 
        int nameCount = 0;
        boolean inputRun = true;

        while(inputRun) {
            String userInputCaps = "", userInput = JOptionPane.showInputDialog("Enter a name");
            if (userInput.equalsIgnoreCase("exit")){
                inputRun = false;
            }
            else {
            outFile1.append(userInputCaps = userInput.substring(0,1).toUpperCase().concat(userInput.substring(1)).replace(" ","-") + "\n");
            }
        } 
        outFile1.close();

        // Reorder names and put them in a massive string
        Scanner scanBuf2 = new Scanner(new FileReader("input.txt"));
        while(scanBuf2.hasNext()) {
            bufInputs += scanBuf2.next() + " ";
            nameCount++;
        }
        scanBuf2.close();

        for (int i = 0; i < nameCount; i++) {
            // Sorting via bubbles
            Scanner scanBuf = new Scanner(bufInputs);
            String prevString = scanBuf.next(), buf2 = "", currentString = "";
                while (scanBuf.hasNext()) {
                    currentString = scanBuf.next();
                    if (prevString.compareTo(currentString) < 0) {
                        String temp = currentString;
                        currentString = prevString;
                        prevString = temp;
                    } else {}
                        buf2 += prevString + " ";
                        prevString = currentString; 
                }
                    buf2 += prevString + " ";
                    bufInputs = buf2;
                    scanBuf.close();
                } 

            Scanner scrArrange = new Scanner(bufInputs);
            while (scrArrange.hasNext()) {
                String name = scrArrange.next();
                if (name.toUpperCase().startsWith("A") || name.toUpperCase().startsWith("B") || 
                    name.toUpperCase().startsWith("C") || name.toUpperCase().startsWith("D") || 
                    name.toUpperCase().startsWith("E") || name.toUpperCase().startsWith("F") || 
                    name.toUpperCase().startsWith("G") || name.toUpperCase().startsWith("H") || 
                    name.toUpperCase().startsWith("I") || name.toUpperCase().startsWith("J") || 
                    name.toUpperCase().startsWith("K") || name.toUpperCase().startsWith("L")){
                    
                    g1 += name + " ";
                }
                else {
                    g2 += name + " ";
                }
            }
            scrArrange.close();
            JOptionPane.showMessageDialog(null, String.format("%s%n%s", g1, g2));
    }
}