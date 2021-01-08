 /* *****************************************************************************
  *  Name:              Spyridon Theodoros Dellas
  *  Coursera User ID:  spyrosdellas@yahoo.com
  *  Last modified:     19/03/2020
  *
  * Returns the number of triples that sum to 0, from an unsorted array
  * a of N integers.
  * - Multiple appearances of the same value in the array are permitted
  * - A solution triple corresponds to a unique combination of three values from
  *   the array
  *
  *
  * The algorithm takes O(N^2) time and constant extra memory to solve the
  * problem as follows:
  *
  * Step 1:
  * Use quicksort to sort the array in place in O(N * logN) time and constant
  * extra memory. The array gets sorted in ascending order.
  *
  * Step 2:
  * For each entry a[i] in the sorted array, starting from a[0], we scan the
  * remaining entries a[j], j > i in pairs and check if the sum of the three
  * entries sums to 0, taking into account the possibility of consecutive entries
  * with the same value.
  * Using an approach that converges to a possible solution we can achieve the
  * scanning of the pairs of values in O(N) time, instead of O(N^2) time required
  * for a brute force scan:
  * - We start by selecting indices start = i + 1 and end = N - 1, which
  * correspond to the first entry larger than or equal to a[i] and the largest
  * entry respectively.
  * - If the sum of the three entries is 0 then a solution has been found. We
  * now need to check for the possibility of consecutive entries of the same
  * value and update start and end accordingly. If no consecutive entries exist,
  * then we can simply update start to start++ and end to end--
  * - If the sum of the three entries is greater than 0, then we are certain that
  * we need to check the next smaller value only for a possible solution and that
  * value is by necessity the value at end - 1.
  * - If the sum of the three entries is less than 0, then we are certain that
  * there can be no triples containing a[start] that sum to zero. Thus we need to
  * update start to start++ and keep end the same
  * - When start and end meet, we have exhausted the space of possible triples
  * containing a[i] and thus we can update i to i++ and start scanning the
  * remaining entries again, as per above
  *
  **************************************************************************** */

 import java.util.Arrays;

 public class ThreeSum {

     private static long combinations(int n, int k) {
         /* Calculates the combinations (n k) of n by k
          */
         if (n < k || n <= 0) return 0;
         else if (n == k) return 1;

         long combinations = 1;
         for (int i = n - k + 1; i <= n; i++) {
             combinations *= i;
         }
         for (int i = 1; i <= k; i++) {
             combinations /= i;
         }
         return combinations;
     }

     public static long threeSum(int[] a, boolean printTriples) {
        /* Implements an O(n^2) algorithm to find the triples that sum to 0.
        It is assumed a is unsorted.
         */

         // Edge case
         if (a.length < 3) return 0;

         // Sort the array
         QuickSort.sort(a);

         int start;
         int end;
         long count = 0;
         long n1 = 0;   // We have to use long type to avoid integer overflow
         long n2 = 0;   // when summing n1 + n2 + n3
         long n3 = 0;

         // For each element of the array, scan the remaining elements for
         // possible triples that sum to 0.
         for (int i = 0; i < a.length - 2; i++) {
             n1 = a[i];
             start = i + 1;
             end = a.length - 1;

             while (start < end) {
                 n2 = a[start];
                 n3 = a[end];
                 if (n1 + n2 + n3 != 0 && n2 == n3) break;
                 if (n1 + n2 + n3 == 0 && n2 == n3) {
                     long combs = combinations(end - start + 1, 2);
                     count += combs;
                     if (printTriples) {
                         System.out.println(
                                 n1 + " + " + n2 + " + " + n3 + " = 0, " +
                                         combs + " times");
                     }
                     break;
                 }
                 if (n1 + n2 + n3 == 0) {
                     int n2Count = 1;
                     int n3Count = 1;
                     for (int m = start + 1; m < end; m++) {
                         if (a[m] == a[start]) {
                             n2Count++;
                         }
                         else break;
                     }
                     for (int m = end - 1; m > start; m--) {
                         if (a[m] == a[end]) {
                             n3Count++;
                         }
                         else break;
                     }
                     count += n2Count * n3Count;
                     start += n2Count;
                     end -= n3Count;
                     if (printTriples) {
                         System.out.println(n1 + " + " + n2 + " + " + n3 +
                                                    " = 0, " + n2Count * n3Count
                                                    + " times");
                     }
                 }
                 else if (n1 + n2 + n3 > 0) {
                     end--;
                 }
                 else start++;
             }
         }

         return count;

     }

     public static void main(String[] args) {

         int[] test = new int[] { -3, 5, -8, 3, 10, -3, -50, 9, 8, 50, 3, 0, 6, -6, 6 };
         int[] test2 = new int[] { 0, 5, 3, 10, 0, 0, 50, 3, 0, 6, 0, 6 };

         System.out.println(Arrays.toString(test));
         QuickSort.sort(test);
         System.out.println("Result: ");
         System.out.println(Arrays.toString(test));

         System.out.println(threeSum(test, true));
     }
 }
