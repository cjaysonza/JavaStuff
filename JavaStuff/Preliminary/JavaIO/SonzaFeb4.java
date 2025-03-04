import java.io.*;
import java.util.Scanner;


public class SonzaFeb4 {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        Scanner inFile = new Scanner(new FileReader("inputTest.txt"));
        FileWriter outFile = new FileWriter("outputTest.txt");

        String name1 = inFile.next();
        String name2 = inFile.next();
        int age = inFile.nextInt();
        double weight = inFile.nextDouble();
        String formattedString = "";

        // formattedString = String.format("Hello, I am %s and %s, %d-years old and weight %.2f", name1, name2, age, weight);

        outFile.write(String.format("Hello, I am %s and %s, %d-years old and weight %.2f", name1, name2, age, weight)); 

        inFile.close();
        outFile.close();

    }
}
