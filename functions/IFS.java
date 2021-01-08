/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     21/02/2020
 *
 *  Execution:    java IFS trials < input.txt
 *
 *
 ******************************************************************************/

public class IFS {

    public static void main(String[] args) {

        // number of iterations
        int trials = Integer.parseInt(args[0]);

        // probability distribution for choosing each rule
        double[] dist = StdArrayIO.readDouble1D();

        // update matrices
        double[][] cx = StdArrayIO.readDouble2D();
        double[][] cy = StdArrayIO.readDouble2D();

        StdDraw.setCanvasSize(900, 900);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.enableDoubleBuffering();

        // current value of (x, y)
        double x = 0.0;
        double y = 0.0;

        // do trials iterations of the chaos game
        for (int t = 0; t < trials; t++) {

            // pick a random rule according to the probability distribution
            int r = StdRandom.discrete(dist);

            // do the update
            double x0 = cx[r][0] * x + cx[r][1] * y + cx[r][2];
            double y0 = cy[r][0] * x + cy[r][1] * y + cy[r][2];
            x = x0;
            y = y0;

            // draw the resulting point
            StdDraw.point(x, y);

            // for efficiency, display only every 500 iterations
            // if (t % 500 == 0) {
            //    StdDraw.show();
            // Pause if required
            // StdDraw.pause(10);
            //}
        }

        // ensure everything gets drawn
        StdDraw.show();
    }
}
