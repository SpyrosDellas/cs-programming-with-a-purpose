/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 *
 *  Play chaos game on triangle to produce Sierpinski gasket.
 *  Plot trials points of the specified radius.
 *
 *  % java Chaos 10000
 *
 * */

public class Chaos {

    public static void main(String[] args) {

        int trials = Integer.parseInt(args[0]);

        if (args.length == 2) {
            double radius = Double.parseDouble(args[1]);
            StdDraw.setPenRadius(radius);
        }

        // Triangle vertices coordinates
        double[] cx = { 0.000, 1.000, 0.500 };
        double[] cy = { 0.000, 0.000, 0.866 };

        // Starting point
        double x = 0.0, y = 0.0;

        StdDraw.enableDoubleBuffering();

        for (int t = 0; t < trials; t++) {

            int r = (int) (Math.random() * 3);
            x = (x + cx[r]) / 2.0;
            y = (y + cy[r]) / 2.0;

            if (r == 0) StdDraw.setPenColor(StdDraw.RED);
            else if (r == 1) StdDraw.setPenColor(StdDraw.GREEN);
            else StdDraw.setPenColor(StdDraw.BLUE);

            StdDraw.point(x, y);
        }

        StdDraw.show();
    }
}
