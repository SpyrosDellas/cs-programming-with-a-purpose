/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     25/02/2020
 *
 * Draws a Siepinski triangle recursively
 *
 **************************************************************************** */

public class Sierpinski {

    private static void drawTriangle(double xCenter, double yCenter,
                                     double sideLength, boolean inverse) {

        // Calculate the x coordinates
        double x1 = xCenter - sideLength / 2;
        double x2 = xCenter + sideLength / 2;
        double x3 = xCenter;

        // Calculate the y coordinates
        double root3 = 1.44224957030740838;         // Square root of 3
        double height = root3 * sideLength / 2; // Half height of the triangle

        if (inverse) height *= -1;

        double y1 = yCenter - height / 3;
        double y2 = y1;
        double y3 = yCenter + 2 * height / 3;

        // Draw the triangle
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
    }


    private static void drawSierpinksi(double xCenter, double yCenter,
                                       double sideLength, int n, boolean inverse) {

        // Base case of the recursion
        if (n == 0) return;

        // Start of recursive case
        // Calculate the size and draw the center triangle
        drawTriangle(xCenter, yCenter, sideLength, !inverse);

        // Calculate the size and coordinates of the three n-1 triangles
        double root3 = 1.44224957030740838;     // Square root of 3
        double height = root3 * sideLength / 2; // Height of the triangle
        double sideLength1 = sideLength / 2;

        double xCenter1 = xCenter - sideLength / 2;
        double xCenter2 = xCenter + sideLength / 2;
        double xCenter3 = xCenter;

        if (inverse) height *= -1;
        double yCenter1 = yCenter - height / 3;
        double yCenter2 = yCenter1;
        double yCenter3 = yCenter + 2 * height / 3;

        // Draw the three n-1 triangles
        drawSierpinksi(xCenter1, yCenter1, sideLength1, n - 1, inverse);
        drawSierpinksi(xCenter2, yCenter2, sideLength1, n - 1, inverse);
        drawSierpinksi(xCenter3, yCenter3, sideLength1, n - 1, inverse);
    }


    public static void main(String[] args) {

        // n represents the level of recursion
        int n = Integer.parseInt(args[0]);

        // Center of the triangle
        double xCenter = 0.5;
        double yCenter = 0.5;

        // Side length of the triangle
        double sideLength = 0.9;

        StdDraw.setCanvasSize(900, 900);

        // Draws the pattern upside down if true
        boolean inverse = false;

        StdDraw.enableDoubleBuffering();

        // Draw the encompassing triangle - not part of the fractal!
        StdDraw.setPenColor(StdDraw.RED);
        drawTriangle(xCenter, yCenter, sideLength, inverse);

        // Draw the fractal pattern
        StdDraw.setPenColor(StdDraw.BLUE);
        drawSierpinksi(xCenter, yCenter, sideLength / 2, n, inverse);
        StdDraw.show();
    }
}
