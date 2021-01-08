/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     21/02/2020
 *
 * Plots a butterfly-like curve.
 *
 * Plots the polar equation:
 *    r = e^(cos(t)) - a * cos(b*t) + sin(t/c)^5, where
 *        the parameter t is in radians
 *
 *********************************************************** */

public class Butterfly {

    public static void main(String[] args) {

        StdDraw.setCanvasSize(900, 900);
        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);

        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.BLUE);

        int a = 2;
        int b = 5;
        int c = 12;

        double x0 = 0;
        double y0 = 0;
        for (double theta = 0.0; theta < 72; theta += 0.01) {

            double r = Math.exp(Math.cos(theta)) - a * Math.cos(b * theta) + Math
                    .pow(Math.sin(theta / c), 5);

            double x1 = r * Math.cos(theta);
            double y1 = r * Math.sin(theta);
            StdDraw.line(x0, y0, x1, y1);
            x0 = x1;
            y0 = y1;
        }
        StdDraw.show();
    }
}
