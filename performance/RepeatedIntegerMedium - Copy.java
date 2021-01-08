/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/03/2020
 *
 * Given a read-only array of n integers, where each value from 1 to n–1 occurs
 * once and one occurs twice, implement an algorithm that finds the duplicated
 * value, in linear time and constant extra memory.
 *
 * Note:
 * The critical restrictions above that forces us to be 'creative' are the
 * constant extra memory and the read-only property of the array.
 *
 **************************************************************************** */

public class RepeatedIntegerMedium {

    private static int[] randomArray(int N) {
        /* Create an array of integers from 1 to N-1 for testing purposes.
        Every value occurs once and one value twice.
         */

        int[] a = new int[N];
        for (int i = 0; i < N - 1; i++) {
            a[i] = i + 1;
        }
        // A random entry from 1 to N-1 is assigned as the last entry of the
        // array, thus creating one duplicate value
        int randomEntry = 1 + (int) (Math.random() * (N - 1));
        a[N - 1] = randomEntry;

        // Random shuffle the array
        for (int i = 0; i < N; i++) {
            int index = i + (int) (Math.random() * (N - i));
            int buf = a[i];
            a[i] = a[index];
            a[index] = buf;
        }
        return a;
    }

    public static int findDuplicateValue(int[] a) {
        // We can solve this problem by taking advantage of the known value
        // of the sum: S = 1 + 2 + 3 + .. + N-1 = N * (N-1) / 2
        // We need to sum up all the elements of the array first and then
        // deduct S. the difference is the missing value

        int N = a.length;
        long S = (N * (N - 1)) / 2;
        long sum = 0;

        // Sum the values of the array
        for (int i = 0; i < N; i++) {
            sum += a[i];
        }
        return (int) (sum - S);
    }

    public static void test(int N, int doublingTrials) {

        for (int trial = 1; trial <= doublingTrials; trial++) {

            int newN = N * (int) Math.pow(2, trial - 1);
            int[] a = randomArray(newN);
            long start = System.currentTimeMillis();
            int duplicateValue = findDuplicateValue(a);
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
