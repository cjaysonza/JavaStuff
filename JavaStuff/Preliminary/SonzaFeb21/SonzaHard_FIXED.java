import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class SonzaHard_FIXED {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Scanner inFile1 = new Scanner(new FileReader("input.txt"));
        FileWriter outFile1 = new FileWriter("input.txt", true);
        String bufInputs = "", g1 = "Group 1: ", g2 = "Group 2: ";

        while (true) {
            String userInput = JOptionPane.showInputDialog("Enter a name");
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            } else {
                outFile1.append(userInput.substring(0, 1).toUpperCase().concat(userInput.substring(1)) + "\n");
            }
        }
        outFile1.close();

        Scanner scanBuf = new Scanner(new FileReader("input.txt"));
        while (scanBuf.hasNext()) {
            String insert = scanBuf.next(), newBuf = "";
            Scanner scanBuf2 = new Scanner(bufInputs);
            while (scanBuf2.hasNext()) {
                String existing = scanBuf2.next();
                if (insert != null && existing.compareTo(insert) < 0) {
                    newBuf += insert + " ";
                    insert = null;
                }
                newBuf += existing + " ";
            }
            if (insert != null) {
                newBuf += insert + " ";
            }
            scanBuf2.close();
            bufInputs = newBuf;
        }
        scanBuf.close();

        Scanner scrArrange = new Scanner(bufInputs);
        while (scrArrange.hasNext()) {
            String name = scrArrange.next();
            if (name.charAt(0) <= 'L') {
                g1 += name + " ";
            } else {
                g2 += name + " ";
            }
        }
        scrArrange.close();
        JOptionPane.showMessageDialog(null, String.format("%s%n%s", g1, g2));
    }
}
