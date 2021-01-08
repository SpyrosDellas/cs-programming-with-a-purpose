/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     07/03/2020
 *
 * Given an array of integers, a pair of elements a[i] and a[j] are inverted
 * if i < j and a[i] > a[j]. For example, the array a[] has 1 inversion and the
 * array b[] has 4 inversions.
 *  a = [0, 1, 2, 3, 5, 4, 6]
 *  b = [0, 4, 1, 2, 5, 3, 6]
 *
 * Note:
 * Counting inversions arise in a number of applications, including sorting,
 * voting theory, collaborative filtering, rank aggregation, and
 * non-parametric statistics.
 *
 * Required behavior:
 * Permutations: A permutation of length n is an integer array of length n
 * that contains each of the n integers 0, 1, ..., n–1 exactly once.
 * Output format: The main() method should print the permutation of length n to
 * standard output as a sequence of n integers, separated by whitespace, all on
 * one line.
 * Performance: The count() method should take time proportional to n^2 in the
 * worst case. The generate() method should take time proportional to n in the
 * worst case.
 * Corner cases: We assume that the arguments to generate() satisfy n ≥ 0 and
 * 0 ≤ k ≤ (1/2) * n * (n − 1); this guarantees the existence of a permutation
 * of length n with exactly k inversions.
 *
 **************************************************************************** */

public class Inversions {


    public static long count(int[] a) {
        /* Returns the number of inversions in the permutation a[]
         */

        long count = 0;
        int previous = -1;

        // Keeps track of the inversions for each element a[i] of the array,
        // i.e. the number of pairs (a[i], a[j]) with i < j and a[i] > a[j]
        int inversions = 0;

        for (int i = 0; i < a.length; i++) {
            int current = a[i];

            // Difference between 2 consecutive elements is 1. The number of
            // inverted pairs remains the same
            if (current - previous == 1) {
                count += inversions;
            }

            // Difference between 2 consecutive elements is -1. The number of
            // inverted pairs is reduced by 1
            else if (current - previous == -1) {
                inversions -= 1;
                count += inversions;
            }

            // Difference between 2 consecutive elements is less than -1.
            // There can be at most max(a[i+1], inversions-(a[i]-a[i+1]))
            // inversions left
            else if (current - previous < -1) {
                int maxRemainingInversions =
                        Math.max(current, inversions - (previous - current));
                if (i <= a.length / 2) {
                    int counter = maxRemainingInversions;
                    for (int j = 0; j < i - 1; j++) {
                        if (a[j] < current) counter--;
                        if (counter == 0) break;
                    }
                    inversions = counter;
                    count += inversions;
                }
                else {
                    int counter = 0;
                    for (int j = i + 1; j < a.length; j++) {
                        if (a[j] < current) counter++;
                        if (counter == maxRemainingInversions) break;
                    }
                    inversions = counter;
                    count += inversions;
                }
            }

            // Difference between 2 consecutive elements is greater than 1
            // There can be at most (a[i+1] - a[i] - 1) additional inversions
            else {
                int maxNewInversions = current - previous - 1;
                if (i <= a.length / 2) {
                    int counter = maxNewInversions;
                    for (int j = 0; j < i - 1; j++) {
                        if (a[j] < current && a[j] > previous) counter--;
                        if (counter == 0) break;
                    }
                    inversions += counter;
                    count += inversions;
                }
                else {
                    int counter = 0;
                    for (int j = i + 1; j < a.length; j++) {
                        if (a[j] < current && a[j] > previous) counter++;
                        if (counter == maxNewInversions) break;
                    }
                    inversions += counter;
                    count += inversions;
                }
            }
            previous = current;
        }

        return count;
    }


    public static int[] generate(int n, long k) {
        /* Returns a permutation of length n with exactly k inversions
         */
        int[] permutation = new int[n];

        // Base case for n = 0
        if (n == 0) return permutation;

        int head = n - 1;
        int index = 0;
        long count = k;
        boolean start = true;

        while (count != 0 || start) {
            start = false;
            if (count > head) {
                permutation[index] = head;
                count -= head;
                head--;
                index++;
            }
            else {
                permutation[index] = (int) count;
                index++;
                for (int i = 0; i < count; i++) {
                    permutation[index + i] = i;
                }
                for (int i = (int) count; (index + i) < permutation.length; i++) {
                    permutation[index + i] = i + 1;
                }
                break;
            }
        }
        return permutation;
    }


    public static void main(String[] args) {
        /* Takes an integer n and a long k as command-line arguments, and prints
        a permutation of length n with exactly k inversions
         */

        // int[] test = new int[] { 2, 7, 8, 1, 6, 14, 11, 5, 12, 3, 0, 9, 4, 13, 10 };
        // System.out.println(count(test));

        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] permutation = generate(n, k);
        for (int num : permutation) {
            StdOut.print(num + " ");
        }
    }
}
