import java.io.*;
import javax.swing.JOptionPane;

public class SonzaLabActFeb14 {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        FileWriter outFile = new FileWriter("output.txt");
        String change = "change";
        String quote = "quote";
        String g1 = "Group 1: ";
        String g2 = "Group 2: ";
        String g3 = "Group 3: ";
        boolean programRun = true;

        while (programRun != false) {
            String userInput = "";
            boolean hasChange = false;
            boolean hasQuote = false;
            userInput = JOptionPane.showInputDialog("Enter a Name");

            if (userInput.equalsIgnoreCase("exit")) {
                programRun = false;
            } 
            else if (userInput.length() < 4) {
                JOptionPane.showMessageDialog(null, "Input was less than 4 characters");
            }
            else {
                // For change
                for (int j = 0; j < userInput.length()-1; j++) {
                    char userInputTemp = userInput.toLowerCase().charAt(j);

                    for (int i = 0; i < change.length(); i++) {
                        hasChange = userInputTemp == change.charAt(i);
                        if (hasChange) break;
                    }
                    if (hasChange) break;
                }
                // has quote
                for (int k = 0; k < userInput.length()-1; k++) {
                    char userInputTemp = userInput.toLowerCase().charAt(k);

                    for (int l = 0; l < quote.length(); l++) {
                        hasQuote = userInputTemp == quote.charAt(l);
                        if (hasQuote) break;
                    }
                    if (hasQuote) break;
                }
                if (hasChange) {
                    g1 += userInput + " ";
                }
                else if (hasQuote) {
                    g2 += userInput + " ";
                }
                else {
                    g3 += userInput + " ";
                }
            }
        }
        String finalText = String.format("%s\n%s\n%s\n", g1, g2, g3);
        outFile.write(finalText);
        outFile.close();
    }
}