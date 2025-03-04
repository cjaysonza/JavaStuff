import java.io.*;
import java.util.Scanner;

public class SonzaFeb4Activity {
    public static void main (String[] args) throws FileNotFoundException, IOException {
        Scanner inFile = new Scanner(new FileReader("inputTest.txt"));
        FileWriter outFile = new FileWriter("outputTest.txt");

        String border = "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
        String nameOfStore = inFile.next();
        String item1 = inFile.next();
        double price1 = inFile.nextDouble();
        String item2 = inFile.next();
        double price2 = inFile.nextDouble();
        String item3 = inFile.next();
        double price3 = inFile.nextDouble();
        String item4 = inFile.next();
        double price4 = inFile.nextDouble();
        double tax = inFile.nextDouble();

        double total = (price1 + price2 + price3 + price4);
        double taxTotal = total * tax;
        double taxPercentShow = tax * 100.0;
        double totalFinal = taxTotal + total;
        int taxPERCENT = (int)taxPercentShow;

        String taxFormatted = "Tax(" + taxPERCENT + "%)";

        outFile.write(String.format("Store Name: %s%n", nameOfStore));
        outFile.write("Sari-Sari Store\n" + border + "\nITEMS\t\tPRICES\n" + border + "\n");
        outFile.write(String.format("%-7s\t\t$%7.2f\n", item1, price1));
        outFile.write(String.format("%-7s\t\t$%7.2f\n", item2, price2));
        outFile.write(String.format("%-7s\t\t$%7.2f\n", item3, price3));
        outFile.write(String.format("%-7s\t\t$%7.2f\n", item4, price4));
        outFile.write(border + "\n");
        outFile.write(String.format("%-7s\t$%7.2f\n", "subtotal", total));
        outFile.write(String.format("%-7s\t$%7.2f\n", taxFormatted, taxTotal));
        outFile.write(String.format("%-7s\t\t$%7.2f\n", "Total", totalFinal));

        


        inFile.close();
        outFile.close();
    }
}
