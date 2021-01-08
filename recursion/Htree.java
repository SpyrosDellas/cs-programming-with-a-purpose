/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     24/02/2020
 *
 *
 * Plots an order n H-tree.
 *
 * An H-tree is a simple example of a fractal: a geometric shape that can be
 * divided into parts, each of which is (approximately) a reduced size copy
 * of the original.
 *
 * An H-tree of order n is defined as follows:
 * - The base case is null for n = 0.
 * - The reduction step is to draw, within the unit square three lines in the
 * shape of the letter H and four H-trees of order n − 1, one connected to
 * each tip of the H with the additional provisos that the H-trees of
 * order n − 1 are centered in the four quadrants of the square, halved in size.
 *
 ******************************************************************************/

public class Htree {

    // plot an H, centered on (x, y) of the given side length
    public static void drawH(double x, double y, double size) {

        // compute the coordinates of the 4 tips of the H
        double x0 = x - size / 2;
        double x1 = x + size / 2;
        double y0 = y - size / 2;
        double y1 = y + size / 2;

        // draw the 3 line segments of the H
        StdDraw.line(x0, y0, x0, y1);    // left  vertical segment of the H
        StdDraw.line(x1, y0, x1, y1);    // right vertical segment of the H
        StdDraw.line(x0, y, x1, y);    // connect the two vertical segments of the H
    }

    // plot an order n H-tree, centered on (x, y) of the given side length
    public static void draw(int n, double x, double y, double size) {

        // Base case of the recursion
        if (n == 0) return;

        // Recursive case

        drawH(x, y, size);

        // compute x- and y-coordinates of the 4 half-size H-trees
        double x0 = x - size / 2;
        double x1 = x + size / 2;
        double y0 = y - size / 2;
        double y1 = y + size / 2;

        // recursively draw 4 half-size H-trees of order n-1
        draw(n - 1, x0, y0, size / 2);    // lower left  H-tree
        draw(n - 1, x0, y1, size / 2);    // upper left  H-tree
        draw(n - 1, x1, y0, size / 2);    // lower right H-tree
        draw(n - 1, x1, y1, size / 2);    // upper right H-tree
    }


    public static void main(String[] args) {

        // Order of the H-tree
        int n = Integer.parseInt(args[0]);

        double x = 0.5, y = 0.5;   // center of H-tree
        double size = 0.5;         // side length of H-tree

        draw(n, x, y, size);
    }

}
