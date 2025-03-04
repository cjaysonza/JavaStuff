
import java.util.Scanner;
import javax.swing.*;

public class SonzaMarch4 {
    /// To Specifications ni Sir Gudo
    // public static int longest(String str1, String str2, String str3) {
    //     int maxLength = str1.length();

    //     if (str2.length() > maxLength) {
    //         maxLength = str2.length();
    //     }
    //     if (str3.length() > maxLength) {
    //         maxLength = str3.length();
    //     }
    //     return maxLength;
    // }

    // public static String getFarthestAlphabetically(String str1, String str2, String str3) {
    //     // Compare strings using compareTo (lexicographic order)
    //     String farthest = str1;

    //     if (str2.compareTo(farthest) > 0) {
    //         farthest = str2;
    //     }
    //     if (str3.compareTo(farthest) > 0) {
    //         farthest = str3;
    //     }
    //     return farthest;
    // }

    /// For Future-Proof programs
    public static String Longest(String compiledStrings) {
        String buffer = "";
        Scanner inputScanner = new Scanner(compiledStrings);
        while (inputScanner.hasNext()) {
            String nextName = inputScanner.next();
            int curNameEnd = -1;
            while (true) { 
                int curNameStart = curNameEnd + 1;
                curNameEnd = buffer.indexOf(" ", curNameStart);
                if (
                        curNameEnd == -1
                        || nextName.length() > buffer.substring(curNameStart, curNameEnd).length()
                ) {
                    buffer = buffer.substring(0, curNameStart)
                    + nextName
                    + " "
                    + (curNameEnd == -1 ? "" : buffer.substring(curNameStart));
                    break;
                }
            }
        }
        inputScanner.close();
        // int space = buffer.lastIndexOf(" ");
        String longestString = "(" +
        (buffer.substring(0, buffer.indexOf(" ")).length()) +
        ") " +
        buffer.substring(0, buffer.indexOf(" "));
        return longestString;
    }

    public static String FarthestAlphabetically(String compiledStrings) {
        String buffer = "";
        Scanner inputScanner = new Scanner(compiledStrings);
        while (inputScanner.hasNext()) {
            String nextName = inputScanner.next();
            int curNameEnd = -1;
            while (true) { 
                int curNameStart = curNameEnd + 1;
                curNameEnd = buffer.indexOf(" ", curNameStart);
                if (
                        curNameEnd == -1
                        || nextName.compareTo(buffer.substring(curNameStart, curNameEnd)) < 0
                ) {
                    buffer = buffer.substring(0, curNameStart)
                    + nextName
                    + " "
                    + (curNameEnd == -1 ? "" : buffer.substring(curNameStart));
                    break;
                }
            }
        }
        return buffer.substring(0, buffer.indexOf(" "));
    }    
    
    public static void menu(String compiledStrings) {
        Scanner input = new Scanner(System.in);
        // int longestName = 0;
        // String farthestName = "";
        boolean running = true;

        while (running) {
            String userInput = JOptionPane.showInputDialog(
                "What would you like to do\n" +
                "A. Longest word (int)\n" +
                "B. Farthest Alphabetically\n" +
                "E. Exit Program").toUpperCase();
            // userInput.toUpperCase().charAt(0);
        
            switch (userInput.charAt(0)) {
                case 'A':
                    JOptionPane.showMessageDialog(null, Longest(compiledStrings));
                    break;

                case 'B':
                    JOptionPane.showMessageDialog(null, FarthestAlphabetically(compiledStrings));
                    break;

                case 'E':
                    JOptionPane.showMessageDialog(null, "Exiting Program");
                    running = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid user Input");
                    break;
            }
        }
        input.close();
    }

    public static void main(String[] args) {
        int n = 1;
        String compiledStrings = "";

        // String word1 = JOptionPane.showInputDialog("Enter name" + n + ":");
        // String word2 = JOptionPane.showInputDialog("Enter name" + n + ":");
        // String word3 = JOptionPane.showInputDialog("Enter name" + n + ":");
        // menu(word1, word2, word3);

        while (true) { 
            String word = JOptionPane.showInputDialog("Enter name " + n + ":");
            if (word.equalsIgnoreCase("exit")) {
                break;
            } else {
                compiledStrings += word + " ";
                n++;
            }
        }
        menu(compiledStrings);

    }
}