/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/02/2020
 *****************************************************************************
 *
 * Introduction:
 * A walker begins walking aimlessly. At each time step, she takes one step
 * in a random direction (either north, east, south, or west), each with
 * probability 25%. She stops once she is at 'Manhattan' distance r from the
 * starting point. How many steps will the random walker take?
 *
 * This process is known as a two-dimensional random walk.
 *
 * It is a discrete version of a natural phenomenon known as Brownian motion.
 * It serves as a scientific model for an astonishing range of physical
 * processes from the dispersion of ink flowing in water, to the formation
 * of polymer chains in chemistry, to cascades of neurons firing in the brain.
 *
 * This program takes two integer command-line arguments r and trials.
 * In each of trials independent experiments, it simulates a random walk until #
 * the random walker is at 'Manhattan' distance r from the starting point.
 * It then prints the average number of steps.
 *
 * As r increases, we expect the random walker to take more and more steps.
 * But how many more steps?
 * We use RandomWalkers.java to formulate a hypothesis as to how the average
 * number of steps grows as a function of r.
 *
 * NOTE:
 * Estimating an unknown quantity by generating random samples and aggregating
 * the results is an example of Monte Carlo simulation — a powerful
 * computational technique that is used widely in statistical physics,
 * computational finance, and computer graphics.
 *
 * */

public class RandomWalkers {

    public static void main(String[] args) {

        long r = Long.parseLong(args[0]);
        long trials = Long.parseLong(args[1]);
        long x = 0;
        long y = 0;
        long steps = 0;
        double direction;

        for (long i = 1; i <= trials; i++) {
            x = 0;
            y = 0;
            while (Math.abs(x) + Math.abs(y) < r) {
                direction = Math.random();
                if (direction < 0.25) {
                    x += 1;
                }
                else if (direction < 0.5) {
                    y += 1;
                }
                else if (direction < 0.75) {
                    x -= 1;
                }
                else {
                    y -= 1;
                }
                steps += 1;
            }
        }

        System.out.println("average number of steps = " + ((double) steps / (double) trials));
    }
}
