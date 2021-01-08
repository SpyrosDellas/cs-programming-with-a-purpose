/* *****************************************************************************
 *  Name:              Spyridon theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/02/2020
 **************************************************************************** */

/* Ramanujan’s taxi.
 *
 * Srinivasa Ramanujan was an Indian mathematician who became famous for his intuition for
 * numbers. When the English mathematician G. H. Hardy came to visit him one day, Hardy
 * remarked that the number of his taxi was 1729, a rather dull number. To which Ramanujan
 * replied, “No, Hardy! No, Hardy! It is a very interesting number. It is the smallest
 * number expressible as the sum of two cubes in two different ways.”
 *
 * This program verifies this claim. It takes an integer command-line argument n and prints
 * all integers less than or equal to n that can be expressed as the sum of two cubes in two
 * different ways.
 *
 * In other words, it finds distinct positive integers a, b, c, and d such
 * that a^3 + b^3 = c^3 + d^3. Uses four nested for loops.
 */


public class Ramanujan {

    public static void main(String[] args) {

        long n = Long.parseLong(args[0]);
        int counter = 0;

        for (int i = 9; i <= n; i++) {

            nexti:
            for (int a = 1; a * a * a < i; a++) {
                for (int b = a + 1; b * b * b < i; b++) {

                    if (a * a * a + b * b * b == i) {

                        for (int c = a + 1; c * c * c < i; c++) {
                            for (int d = a + 2; d * d * d < i; d++) {

                                if (c * c * c + d * d * d == i) {
                                    counter += 1;
                                    System.out.println(
                                            "Solution " + counter + ": " + i + " = " + a + "^3 + "
                                                    + b
                                                    + "^3 = " + c + "^3 + " + d + "^3");
                                    break nexti;
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}
