/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     20/02/2020
 *
 * ShannonEntropy
 * Takes a command-line integer m; reads a sequence of integers between 1 and m
 * from standard input; and prints the Shannon entropy to standard output,
 * with 4 digits after the decimal point.
 *
 * The Shannon entropy of a sequence of integers is given by the formula:
 *
 * H = - E[log2(Px)] <=>
 * H = − (p1 * log2(p1) + p2 * log2(p2) + … + pm * log2(pm)),
 * where pi denotes the proportion of integers whose value is i. If pi=0, then
 * we treat pi * log2(pi) as 0.
 *
 * The unit of measurement is bits or Shannons
 *
 * In other words, the Shannon entropy of a distribution is the expected amount
 * of information in an event drawn from the distribution. It gives a lower
 * bound on the number of bits needed on average to encode symbols drawn from a
 * distribution P.
 * Distributions that are nearly deterministic have low entropy; distributions
 * that are closer to uniform have high entropy
 *
 * NOTE:
 * The Shannon entropy is a fundamental concept in information theory and data
 * compression.
 *
 **************************************************************************** */

public class ShannonEntropy {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);

        // Create storage array for the number of occurences of each value
        // i in [1, m]
        int[] distribution = new int[m + 1];  // index 0 will be ignored

        double counter = 0;
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            distribution[i] = distribution[i] + 1;
            counter += 1;
        }

        // Calculate the probabilities of the distribution
        double[] probabilities = new double[m + 1];
        for (int i = 1; i <= m; i++) {
            probabilities[i] = distribution[i] / counter;
        }

        // Calculate the Shannon entropy
        double shannonEntropy = 0.0;
        double log2 = Math.log(2);
        for (int i = 1; i <= m; i++) {
            if (probabilities[i] > 0) {
                shannonEntropy -= (probabilities[i] *
                        Math.log(probabilities[i]) / log2);
            }
        }

        StdOut.printf("%.4f", shannonEntropy);

    }
}
