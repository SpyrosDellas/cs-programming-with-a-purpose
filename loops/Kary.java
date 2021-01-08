/* *****************************************************************************
 *  Name:              Spyridon theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/02/2020
 ****************************************************************************
 * Takes two integer command line arguments i and k and converts i to base k.
 * Assumes that i is an integer in Java’s long data type and that k is
 * an integer between 2 and 16.
 *
 * For bases greater than 10, uses the letters A through F to represent
 * the 11th through 16th digits, respectively.*/

public class Kary {
    public static void main(String[] args) {

        long i = Long.parseLong(args[0]);
        int k = Integer.parseInt(args[1]);

        // Check that base is in [2, 16]
        if (k < 2 || k > 16)
            throw new RuntimeException("Base must be in [2, 16]");

        String result = "";

        // Handle negatives
        if (i < 0) {
            i = -i;
        }

        // Handle inputs less than base
        if (i < k) {
            result = digit(i) + result;
        }
        else {
            while (true) {
                result = digit(i % k) + result;
                i = i / k;
                if (i < k) {
                    result = digit(i) + result;
                    break;
                }
            }
        }

        // Add the minus symbol for negative inputs
        i = Long.parseLong(args[0]);  // First reinstate i
        if (i < 0) {
            result = "-" + result;
        }

        // Print the result
        System.out.println("Integer " + i + " converted to base " + k + " is: " + result);
    }


    public static String digit(long remainder) {
        /* Converts remainders greater than or equal to 10 to their
        corresponding letter.
         */

        String result;

        switch ((int) remainder) {
            case 10:
                result = "A";
                break;
            case 11:
                result = "B";
                break;
            case 12:
                result = "C";
                break;
            case 13:
                result = "D";
                break;
            case 14:
                result = "E";
                break;
            case 15:
                result = "F";
                break;
            default:
                result = Long.toString(remainder);
        }

        return result;
    }
}
