/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     22/02/2020
 *
 * Computex the greatest common divisor and related functions on integers:
 *
 * The greatest common divisor (gcd) of two integers a and b is the largest
 * positive integer that is a divisor of both a and b. For example,
 * gcd(1440, 408) = 24 because 24 is a divisor of both 1440 and 408
 * (1440=24⋅60,408=24⋅17) but no larger integer is a divisor of both.
 * By convention, gcd(0,0)=0.
 *
 * The least common multiple (lcm) of two integers a and b is the smallest
 * positive integer that is a multiple of both a and b. For example,
 * lcm(56, 96) = 672 because 672 is a multiple of both 56 and 96 (672=56⋅7=96⋅12)
 * but no smaller positive number is a multiple of both. By convention, if
 * either a or b is 0, then lcm(a,b)=0.
 *
 * Two integers are relatively prime if they share no positive common divisors
 * (other than 1). For example, 221 and 384 are not relatively prime because 17
 * is a common divisor.
 *
 * Euler’s totient function ϕ(n) is the number of integers between 1 and n that
 * are relatively prime with n. For example, ϕ(9)=6 because the six
 * numbers 1, 2, 4, 5, 7, and 8 are relatively prime with 9.
 * Note that if n≤0, then ϕ(n)=0.
 *
 * API:
 *
 * // Returns the greatest common divisor of a and b.
 * public static int gcd(int a, int b)
 *
 * // Returns the least common multiple of a and b.
 * public static int lcm(int a, int b)
 *
 * // Returns true if a and b are relatively prime; false otherwise.
 * public static boolean areRelativelyPrime(int a, int b)
 *
 * // Returns the number of integers between 1 and n that are
 * // relatively prime with n.
 * public static int totient(int n)
 *
 * // Takes two integer command-line arguments a and b and prints
 * // each function, evaluated in the format (and order) given below.
 * public static void main(String[] args)
 *
 **************************************************************************** */

public class Divisors {

    public static int gcd(int a, int b) {
        /* Implements an iterative version of Euclid’s algorithm. To compute
        the greatest common divisor of a and b:

        - Replace (a,b) with (|a|,|b|).
        - Repeatedly replace (a, b) with (b, a % b) until the second integer
          in the pair is zero.
        - Return the first integer in the pair as the gcd.
         */

        // By convention, gcd(0, 0) = 0
        if (a == 0 && b == 0) return 0;

        // Replace (a, b) with (|a|, |b|)
        int a1 = Math.abs(a);
        int b1 = Math.abs(b);

        // Check for reverse order
        if (a1 < b1) {
            int a1New = b1;
            int b1New = a1;
            a1 = a1New;
            b1 = b1New;
        }

        while (b1 != 0) {
            int a1New = b1;
            int b1New = a1 % b1;
            a1 = a1New;
            b1 = b1New;
        }
        return a1;
    }

    public static int lcm(int a, int b) {
        /* Uses the following formula, which relates the gcd and lcm functions:
        lcm(a, b) = |a| * |b| * gcd(a,b)
        To avoid integer overflow, performs the division before the
        multiplication.
         */

        // By convention, if either a or b is 0, then lcm(a, b) = 0
        if (a == 0 || b == 0) return 0;

        return Math.abs(a * (b / gcd(a, b)));
    }

    public static boolean areRelativelyPrime(int a, int b) {

        // Two integers are relatively prime if they share no positive
        // common divisors (other than 1).
        return gcd(a, b) == 1;
    }

    public static int totient(int n) {
        /* Euler’s totient function ϕ(n) is the number of integers
        between 1 and n (including 1) that are relatively prime with n.
         */

        // By convention if if n <= 0, then totient(n) = 0
        if (n <= 0) return 0;

        // totient(1) = 1
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (areRelativelyPrime(i, n)) result++;
        }
        return result;
    }

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " +
                                   areRelativelyPrime(a, b));
        System.out.println("totient(" + a + ") = " + totient(a));
        System.out.println("totient(" + b + ") = " + totient(b));
    }
}
