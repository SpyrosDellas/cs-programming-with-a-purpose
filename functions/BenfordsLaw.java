/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     23/02/2020
 *
 * Benford's law:
 * The American astronomer Simon Newcomb observed a quirk in a book that
 * compiled logarithm tables: the beginning pages were much grubbier than the
 * ending pages. He suspected that scientists performed more computations
 * with numbers starting with 1 than with 8 or 9, and postulated the first
 * digit law, which says that under general circumstances, the leading digit
 * is much more likely to be 1 (roughly 30%) than the digit 9 (less than 4%).
 *
 * This phenomenon is known as Benford's law and is now often used as a
 * statistical test. For example, IRS forensic accountants rely on it to
 * discover tax fraud.
 *
 * Wikipedia: https://en.wikipedia.org/wiki/Benford%27s_law
 *
 * Benford's law tends to be most accurate when values are uniformly distributed
 * across multiple orders of magnitude, especially if the process generating the
 * numbers is described by a power law (which are common in nature).
 * For example the Fibonacci numbers and the powers of 2 follow Benford's law.
 *
 * Counterexamples that don't follow Benford's law are the Normal distribution
 * and the Uniform distribution.
 *
 * As noticed by Benford, the union of his tables is what came closest to the
 * predicted law: the more the datas come from various sources, the better
 * they fit the law.
 * We model these different sources by uniformly distributed random variables
 * bounded by an unknown maximum S depending on the source.
 * The first reason is that it is natural to introduce uniform distributions to
 * describe data on which we do not know anything. Besides, we can
 * find many cases where the distribution of empirical data are naturally
 * modelized by some mixture of uniform distributions. A simple one is
 * constituted by all the numbers describing the month and the day of the month
 * for the birthdays of a list of people: The month is well approximated by a
 * uniform random variable taking its values in {1, 2, . . . , 12}, and given
 * the month the day itself is uniformly distributed in {1, 2, . . . ,(number of
 * days in this month)}.
 * The example of street addresses also presents this
 * kind of phenomenon: Imagine you only know that the numbers of the addresses
 * in a given street vary between 1 and S. By the principle of indifference,
 * picking a random address in this street naturally gives rise to a random v
 * ariable uniformly distributed between 1 and S. In other words, conditioned
 * on the highest number S in the street, the street numbers follow a uniform
 * distribution on {1, . . . , S}. So the set of street numbers used by Benford
 * can be seen as a mixture of uniform distributions, weighted by the law of the
 * highest number of a street.
 * A third example is the first-page numbers of articles in a bibliography,
 * which, conditioned on the sizeS of the volume, can be considered uniformly
 * distributed. Of course, not every set of empirical data is well described
 * by uniform distributions. However it is easy to check that averaging over
 * many different such sets with varying laws amounts to considering uniformly
 * distributed variables.
 *
 *
 * BenfordsLaw.java
 * Carries out a Monte Carlo simulation for 'trialDistributions' number of
 * uniform distributions. Each distribution starts at 10^n and its range
 * is randomly selected in [10^n, 10^(n+1)), n >= 0.
 *
 * For n = 0:
 *   For trialDistributions:
 *     1. Select a random 'range', in [1, 9]
 *     2. Randomly select 'trials' values from the uniform distribution that
 *        spans [1, 1 + range)
 *     3. Count the values that start with 1
 *   Calculate the overall probability of a value starting with 1
 *
 * For n = 1:
 *   For trialDistributions:
 *     1. Select a random 'range', in [10, 20, 30, ..., 90]
 *     2. Randomly select 'trials' values from the uniform distribution that
 *        spans [10, 10 + range)
 *     3. Count the values that start with 1
 *   Calculate the overall probability of a value starting with 1
 *
 * For n = 2:
 *  For trialDistributions:
 *     1. Select a random 'range', in [100, 200, 300, ..., 900]
 *     2. Randomly select 'trials' values from the uniform distribution that
 *        spans [100, 100 + range)
 *     3. Count the values that start with 1
 *   Calculate the overall probability of a value starting with 1
 *
 * etc......
 *
 * The above process essentially simulates a uniformly distributed variable
 * across several orders of magnitude as follows:
 * - A value can be uniformly distributed in [1, 1 + x), 1 <= x <= 9 for
 *   uniformly random x
 * - A value can be uniformly distributed in [10, 10 + x), 10 <= x <= 90 for
 *   uniformly random x in [10, 20, 30... , 90], i.e. the value can be
 *   uniformly ranging from 10 to 20 or from 10 to 50, etc
 * - Etc.
 *
 **************************************************************************** */

public class BenfordsLaw {

    // Returns the number of 'trials' values starting with '1'
    // The values are randomly selected from the uniform distribution
    // [uStart, uStart + range)
    private static int uDistributionOnes(int uStart, int range, int trials) {

        int counter = 0;
        for (int i = 1; i <= trials; i++) {
            int value = uStart + (int) (Math.random() * range);

            // Check if first digit is 1
            while (value >= 10) {
                value /= 10;
            }
            if (value == 1) counter += 1;
        }
        return counter;
    }


    public static void main(String[] args) {

        int trialDistributions = 1000;
        int trials = 10000;
        int counter = 0;
        double result;

        int n = 3;
        int uStart = (int) Math.pow(10, n);
        int uEnd = (int) Math.pow(10, n + 1);

        // Monte Carlo simulation for various ranges of uniform distributions
        for (int i = 1; i <= trialDistributions; i++) {

            // Randomly select the range of the uniform distibution to be
            // within [1, uEnd-uStart]
            int range = uStart * (1 + (int) (Math.random() * 9));
            counter += uDistributionOnes(uStart, range, trials);
        }

        result = ((double) counter / trials) / trialDistributions;

        System.out.println("Probability of first digit to be 1: " + result);
    }
}
