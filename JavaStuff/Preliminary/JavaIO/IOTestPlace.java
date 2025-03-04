import java.io.*;
import java.util.Scanner;

public class IOTestPlace {
    public static void main (String args[]) throws FileNotFoundException, IOException {
        Scanner finput = new Scanner (new FileReader("input.txt"));
        FileWriter output = new FileWriter("output.txt");

        int age = finput.nextInt();
        String name1 = finput.next();
        String name2 = finput.next();

        // String grade = finput.next();

        // int AGE = 0;
        // double GRADE = 0.0d;

        // if (age > 50) {
        //     output.write("The number is big");
        // } else {
        //     output.write("The number is lower");
        // }

        // output.write(((age > 50) ? "The number is big" : age > 25 ? "The number is adequate" : "The number is lower") + "\n");

        // if (name1.compareTo(name2) > 0)
        //     output.write(name1);
        // else if (name1.compareTo(name2) < 0)
        //     output.write(name2);
        // else 
        //     output.write("The same");

        String formattedText = String.format("The bigger name is %s, and the value %d is %s", 
        name1.compareTo(name2) > 0 ? name1 : name2, 
        age, age > 50 ? "big" : age > 25 ? "adequate" : "small");
        
        output.write(formattedText);

        output.close();
        finput.close();
    }
}
