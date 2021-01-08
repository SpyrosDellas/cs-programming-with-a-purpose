/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/03/2020
 *
 * Array rotation:
 * Implements a linear time algorith to rotate an array k positions, with at
 * most a constant amount of extra memory.
 *
 * That is, if the array contains a[0], a[1], …, a[n–1], the rotated array is
 * a[k], a[k+1], …, a[n–1], a[0], …, a[k–1].
 *
 * Note:
 * The critical restriction that forces us to use 3 subarray inversions is the
 * constant memory overhead, i.e. we can't use a helper array as a buffer
 *
 **************************************************************************** */

import java.util.Arrays;

public class ArrayRotation {

    public static void invertArray(String[] a, int start, int end) {
        /* Inverts a subarray a[start, end)
         */

        // Edge case
        if (start == end) return;

        // Constant memory overhead for the inversion
        String buffer;

        // Calculate mid index for the inversion. Equals to (N + 1) / 2, where
        // N is the length of the array
        int mid = start + (end - start + 1) / 2;

        for (int i = start; i < mid; i++) {
            buffer = a[i];
            a[i] = a[end - 1 - i + start];
            a[end - 1 - i + start] = buffer;
        }
    }

    public static void rotateArray(String[] a, int k) {

        int N = a.length;
        // Edge cases
        if (k <= 0 || k >= N) return;

        // First step: Invert the two subarrays a[0, k+1), a(k, N)
        invertArray(a, 0, k + 1);
        invertArray(a, k + 1, N);

        // Second step: Invert the subarray a[1, N)
        invertArray(a, 1, N);
    }

    public static void main(String[] args) {

        // Create a test array for visualisation purposes
        String[] testArray = new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"
        };

        int k = Integer.parseInt(args[0]);

        System.out.println(Arrays.toString(testArray));
        rotateArray(testArray, k);
        System.out.println(Arrays.toString(testArray));
    }
}
