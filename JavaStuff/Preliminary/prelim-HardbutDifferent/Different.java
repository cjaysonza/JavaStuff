
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Different {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileWriter outFile1 = new FileWriter("input.txt", true);

        while (true) {
            String userInput = JOptionPane.showInputDialog("Enter a name");
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            } else {
                outFile1.append(
                    userInput.substring(0, 1).toUpperCase()
                    + userInput.substring(1)
                    + "\n"
                );
            }
        }
        outFile1.close();



        String buffer = "", g1 = "Group 1: ", g2 = "Group 2: ";
        Scanner inputScanner = new Scanner(new FileReader("input.txt"));
        while (inputScanner.hasNext()) {
            String nextName = inputScanner.next();
            int curNameEnd = -1;
            while (true) { 
                int curNameStart = curNameEnd + 1;
                curNameEnd = buffer.indexOf(" ", curNameStart);
                if (
                        curNameEnd == -1
                        || nextName.compareTo(buffer.substring(curNameStart, curNameEnd)) > 0
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

        Scanner scrArrange = new Scanner(buffer);
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
