/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     21/02/2020
 *
 * Fourier Spikes.
 *
 * Takes a command-line argument n and plots the function:
 * (cos(t) + cos(2*t) + cos(3*t) + … + cos(n*t)) / n
 * for 1000 equally spaced samples of t from -10 to 10 (in radians).
 *
 * Suggested runs: n = 5 and n = 500.
 *
 * Note:
 * The sum converges to a spike (0 everywhere except a single value).
 * This property is the basis for a proof that any smooth function can be
 * expressed as a sum of sinusoids.
 *
 *********************************************************************** */

public class FourierSpikes {


    public static double fSpike(int n, double t) {
        double result = 0.0;
        for (int i = 1; i <= n; i++) {
            result += Math.cos(i * t);
        }
        return result / n;
    }


    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        StdDraw.setCanvasSize(900, 900);
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-1, 1.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.enableDoubleBuffering();

        double xStart = -10;
        double yStart = fSpike(n, xStart);
        for (double t = -10; t <= 10; t += 0.02) {
            double xEnd = t;
            double yEnd = fSpike(n, t);
            StdDraw.line(xStart, yStart, xEnd, yEnd);
            xStart = xEnd;
            yStart = yEnd;
        }
        StdDraw.show();
    }

}
