/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     18/02/2020
 *
 *  Computes the number of primes less than or equal to n using
 *  the Sieve of Eratosthenes.
 *
 *                  n     Primes <= n
 *  ---------------------------------
 *                 10               4
 *                100              25
 *              1,000             168
 *             10,000           1,229
 *            100,000           9,592
 *          1,000,000          78,498
 *         10,000,000         664,579
 *        100,000,000       5,761,455
 *      1,000,000,000      50,847,534
 *
 ******************************************************************************/


public class PrimeSieve {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // initially assume all integers are prime
        // 0 and 1 are not primes. The first prime is 2
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        long startTime = System.nanoTime();
        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor * factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Execution time of calculation loop: " +
                                   (endTime - startTime) / 1000000000.0 +
                                   " secs");

        // count primes
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes++;
        }
        System.out.println("The number of primes <= " + n + " is " + primes);
    }
}
