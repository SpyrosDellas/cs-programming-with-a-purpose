/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/03/2020
 *
 * Given a read-only array of n integers with values between 1 and n–1,
 * implement an algorithm that finds a duplicated value, in linear time and
 * constant extra memory.
 *
 * Note:
 * The critical restrictions above that forces us to be 'creative' are the
 * constant extra memory and the read-only property of the array.
 *
 **************************************************************************** */

import java.util.Arrays;

public class RepeatedIntegerHard {

    private static int[] randomArray(int N) {
        /* Create an array of random integers from 1 to N-1 for testing.
         */

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = 1 + (int) (Math.random() * (N - 1));
        }
        return a;
    }

    public static int findDuplicateValue(int[] a) {
        /* We note that there can be multiple duplicate values in the array,
        but the algorithm is required to identify only one. Furthermore, the
        array is read only and we are constrained to use constant extra memory.

        The solution is a bit tricky:

        1. We use each value of the array as pointer to the next value. For
           example if a[0] = 1 we examine the value of a[1], if a[1] = 3 we
           examine the value of a[3], etc. Since each 1 <= value <= N-1, by
           construction of the array, we are guaranteed to eventually loop
           through some of the elements of the array, excluding the element
           at a[0] as we would need a value of 0 to point to a[0].

         2. A further breakthrough towards a solution, is the observation that
            the value of the last entry that pointed to the start of the loop
            is necessarily a duplicate entry, as there is another entry with
            same value inside the loop that points to the start of the loop.

         3. As we are constrained to use constant extra memory, we arrive at
            an elegant solution to identify that we have started looping through
            the array:
            We use 2 pointers, a slow one and a fast one that moves
            twice the speed of the slow. Like cars in a racetrack, the fast
            pointer will eventually reach the slow pointer, i.e they will both
            point to the same index of the array.

         4. The final missing piece to a solution is to recover the last value
            before entering the loop, as this is guaranteed to be a duplicate
            value.
            The breakthrough here is the observation that if we reset the slow
            pointer to 0 and start moving both pointers at the same speed then
            both pointers will be equal again when they both point to the loop
            entry!

            For example, we have the array a = [3, 2, 4, 1, 5, 1], which
            loops from a[3] = 1 (entry point) as follows:
            a[0] -> a[3] ==> a[1] -> a[2] -> a[4] -> a[5] -> a[1]

            We start moving through the elements of the array, until the fast
            pointer cathces up with the slow pointer:

            slowPointer = fastPointer = 0
            Step 1:
            slowPointer: 3 (= a[0])
            fastPointer: 3, 1 (= a[0], a[3])
            Step 2:
            slowPointer: 1
            fastPointer: 2, 4
            Step 3:
            slowPointer: 2
            fastPointer: 5, 1
            Step 4 - final step:
            slowPointer: 4 <===
            fastPointer: 2, 4 <===

            slowPointer takes the values: 3 1 2 4
               (2 steps ouside the loop and 2 steps inside the loop)
            fastPointer takes the values: 3 1 2 4 5 1 2 4
               (2 steps outside the loop, one full loop of 4 steps, plus 2 steps
               inside the loop)
            then we set slowPointer = 0 and we continue moving until the two
            pointers are equal again after 2 steps:
            slowPointer takes the values: 0 -> 3 1 <==
            fastPointer takes the values: 4 -> 5 1 <== Duplicate found!

            Note: The above process can be quite difficult to understand. It's
            easier to explain why it works in the case when the two pointers
            meet exactly at the entry point to the loop, i.e. the length of the
            loop is equal to the distance from the start of the array to the
            entry point of the loop.
         */

        int N = a.length;
        int slowPointer = 0;
        int fastPointer = 0;

        // Start moving through the elements of the array, until the fast
        // pointer cathces up with the slow pointer.
        while (slowPointer != fastPointer || fastPointer == 0) {
            slowPointer = a[slowPointer];  // Slow pointer moves one step
            fastPointer = a[fastPointer];  // Fast pointer moves first step
            fastPointer = a[fastPointer];  // Fast pointer moves second step
        }
        slowPointer = 0;   // Reset slow pointer to the start of the array
        // Start moving through the elements of the array, until the slow
        // pointer meets with the fast pointer, which now moves at the same
        // speed.
        while (slowPointer != fastPointer) {
            slowPointer = a[slowPointer];  // Slow pointer moves one step
            fastPointer = a[fastPointer];  // Fast pointer moves one step
        }
        return slowPointer;
    }


    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        int[] a = randomArray(N);
        System.out.println(Arrays.toString(a));
        int duplicateValue = findDuplicateValue(a);
        System.out.println(duplicateValue);
    }
}
