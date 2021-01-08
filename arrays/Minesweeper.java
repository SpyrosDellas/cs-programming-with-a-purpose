/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     19/02/2020
 *
 * Minesweeper.
 * Minesweeper is a 1960s era video game played on an m-by-n grid of cells.
 * The goal is to deduce which cells contain hidden mines using clues about
 * the number of mines in neighboring cells.
 *
 * Minesweeper.java takes three integer command-line arguments m, n, and k and
 * prints an m-by-n grid of cells with k mines, using asterisks for mines and
 * integers for the neighboring mine counts (with two space characters
 * between each cell).
 *
 * To do so, we generate an m-by-n grid of cells, with exactly k of the mn cells
 * containing mines, uniformly at random.
 *
 * For each cell not containing a mine, we count the number of neighboring
 * mines (above, below, left, right, or diagonal).
 *
 *  */

public class Minesweeper {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);  // Number of rows
        int n = Integer.parseInt(args[1]);  // Number of columns
        int k = Integer.parseInt(args[2]);  // Number of mines

        // Create and intialize the minesweeper m-by-n grid
        int[][] grid = new int[m][n];

        // Populate the grid with k mines
        int minesCounter = 0;
        while (minesCounter < k) {
            int minePosition = (int) (Math.random() * m * n);
            int x = minePosition / n;
            int y = minePosition % n;
            if (grid[x][y] >= 0) {
                grid[x][y] = -1;    // -1 represents a mine
                minesCounter += 1;
                if (minesCounter == m * n) break;  // Grid full of mines!
            }
        }

        // Solve the grid
        int xStart, xEnd, yStart, yEnd;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == -1) continue;  // Cell is a mine, continue with next cell

                // Find the neibourhood limits
                if (i - 1 >= 0) yStart = i - 1;
                else yStart = i;
                if (i + 1 < m) yEnd = i + 1;
                else yEnd = i;

                if (j - 1 >= 0) xStart = j - 1;
                else xStart = j;
                if (j + 1 < n) xEnd = j + 1;
                else xEnd = j;

                // Scan the neibourhood for mines, including the cell itself
                // to simplify the scan code
                for (int a = yStart; a <= yEnd; a++) {
                    for (int b = xStart; b <= xEnd; b++) {
                        if (grid[a][b] == -1) {
                            grid[i][j] += 1;    // Mine found in the neibourhood
                        }
                    }
                }
            }
        }

        // Print the solved grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    System.out.print("*  ");
                }
                else {
                    System.out.print(grid[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
