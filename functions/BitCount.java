/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     05/03/2020
 *
 **************************************************************************** */

public class BitCount {

    public static int bitCount(int input) {
        /* This  function (that often appears in job interviews for programmers)
        correctly counts the number of 1 bits in the binary representation
        of its input.
         */
        int count = 0;
        while (input != 0) {
            count++;
            // Turn off the first least significant bit that is 1
            input = input & (input - 1);
            System.out.println(input);
        }
        return count;
    }

    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        System.out.println(bitCount(input));
    }
}
