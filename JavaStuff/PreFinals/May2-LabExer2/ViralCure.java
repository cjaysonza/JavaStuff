import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ViralCure {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grid size (n): ");
        int size = scanner.nextInt();
        int[][] grid = new int[size][size];
        Random random = new Random();

        // Fill grid with values 2-8
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = random.nextInt(7) + 2;
            }
        }

        // Place virus (1)
        int virusRow = random.nextInt(size);
        int virusCol = random.nextInt(size);
        grid[virusRow][virusCol] = 1;

        // Place cure (9) in a different cell
        int cureRow, cureCol;
        do {
            cureRow = random.nextInt(size);
            cureCol = random.nextInt(size);
        } while (cureRow == virusRow && cureCol == virusCol);
        grid[cureRow][cureCol] = 9;

        FileWriter writer = new FileWriter("output.txt");
        writer.append("Initial Grid:\n");
        writer.append(formatGrid(grid));

        int spreadCount = 0;
        boolean virusSpreading = true;

        // Virus spreading boolean table
        boolean[][] virusGrid = new boolean[size][size];

        while (virusSpreading) {
            ArrayList<int[]> ones = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (grid[i][j] == 1) {
                        if ((i > 0 && grid[i - 1][j] == 9) ||
                            (i < size - 1 && grid[i + 1][j] == 9) ||
                            (j > 0 && grid[i][j - 1] == 9) ||
                            (j < size - 1 && grid[i][j + 1] == 9)) {
                            writer.append("\nSpread no. " + (++spreadCount) + ":\n");
                            writer.append(formatGrid(grid));
                            writer.append("1 has been adjacent to 9, virus spreading has stopped and curing will begin.\n");
                            virusSpreading = false;
                            break;
                        }
                        ones.add(new int[]{i, j});
                    }
                }
            }

            if (!virusSpreading || ones.isEmpty()) {
                break;
            }

            virusGrid = new boolean[size][size];
            for (int[] cell : ones) {
                int i = cell[0], j = cell[1];
                if (i > 0) virusGrid[i - 1][j] = true;
                if (i < size - 1) virusGrid[i + 1][j] = true;
                if (j > 0) virusGrid[i][j - 1] = true;
                if (j < size - 1) virusGrid[i][j + 1] = true;
            }

            // Turn original 1s to 0s
            for (int[] cell : ones) {
                grid[cell[0]][cell[1]] = 0;
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (virusGrid[i][j]) {
                        if (grid[i][j] != 0 && grid[i][j] != 9) {
                            grid[i][j] = 1;
                        }
                    }
                }
            }

            writer.append("\nSpread no. " + (++spreadCount) + ":\n");
            writer.append(formatGrid(grid));
        }

        // Cure spreading begins
        int cureCount = 0;
        boolean cureSpreading = true;
        boolean[][] cureGrid = new boolean[size][size];
        cureGrid[cureRow][cureCol] = true;

        while (cureSpreading) {
            boolean[][] newCureGrid = new boolean[size][size];
            boolean anySpread = false;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (cureGrid[i][j]) {
                        for (int dx = -1; dx <= 1; dx++) {
                            for (int dy = -1; dy <= 1; dy++) {
                                int ni = i + dx;
                                int nj = j + dy;
                                if (ni >= 0 && ni < size && nj >= 0 && nj < size && !(dx == 0 && dy == 0)) {
                                    if (grid[ni][nj] != 9 && grid[ni][nj] != 0) {
                                        grid[ni][nj] = random.nextInt(7) + 2;
                                        newCureGrid[ni][nj] = true;
                                        anySpread = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (!anySpread) {
                writer.append("\nVirus has been cured.\n");
                break;
            }

            cureGrid = newCureGrid;
            writer.append("\nCure no. " + (++cureCount) + ":\n");
            writer.append(formatGrid(grid));
        }

        writer.close();
        scanner.close();
    }

    private static String formatGrid(int[][] grid) {
        String result = "";
        int size = grid.length;
        String horizontalLine = "-".repeat(size * 5 + 1) + "\n";

        for (int[] row : grid) {
            result += horizontalLine + "|";
            for (int num : row) {
                result += String.format(" %02d |", num);
            }
            result += "\n";
        }
        result += horizontalLine;
        return result;
    }
}
