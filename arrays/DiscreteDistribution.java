/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     18/02/2020
 *
 * Takes an integer command-line argument m, followed by a sequence of
 * positive integer command-line arguments a1, a2, …, an, and prints m random
 * indices (separated by whitespace), choosing each index i with probability
 * proportional to ai.
 *
 * NOTE:
 * In probability theory, this process is known as sampling from a discrete
 * distribution.
 *
 * Examples:
 * > java DiscreteDistribution 25 1 1 1 1 1 1
 * 5 2 4 4 5 5 4 3 4 3 1 5 2 4 2 6 1 3 6 2 3 2 4 1 4
 *
 * > java DiscreteDistribution 25 10 10 10 10 10 50
 * 3 6 6 1 6 6 2 4 6 6 3 6 6 6 6 4 5 6 2 2 6 6 2 6 2
 *
 * > java DiscreteDistribution 25 80 20
 * 1 2 1 2 1 1 2 1 1 1 1 1 1 1 1 2 2 2 1 1 1 1 1 1 1
 *
 * > java DiscreteDistribution 100 301 176 125 97 79 67 58 51 46
 * 6 2 4 3 2 3 3 1 7 1 1 3 4 7 1 4 2 2 1 1 3 1 8 6 2
 * 1 3 6 1 8 5 1 3 6 1 1 2 3 8 7 4 6 4 3 1 5 3 3 7 3
 * 1 3 1 7 7 2 2 3 6 5 4 1 1 1 7 2 3 5 2 2 1 4 1 2 1
 * 2 1 2 2 3 2 8 4 3 2 1 8 3 5 3 3 8 1 2 3 3 1 2 3 1
 *
 * */

public class DiscreteDistribution {

    public static void main(String[] args) {

        // Number of samples
        int m = Integer.parseInt(args[0]);

        // Discrete distibution array
        int[] dDistribution = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            dDistribution[i - 1] = Integer.parseInt(args[i]);
        }

        // Converts the distibution to a sequence of intervals on a line
        // Each interval length is proportional to the probability of the ith
        // element of the distribution
        for (int i = 1; i < dDistribution.length; i++) {
            dDistribution[i] = dDistribution[i - 1] + dDistribution[i];
        }

        // Sample m times and print the index of the sample
        for (int i = 1; i <= m; i++) {

            double selection = Math.random() * dDistribution[dDistribution.length - 1];
            for (int index = 0; index < dDistribution.length; index++) {
                if (selection < (double) dDistribution[index]) {
                    System.out.print(index + 1 + " ");
                    break;
                }
            }
        }

    }
}
