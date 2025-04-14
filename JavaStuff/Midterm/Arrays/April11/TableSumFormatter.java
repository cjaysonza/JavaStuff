import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TableSumFormatter {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter("output.txt");

        while (input.hasNextInt()) {
            int size = input.nextInt();
            int[][] table = new int[size][size];

            // Read square table
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    table[i][j] = input.nextInt();
                }
            }

            // Write dashed separator
            writer.write(dashLine(size) + "\n");

            // Write each row with row sum
            for (int i = 0; i < size; i++) {
                writer.write("|");
                for (int j = 0; j < size; j++) {
                    writer.write(" " + String.format("%02d", table[i][j]) + " |");
                }
                writer.write(" " + String.format("%03d", rowSum(table, i)) + "\n");
                if (i != (size-1)) {
                    writer.write(dashLine(size) + "\n");
                } else {
                    writer.write(longLine(size) + "\n");
                }
            }

            // No extra line before column sums
            for (int j = 0; j < size; j++) {
                writer.write(" " + String.format("%03d", columnSum(table, j)));
            }
            writer.write(" | " + String.format("%03d", diagonalSum(table)) + "\n\n");
        }

        writer.close();
        input.close();
    }

    public static String dashLine(int size) {
        String line = "";
        for (int i = 0; i < size; i++) {
            line += "-----";
        }
        line += "------";
        return line;
    }

    //TBA
    public static String longLine(int size) {
        String line = "";
        for (int i = 0; i < size; i++) {
            line += " ___ ";
        }
        line += " ___ ";
        return line;
    }

    public static int rowSum(int[][] table, int row) {
        int sum = 0;
        for (int i = 0; i < table[row].length; i++) {
            sum += table[row][i];
        }
        return sum;
    }

    public static int columnSum(int[][] table, int col) {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            sum += table[i][col];
        }
        return sum;
    }

    public static int diagonalSum(int[][] table) {
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            sum += table[i][i];
        }
        return sum;
    }
}
