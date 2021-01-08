/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     19/02/2020
 *
 * Duplicates code fragment:
 * Given an integer array of length n, with each value between 1 and n,
 * write a code fragment to determine whether there are any duplicate values.
 *
 * You may not use an extra array (but you do not need to preserve the
 * contents of the given array.)
 ***************************************************************************
 * */

import java.util.Arrays;

public class Duplicates {

    public static void main(String[] args) {

        // Create and populate an array of length n for testing
        int[] sample = new int[] { 4, 3, 5, 8, 7, 2, 6, 7 };

        // To solve the problem without an extra array, we need to take into
        // account that:
        // a. All values are positive
        // b. Each value is between 1 and n
        //
        // For each entry in the array we set the corresponding index value to
        // negative. A negative value means that this entry was already
        // encountered.
        // For example:
        // for sample[5]:
        //   If sample[abs(sample[5])-1] < 0:
        //     break;
        //   else:
        //     sample[abs(sample[5])-1] = - sample[abs(sample[5])-1]

        boolean result = false;
        int duplicateEntry = 0;

        for (int i = 0; i < sample.length; i++) {
            if (sample[Math.abs(sample[i]) - 1] < 0) {
                result = true;
                duplicateEntry = Math.abs(sample[i]);
                break;
            }
            else {
                sample[Math.abs(sample[i]) - 1] *= -1;
            }
        }
        System.out.println("Transformed array: " + Arrays.toString(sample));
        System.out.println("Duplicate entries exist: " + result);
        if (result) {
            System.out.println("First duplicate entry: " + duplicateEntry);
        }
    }
}
