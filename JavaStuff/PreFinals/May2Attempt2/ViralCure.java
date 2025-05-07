/**
 *
 * @author csonza
 */
import java.io.*;
import java.util.*;

public class ViralCure {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size n of the n x n grid: ");
        int n = scanner.nextInt();
        if (n < 2) {
            System.out.println("Grid size must be at least 2x2.");
            return;
        }
        scanner.close();

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = Utils.random(2, 8);
            }
        }

        int[] pos1 = getRandomPosition(n);
        int[] pos9;
        do {
            pos9 = getRandomPosition(n);
        } while (Arrays.equals(pos1, pos9));
        grid[pos1[0]][pos1[1]] = 1;
        grid[pos9[0]][pos9[1]] = 9;

        FileWriter writer = new FileWriter("output.txt");
        writer.write("Initial table:\n");
        printGrid(grid, writer);
        
        boolean spreadHalted = spreadVirus(grid, n, writer);
        if (spreadHalted) {
            spreadCure(pos9, grid, n, writer);
        }
        
        writer.close();
    }

    public static boolean spreadVirus(int[][] grid, int n, FileWriter writer) throws IOException {
        int spreadCount = 0;
        boolean spreadHalted = false;
    
        while (true) {
            int minVal = findMin(grid);  // Find the minimum value (likely '01')
            if (minVal == -1) break;
    
            spreadCount++;
            List<int[]> originalCells = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == minVal) originalCells.add(new int[]{i, j});  // Collect the cells with the minimum value (virus cells)
                }
            }
    
            List<int[]> newCells = new ArrayList<>();
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] cell : originalCells) {
                int r = cell[0], c = cell[1];
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] != 9) {
                        // If the neighboring cell is not an anti-virus cell (9), mark it for spreading
                        newCells.add(new int[]{nr, nc});
                    }
                }
            }
    
            boolean hitAnti = false;
            for (int[] cell : newCells) {
                if (isAdjacentTo9(cell[0], cell[1], grid)) {
                    hitAnti = true;
                    break;
                }
            }
    
            // Spread virus to new cells
            for (int[] cell : newCells) {
                grid[cell[0]][cell[1]] = minVal;
            }
    
            // Set the original cells (virus cells) to 00 (i.e., 0) after spreading
            for (int[] cell : originalCells) {
                grid[cell[0]][cell[1]] = 0;
            }
    
            writer.write("\nSpread no. " + spreadCount + ":\n");
            printGrid(grid, writer);
            writer.flush();
    
            if (hitAnti) {
                writer.write("\nSpread process halted due to hitting the anti-digit 9.\n");
                spreadHalted = true;
                break;
            }
        }
    
        return spreadHalted;
    }
    
    
    public static void spreadCure(int[] pos9, int[][] grid, int n, FileWriter writer) throws IOException {
        int cureCount = 0;
        List<int[]> currentCells = new ArrayList<>();
        currentCells.add(pos9);

        while (hasVirusCells(grid)) {
            cureCount++;
            List<int[]> nextCells = new ArrayList<>();
            boolean updated = false;

            for (int[] cell : currentCells) {
                int r = cell[0], c = cell[1];
                int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] != 9) {
                        grid[nr][nc] = Utils.random(2, 8);
                        nextCells.add(new int[]{nr, nc});
                        updated = true;
                    }
                }
            }

            if (updated) {
                writer.write("\nCure no. " + cureCount + ":\n");
                printGrid(grid, writer);
                writer.flush();
            }
            currentCells = nextCells;
        }
    }

    // Helper methods
    private static int[] getRandomPosition(int n) {
        return new int[]{Utils.random(0, n-1), Utils.random(0, n-1)};
    }

    private static int findMin(int[][] grid) {
        int min = Integer.MAX_VALUE;
        for (int[] row : grid) {
            for (int val : row) {
                if (val != 0 && val != 9 && val < min) min = val;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static boolean isAdjacentTo9(int r, int c, int[][] grid) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 9) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasVirusCells(int[][] grid) {
        for (int[] row : grid) {
            for (int val : row) {
                if (val == 1) return true;
            }
        }
        return false;
    }

    private static void printGrid(int[][] grid, FileWriter writer) throws IOException {
        int n = grid.length;
        String horizontalLine = new String(new char[5*n + 1]).replace('\0', '-');
        for (int[] row : grid) {
            writer.write("|");
            for (int val : row) {
                writer.write(String.format(" %02d |", val));
            }
            writer.write("\n" + horizontalLine + "\n");
        }
    }
}
