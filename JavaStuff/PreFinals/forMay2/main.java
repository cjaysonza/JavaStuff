import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new FileReader("square (2).txt"));
        
        int size = scanner.nextInt();
        int[][] grid = new int[size][size];
        
        // Read grid from file
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();

        // Write to output file
        FileWriter writer = new FileWriter("output.txt");
                
        writer.append("Initial Grid: \n");
        writer.append(formatGrid(grid));

        // Perform and write 2 iterations
        for (int iter = 1; iter <= 2; iter++) {
            spreadMinValues(grid);
            writer.append("\nAfter Iteration " + iter + ": \n");
            writer.append(formatGrid(grid));
        }
        
        writer.close();
    }

    private static String formatGrid(int[][] grid) {
        String string = "";
        int size = grid.length;
        String horizontalLine = "-".repeat(size*5+1) + "\n";
        
        for (int[] row : grid) {
            string += horizontalLine + "|";
            
            for (int num : row) {
                string += String.format(" %02d |", num);
            }
            
            string += "\n";
        }
        
        string += horizontalLine;
        
        return string;
    }
    
    private static void spreadMinValues(int[][] grid) {
        List<int[]> minCells = new ArrayList<>();
        
        int size = grid.length;
        int min = 100;
        
        // Find minimum value and positions
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] < min) {
                    min = grid[i][j];
                    minCells.clear();
                }
                if (grid[i][j] == min) {
                    minCells.add(new int[]{i, j});
                }
            }
        }

        // Mark cells to update
        boolean[][] toUpdate = new boolean[size][size];
        
        for (int[] cell : minCells) {
            int i = cell[0], j = cell[1];
            if (i > 0) toUpdate[i-1][j] = true;
            if (i < size-1) toUpdate[i+1][j] = true;
            if (j > 0) toUpdate[i][j-1] = true;
            if (j < size-1) toUpdate[i][j+1] = true;
        }

        // Apply updates
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (toUpdate[i][j]) {
                    grid[i][j] = min;
                }
            }
        }
    }
}