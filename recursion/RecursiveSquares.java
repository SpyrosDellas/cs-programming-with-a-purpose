/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     05/03/2020
 *
 * RecursiveSquares.java takes a non-negative integer command-line argument n
 * and plots a recursive square pattern of order n.
 *
 * The largest square is centered on the canvas and has side length 0.5. The
 * side length of each square is one-half that of the next largest square.
 *
 **************************************************************************** */

public class RecursiveSquares {

    public static void drawSquare(double x, double y, double length) {
        /* Draws a square centered on (x, y) of the given side length with a
        light gray background and a black border
        */
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2);
    }

    public static void draw(int n, double x, double y, double length) {
        /* Draws a recursive square pattern of order n, centered on (x, y)
        of the given side length.
        */

        // Base case of the recursion
        if (n == 0) return;

        // Recursive case
        double halfLength = length / 2;
        // Draw the top 2 squares of order n-1
        draw(n - 1, x - halfLength, y + halfLength, halfLength);
        draw(n - 1, x + halfLength, y + halfLength, halfLength);
        // Draw the center square of order n
        drawSquare(x, y, length);
        // Draw the bottom 2 squares of order n-1
        draw(n - 1, x - halfLength, y - halfLength, halfLength);
        draw(n - 1, x + halfLength, y - halfLength, halfLength);
    }

    public static void main(String[] args) {
        /* Takes an integer command-line argument n and draws a recursivesquare
        pattern of order n, centered on (0.5, 0.5) with side length 0.5.
         */
        int n = Integer.parseInt(args[0]);
        draw(n, 0.5, 0.5, 0.5);
    }

}
