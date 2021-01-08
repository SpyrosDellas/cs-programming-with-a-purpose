/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     16/02/2020
 ****************************************************************************
 *
 * Takes three integer command-line arguments and determines whether they
 * constitute the side lengths of some right triangle
 *
 * The following two conditions are necessary and sufficient:
 *  1. Each integer must be positive.
 *  2. The sum of the squares of two of the integers must equal the square
 *     of the third integer.
 * */

public class RightTriangle {
    public static void main(String[] args) {

        boolean isRightTriangle;
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);
        long c = Long.parseLong(args[2]);

        isRightTriangle = (a * a) + (b * b) == (c * c) ||
                (a * a) + (c * c) == (b * b) ||
                (c * c) + (b * b) == (a * a);

        isRightTriangle = isRightTriangle && (a > 0) && (b > 0) && (c > 0);

        System.out.println(isRightTriangle);

    }
}
