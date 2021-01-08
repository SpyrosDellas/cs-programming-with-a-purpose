/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     21/02/2020
 *
 * Takes a real command-line argument α and plots a globe-like pattern
 * with parameter α.
 *
 * Plots the polar coordinates (r, θ) of the function:
 *
 * f(θ) = cos(α × θ) for θ ranging from 0 to 21600 degrees.
 *
 * Try α = 0.8, 0.9, and 0.95.
 *
 **************************************************************************** */

public class Globe {

    public static void main(String[] args) {

        double alpha = Double.parseDouble(args[0]);

        StdDraw.setYscale(-1, +1);
        StdDraw.setXscale(-1, +1);
        StdDraw.setPenColor(StdDraw.BLUE);

        // enable double buffering
        StdDraw.enableDoubleBuffering();

        double x0 = 1, y0 = 0;
        for (double t = 0.0; t <= 60 * 360.0; t += 0.1) {
            double theta = Math.toRadians(t);
            double r = Math.cos(alpha * theta);
            double x1 = r * Math.cos(theta);
            double y1 = r * Math.sin(theta);
            StdDraw.line(x0, y0, x1, y1);
            x0 = x1;
            y0 = y1;
        }
        StdDraw.show();

    }

}
