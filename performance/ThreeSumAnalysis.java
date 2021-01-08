/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     18/03/2020
 *
 * Three-sum analysis.
 *
 * PART A
 * Calculates the probability that no triple among n random 32-bit integers
 * sums to 0, and validates the result via simulation.
 *
 * The probability that no triple equals to 0 is:
 *
 * P(n) = [1 - 6 * (2^27 + 3 / 16 - 1 / 2^34) / 2^62] ^ (n 3), where (n 3) are
 * the combinations of n by 3.
 *
 * PART B
 * Calculates the expected number of triples (as a function of n) that sum to 0,
 * and validates the result via simulation.
 *
 * E(n) = [6 * (2^27 + 3 / 16 - 1 / 2^34) / 2^62] * (n 3), where (n 3) are the
 * combinations of n by 3.
 *
 * Note:
 * The n random integers are independently randomly chosen
 *
 **************************************************************************** */

import java.util.Random;

public class ThreeSumAnalysis {

    private static int[] randomArray(int N) {
        /* Create an array of size N, consisting of random 32-bit integers.
         */
        int[] a = new int[N];
        Random genny = new java.util.Random();
        for (int i = 0; i < N; i++) {
            a[i] = genny.nextInt();  // Generates a random 32-bit integer
        }
        return a;
    }

    private static long combinations(int n, int k) {
        /* Calculates the combinations (n k) of n by k
         */
        if (n == 0) return 0;
        long combinations = 1;
        for (int i = n - k + 1; i <= n; i++) {
            combinations *= i;
        }
        for (int i = 1; i <= k; i++) {
            combinations /= i;
        }
        return combinations;
    }

    private static double probOfNoZeroSumTriples(int n) {
        /* Calculates the probability that no triple among n random 32-bit integers
           sums to 0
         */
        long combinations = combinations(n, 3);
        double p1 = 1 - 6 * (Math.pow(2, 27) + 3.0 / 16 - 1.0 / Math.pow(2, 34)) / Math.pow(2, 62);
        return Math.pow(p1, combinations);
    }

    private static double numberOfZeroSumTriples(int n) {
        /* Calculates the expected number of triples among n random 32-bit
        integers that sum to 0
         */
        long combinations = combinations(n, 3);
        double triples = combinations * 6 * ((Math.pow(2, 27) + 3.0 / 16 - 1.0 /
                Math.pow(2, 34)) / Math.pow(2, 62));
        return triples;
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        double prob = probOfNoZeroSumTriples(n);
        double triples = numberOfZeroSumTriples(n);
        System.out.printf("For n = %d, the probability that no triples "
                                  + "sum to 0 is: %.12f. ", n, prob);
        System.out.printf("Expected number of triples that sum to 0 is: %.3f \n", triples);
        System.out.println();

        // Monte Carlo simulation to validate the theoretical result
        System.out.println("Running Monte Carlo simulation for " + trials
                                   + " trials...");
        long total = 0;
        for (int i = 1; i <= trials; i++) {
            int[] a = randomArray(n);
            triples = ThreeSum.threeSum(a, false);
            total += triples;
            System.out.println("For trial " + i + ", found " + triples +
                                       " triples that sum to 0");
        }
        System.out.println(
                "Average number of triples after " + trials + " trials: "
                        + (double) total / trials);
    }
}
