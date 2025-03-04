
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// package PrelimLabExamPractice;

public class PrelimLabExamPrac {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader("input.txt"));
        FileWriter outFile = new FileWriter("output.txt");

        String buffer = "", g1 = "Group 1: ", g2 = "Group 2: ", g3 = "Group 3: ", g4 = "Group 4: ", g5 = "Group 5: ";
        String word1 = "drifte";
        String word2 = "olgan";
        int userCount = 0;
        while (inFile.hasNext()) {
            buffer+= inFile.next() + " ";
            userCount++;
        }
        inFile.close();
        // Manual Bubble Sort
        for (int i = 0; i < userCount; i++) {
            Scanner bufScanner = new Scanner(buffer);
            String prevString = bufScanner.next(), buf2 = "", currentString = "";

            while (bufScanner.hasNext()) {
                currentString = bufScanner.next();
                if (prevString.length() < currentString.length()) {
                    String temp = currentString;
                    currentString = prevString;
                    prevString = temp;
                } else {}
                buf2 += prevString + " ";
                prevString = currentString; 
            }
            buf2 += prevString + " ";
            buffer = buf2;
            bufScanner.close();
        }
        
        // Arranging them in groups
        Scanner scrArrange = new Scanner(buffer);

        while (scrArrange.hasNext()) {
            String nextInput = scrArrange.next();
            boolean hasWord1 = false;
            boolean hasWord2 = false;

            // If their name starts with letter from the First Word 
            for (int j = 0; j < nextInput.length()-1; j++) {
                char nextChar = nextInput.toLowerCase().charAt(j);

                for (int k = 0; k < word1.length(); k++) {
                    hasWord1 = nextChar == word1.charAt(k);
                    if (hasWord1) break;
                }
                if (hasWord1) break;
            }
            // If their name starts with letter from the Second Word 
            for (int l = 0; l < nextInput.length()-1; l++) {
                char nextChar = nextInput.toLowerCase().charAt(l);

                for (int m = 0; m < word2.length(); m++) {
                    hasWord2 = nextChar == word2.charAt(m);
                    if (hasWord2) break;
                }
                if (hasWord2) break;
            }
            
            // Even and has letters from the word "drifte"
            if (nextInput.length() % 2 == 0 && hasWord1) {
                g1 += nextInput + " ";
            } 
            // Even but has letters from the word "olgan"
            else if (nextInput.length() % 2 == 0 && hasWord2) {
                g2 += nextInput + " ";
            }
            // Odd but has letters from the word "drifte"
            else if (nextInput.length() % 2 != 0 && hasWord1) {
                g3 += nextInput + " ";
            }
            // Odd but has letters from the word "olgan"
            else if (nextInput.length() % 2 != 0 && hasWord2) {
                g4 += nextInput + " ";
            }
            // Everything else
            else {
                g5 += nextInput + " ";
            }
        }
        scrArrange.close();
        outFile.write(String.format("%s%n%s%n%s%n%s%n%s%n", g1, g2, g3, g4, g5));
        outFile.close();
    }
}
