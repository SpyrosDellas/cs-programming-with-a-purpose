/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/02/2020
 ****************************************************************************
 *
 * Takes two integer command-line arguments n and r and uses a for loop to
 * compute the nth generalized harmonic number of order r, which is defined by
 * the following formula:
 *
 * H(n, r) = 1/1^r + 1/2^r + ... + 1/n^r
 *
 * */

public class GeneralizedHarmonic {
    public static void main(String[] args) {

        double n = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        double harmonic = 0;

        for (double i = 1; i <= n; i++) {
            harmonic += (1.0 / Math.pow(i, r));
        }

        System.out.println(harmonic);
    }
}
