/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/03/2020
 *
 * Given an array of n integers from 1 to n with one value repeated twice and
 * one missing, implement an algorithm that finds the missing integer, in linear
 * time and constant extra memory. Integer overflow is not allowed.
 *
 * Note:
 * The critical restrictions above that forces us to be 'creative' are the
 * constant extra memory and the integer overflow not permitted.
 *
 **************************************************************************** */

public class RepeatedIntegerEasy {

    private static int[] randomArray(int N) {
        /* Create an array of integers from 1 to N for testing purposes. One
        value is repeated twice and one is missing.
         */

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
        }
        // Random entry replaces next entry, thus creating one duplicate and one
        // missing value
        int randomEntry = 1 + (int) (Math.random() * N);
        if (randomEntry < N) {
            a[randomEntry] = randomEntry;
        }
        else {
            a[0] = randomEntry;
        }
        // Random shuffle the array
        for (int i = 0; i < N; i++) {
            int index = i + (int) (Math.random() * (N - i));
            int buf = a[i];
            a[i] = a[index];
            a[index] = buf;
        }
        return a;
    }

    public static int findMissingValue(int[] a) {
        // To solve the problem we traverse the array once from start to end
        // The value a[i] at position i is treated as a pointer to position
        // a[i] - 1. We then multiply the value at a[i] - 1 with -1. That's a
        // mark that the value pointing to this position has been encountered.
        // If there weren't any missing values this would turn all entries of
        // the array to negative. If there is one missing value, then the index
        // (plus one) of the single value remaining positive is the missing
        // value
        int missingValue = 0;
        int pointer = 0;

        for (int i = 0; i < a.length; i++) {
            // Handle the case that the value is already set to negative
            if (a[i] > 0) pointer = a[i] - 1;
            else pointer = -a[i] - 1;
            // If the value at a[pointer] is not negative already, set it to
            // negative
            if (a[pointer] > 0) {
                a[pointer] *= -1;
            }
        }
        // Scan the array for the positive value
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) missingValue = i + 1;
            break;
        }
        return missingValue;
    }

    public static void test(int N, int doublingTrials) {

        for (int trial = 1; trial <= doublingTrials; trial++) {
            int newN = N * (int) Math.pow(2, trial - 1);
            int[] a = randomArray(newN);
            long start = System.currentTimeMillis();
            int missingValue = findMissingValue(a);
            long end = System.currentTimeMillis();
            double execTime = (end - start) / 1000.0;
            System.out.printf("For array size n = %d, the execution "
                                      + "time is %.3f secs \n", newN, execTime);
        }

    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int doublingTrials = Integer.parseInt(args[1]);
        test(N, doublingTrials);
    }
}
