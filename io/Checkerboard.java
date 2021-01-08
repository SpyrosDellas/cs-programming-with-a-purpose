/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     20/02/2020
 *
 * Checkerboard
 * Takes a command-line integer n and plots an n-by-n checkerboard pattern to
 * standard drawing.
 * Colors the squares blue and light gray, with the bottom-left square blue.
 *
 **************************************************************************** */

public class Checkerboard {

    public static void main(String[] args) {

        // Grid size
        int n = Integer.parseInt(args[0]);

        StdDraw.setScale(0, n);

        double halfLength = 0.5;

        // Initialise coordinates
        double x = -halfLength;
        double y = -halfLength;

        // Enable double buffering
        StdDraw.enableDoubleBuffering();

        // Draw the board
        for (int i = 1; i <= n; i++) {
            x += 2 * halfLength;
            y = -halfLength;  // reset the y-coordinate
            for (int j = 1; j <= n; j++) {
                y += 2 * halfLength;
                if ((i % 2 != 0 && j % 2 != 0) || (i % 2 == 0 && j % 2 == 0)) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledSquare(x, y, halfLength);
            }
        }
        // Plot the board
        StdDraw.show();
    }
}
