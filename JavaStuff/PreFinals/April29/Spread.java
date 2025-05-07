import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Spread {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Square.txt"));
        FileWriter writer = new FileWriter("output.txt");

        while (input.hasNextInt()) {
            int size = input.nextInt();
            int[][] table = new int[size][size];

            // Read the integer table
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    table[i][j] = input.nextInt();
                }
            }

            writer.write("Original Table:\n");
            writeTable(writer, table);

            int smallest = findSmallest(table);
            int turns = 2; // hardcoded number of spreading turns

            int[][] spreadTable = table;
            // Spread the infection for each turn
            for (int t = 1; t <= turns; t++) {
                writer.write("\nTable after spread " + t + ":\n");
                spreadTable = spreadInfection(spreadTable, smallest);
                writeTable(writer, spreadTable);
            }
        }

        writer.close();
        input.close();
    }

    // Find the smallest number
    public static int findSmallest(int[][] table) {
        int min = Integer.MAX_VALUE;
        for (int[] row : table) {
            for (int val : row) {
                if (val < min) {
                    min = val;
                }
            }
        }
        return min;
    }

    // Spread the smallest number over turns
    public static int[][] spreadInfection(int[][] original, int smallest) {
        int size = original.length;
        int[][] table = new int[size][size];

        // Copy original table
        for (int i = 0; i < size; i++) {
            System.arraycopy(original[i], 0, table[i], 0, size);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == smallest) {
                    // Spread to neighbors
                    if (i > 0) table[i - 1][j] = smallest;
                    if (i < size - 1) table[i + 1][j] = smallest;
                    if (j > 0) table[i][j - 1] = smallest;
                    if (j < size - 1) table[i][j + 1] = smallest;

                    // After spreading, original cell becomes "uninfected"
                    table[i][j] = 99; // Mark spreaded cells as "99" (different number so it doesn't spread again)
                }
            }
        }

        // Now, replace all "99" back to smallest
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == 99) {
                    table[i][j] = smallest;
                }
            }
        }

        return table;
    }

    // Write the table with formatted style
    public static void writeTable(FileWriter writer, int[][] table) throws IOException {
        int size = table.length;
        writer.write(dashLine(size) + "\n");
        for (int i = 0; i < size; i++) {
            writer.write("|");
            for (int j = 0; j < size; j++) {
                writer.write(" " + String.format("%02d", table[i][j]) + " |");
            }
            writer.write("\n");
            writer.write(dashLine(size) + "\n");
        }
    }

    // Generate a dashed line
    public static String dashLine(int size) {
        String line = "";
        for (int i = 0; i < size; i++) {
            line += "-----";
        }
        return line;
    }
}
