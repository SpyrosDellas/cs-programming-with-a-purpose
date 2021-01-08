/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     01/03/2020
 *
 * Trinomial coefficients - Dynamic Programming approach
 *
 * Takes two integer command-line arguments n and k and computes the
 * corresponding trinomial coefficient using dynamic programming.
 *
 * The trinomial coefficient T(n, k) is the
 * coefficient of x^(n + k) in the expansion of (1 + x + x^2)^n.
 *
 **************************************************************************** */

import java.util.Arrays;

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k). We assume n > 0
    public static long trinomial(int n, int k) {

        // Base cases
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;

        // Create memoization array for the bottom-up dynamic programming
        // solution. We know that |k| <= n
        // We need one extra row (row 0) to allow lookup work for n = 1
        // We need 3 extra columns: one for k = 0 and two columns of zeros at
        // the ends to allow the lookup work for |k| = n
        long[][] coefficients = new long[n + 1][2 * n + 3];

        coefficients[0][n + 1] = 1;  // Corresponds to n = 0, k = 0

        for (int i = 1; i <= n; i++) {                      // for each n
            int start = Math.max(1, k + 2 + i - 1);
            int end = Math.min(2 * n + 1, 2 * n + k - i + 1);
            for (int j = start; j <= end; j++) {            // for each k
                coefficients[i][j] = coefficients[i - 1][j - 1] +
                        coefficients[i - 1][j] +
                        coefficients[i - 1][j + 1];
            }
        }
        // For visualization only
        for (long[] row : coefficients) {
            System.out.println(Arrays.toString(row));
        }
        return coefficients[n][n + 1 + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }

}
