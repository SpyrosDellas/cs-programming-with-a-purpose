/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     24/02/2020
 *
 *
 * Gray code (or Cyclic Permutation Code)
 * An n-bit Gray code is a list of the 2^n different n-bit binary numbers
 * such that each entry in the list differs in precisely one bit from its
 * predecessor. Gray code was originally designed to prevent spurious output
 * from electromechanical switches. Today, Gray codes are widely used to
 * facilitate error correction in digital communications such as digital
 * terrestrial television and some cable TV systems.
 *
 * Gray code is an 1-to-1 match with the sum of possible combinations of n
 * elements: (n n) + (n n-1) + .... (n 1) = 2^n - 1
 * If we add the zero permutation, represented by 0..0 in the code, then there
 * is a full 1-to-1 match, i.e. each permutation appears only once.
 * Furthermore, each permutation differs with the next one by
 * a single element.
 *
 * The n bit binary reflected Gray code can be defined recursively as follows:
 *  - The n−1 bit code, with 0 prepended to each word,followed by the n−1 bit
 *    code in reverse order, with 1 prepended to each word.
 *  - The 0-bit code is defined to be null, so the 1-bit code is 0 followed by 1
 *
 *  For example, for n = [0, 3] the Gray codes are:
 *
 *   n = 0: null
 *
 *   n = 1: 0
 *          1
 *
 *   n = 2: 00
 *          01
 *          11
 *          10
 *
 *   n = 3: 000
 *          001
 *          011
 *          010
 *          110
 *          111
 *          101
 *          100
 *
 *****************************************************************************/

import java.util.ArrayList;


public class GrayCode {

    // Gray code
    private static ArrayList<String> code = new ArrayList<String>();

    // Moves representation of the code
    private static ArrayList<String> codeMoves = new ArrayList<String>();


    private static void grayCode(int n) {

        // Base cases of the recursion
        if (n == 0) return;
        if (n == 1) {
            code.add("0");
            code.add("1");
            return;
        }

        grayCode(n - 1);
        int codeSize = code.size();
        for (int i = codeSize - 1; i >= 0; i--) {
            code.add("1" + code.get(i));
        }
        for (int i = 0; i < codeSize; i++) {
            code.set(i, "0" + code.get(i));
        }

    }


    private static void codeMoves(int n, boolean shiftLeft) {

        // Base case of the recursion
        if (n == 0) return;

        // Reduction step of the recursion
        codeMoves(n - 1, true);
        if (shiftLeft) {
            codeMoves.add("enter " + n);
        }
        else {
            codeMoves.add("exit " + n);
        }
        codeMoves(n - 1, false);
    }


    public static void main(String[] args) {

        // Number of bits in the Gray code
        int n = Integer.parseInt(args[0]);

        grayCode(n);
        codeMoves(n, true);

        // Print the Gray code
        System.out.println("Gray code for n = " + n + ":");
        if (code == null) System.out.println("null");
        else {
            for (String line : code) {
                System.out.println(line);
            }
        }

        // Print the Gray code moves
        System.out.println("\nGray code moves for n = " + n + ":");
        if (codeMoves == null) System.out.println("null");
        else {
            for (String codeMove : codeMoves) {
                System.out.println(codeMove);
            }
        }

    }

}
