/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     20/02/2020
 *
 *
 * Spirographs.
 * This program takes three double command-line arguments R, r, and a and
 * draws the resulting spirograph.
 * A spirograph (technically, an epicycloid) is a curve formed by rolling
 * a circle of radius r around a larger fixed circle of radius R.
 *
 * If the pen offset from the center of the rolling circle is (r+a), then the
 * equation of the resulting curve at time t is given by:
 *
 * x(t) = (R + r) cos (t) - (r + a) cos ((R + r )t/r)
 * y(t) = (R + r) sin (t) - (r + a) sin ((R + r )t/r)
 *
 * Such curves were popularized by a best-selling toy that contains discs
 * with gear teeth on the edges and small holes that you could put a pen in
 * to trace spirographs.
 *
 **************************************************************************** */

public class Spirograph {

    public static void main(String[] args) {

        double R = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        double a = Double.parseDouble(args[2]);

        double xStart = -(R + 2 * r + a);
        double xEnd = R + 2 * r + a;
        double yStart = -(R + 2 * r + a);
        double yEnd = R + 2 * r + a;

        StdDraw.setXscale(xStart, xEnd);
        StdDraw.setYscale(yStart, yEnd);

        // to speed up performance, defer displaying points
        StdDraw.enableDoubleBuffering();

        double t = 0;
        while (t < 8 * Math.PI) {
            double xT = (R + r) * Math.cos(t) - (r + a) * Math.cos((R + r) * t / r);
            double yT = (R + r) * Math.sin(t) - (r + a) * Math.sin((R + r) * t / r);
            StdDraw.point(xT, yT);
            t += 0.01;
        }
        // display all of the points now
        StdDraw.show();

    }
}
