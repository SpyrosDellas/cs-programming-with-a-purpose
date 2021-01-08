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
 * This program takes an integer command-line argument r and simulates the
 * motion of a random walk until the random walker is at 'Manhattan' distance r
 * from the starting point.
 * It prints the coordinates at each step of the walk (including the starting
 * and ending points), treating the starting point as (0, 0).
 * Also, it prints the total number of steps taken.
 *
 * */

public class RandomWalker {

    public static void main(String[] args) {

        long r = Long.parseLong(args[0]);
        long x = 0;
        long y = 0;
        long steps = 0;
        double direction;

        System.out.println("(" + x + ", " + y + ")");

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
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println("steps = " + steps);
    }
}
