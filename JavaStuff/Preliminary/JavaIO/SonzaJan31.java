import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class SonzaJan31 {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        /// Discussion Notes and Practice Activity
        Scanner inFile = new Scanner(new FileReader("input.txt"));
        FileWriter output = new FileWriter("output.txt");

        String fullName = inFile.nextLine();
        int age = inFile.nextInt();
        double weight = inFile.nextDouble();

        output.write("Hello, I am " + fullName + ". I am " + age + "-years old and my weight is " + weight + "kgs");
        
        output.close();
        inFile.close();

    }
}
