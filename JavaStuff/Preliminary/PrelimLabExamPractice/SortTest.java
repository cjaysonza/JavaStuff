import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SortTest {
    public static void main(String[] args) throws IOException {
        Scanner inFile = new Scanner(new File("input.txt"));
        FileWriter outFile = new FileWriter("output.txt");
        String evenWords = "", oddWords = "";
        int loopCount = 0;
        while (inFile.hasNext()) {
            String word = inFile.next();
            String temp = "";
            if (word.length() % 2 == 0) {
                for (int i = 0; i < evenWords.length(); i++) {
                    if (i == 0 || evenWords.charAt(i - 1) == ' ') {
                        int j = i;
                        while (j < evenWords.length() && evenWords.charAt(j) != ' ') j++;
                        String existingWord = evenWords.substring(i, j);
                        if (word.length() >= existingWord.length()) {
                            temp += word + " ";
                            word = "";
                        }
                        temp += existingWord + " ";
                        i = j;
                    }
                }
                if (!word.equals("")) temp += word + " ";
                evenWords = temp;
            } else {
                for (int i = 0; i < oddWords.length(); i++) {
                    if (i == 0 || oddWords.charAt(i - 1) == ' ') {
                        int j = i;
                        while (j < oddWords.length() && oddWords.charAt(j) != ' ') j++;
                        String existingWord = oddWords.substring(i, j);
                        if (word.length() >= existingWord.length()) {
                            temp += word + " ";
                            word = "";
                        }
                        temp += existingWord + " ";
                        i = j;
                    }
                }
                if (!word.equals("")) temp += word + " ";
                oddWords = temp;
            }
            loopCount++;
            if (loopCount > 100) break;
        }
        inFile.close();
        outFile.write(String.format("Group 1: %s%nGroup 2: %s", evenWords, oddWords));
        outFile.close();
    }
}



// public class Main {
//     public static void main(String[] args) throws FileNotFoundException {
//     }
// }
