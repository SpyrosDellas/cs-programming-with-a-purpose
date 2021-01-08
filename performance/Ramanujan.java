/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     07/03/2020
 *
 * Ramanujan numbers:
 * When the English mathematician G. H. Hardy came to visit the Indian
 * mathematician Srinivasa Ramanujan in the hospital one day, Hardy remarked
 * that the number of his taxi was 1729, a rather dull number. To which
 * Ramanujan replied, No, Hardy! No, Hardy! It is a very interesting number;
 * it is the smallest number expressible as the sum of two cubes in two
 * different ways.
 * An integer n is a Ramanujan number if can be expressed as the sum of two
 * positive cubes in two different ways. That is, there are four distinct
 * positive integers a, b, c, and d such that n = a^3 + b^3 = c^3 + d^3.
 * For example 1729 = 1^3 + 12^3 = 9^3 + 10^3.
 *
 * Ramanujan.java takes a long integer command-line argument n and prints
 * true if it is a Ramanujan number, and false otherwise.
 *
 * Note:
 * The algorith takes time proportional to n^(1/3) in the worst case. It is
 * fast enough to process any 64-bit long integer in a fraction of a second.
 *
 **************************************************************************** */

public class Ramanujan {


    public static boolean isRamanujan(long n) {
        /* Is n a Ramanujan number?
         */

        int solutions = 0;
        long end = (long) Math.pow(n, 1 / 3.0);

        for (long a = end; a > 0; a--) {

            long endCubed = a * a * a;
            long difference = n - endCubed;
            long cube1 = (long) Math.pow(difference, 1 / 3.0);

            if (cube1 >= a) break;  // a is too small, no more unique solutions

            long cube2 = cube1 + 1;
            cube1 = cube1 * cube1 * cube1;
            cube2 = cube2 * cube2 * cube2;

            if (cube1 + endCubed == n || cube2 + endCubed == n) {
                solutions += 1;
                if (solutions == 2) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        /* Takes a long integer command-line arguments n and prints true if n
        is a Ramanujan number, and false otherwise.
         */

        long n = Long.parseLong(args[0]);
        System.out.print(isRamanujan(n));

    }

}
