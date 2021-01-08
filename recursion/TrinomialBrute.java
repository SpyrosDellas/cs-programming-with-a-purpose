/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     29/02/2020
 *
 * Trinomial coefficients (brute force)
 *
 * Takes two integer command-line arguments n and k and computes the
 * corresponding trinomial coefficient. The trinomial coefficient T(n, k) is the
 * coefficient of x^(n + k) in the expansion of (1 + x + x^2)^n.
 *
 * For example:
 * (1 + x + x^2)^3 = 1 + 3*x + 6*x^2 + 7*x^3 + 6*x^4 + 3*x^5 + x^6
 * Thus T(3, 3) = 1, T(3, 2) = 3, T(3, 1) = 6, and T(3, 0) = 7
 *
 * Implements a recursive function trinomial() to compute T(n,k) by using the
 * following recurrence relation:
 * T(n, k) = 1, if n = 0 and k = 0
 * T(n, k) = 0, if k < - n or k > n
 * T(n, k) = T(n−1, k−1) + T(n−1, k) + T(n−1, k+1), otherwise
 *
 * Note 1:
 * Above approach is hopelessly slow for moderately large values of n and k.
 *
 * Note 2:
 * Trinomial coefficients arise in combinatorics. For example, T(n, k) is the
 * number of permutations of n symbols, each of which is −1, 0, or +1, which
 * sum to exactly k and T(n, k−n) is the number of different ways of randomly
 * drawing k cards from two identical decks of n playing cards.
 *
 **************************************************************************** */

public class TrinomialBrute {

    // Returns the trinomial coefficient T(n, k). We assume n > 0
    public static long trinomial(int n, int k) {

        // Base cases of the recursion
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;

        // Recursive case
        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);

    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
