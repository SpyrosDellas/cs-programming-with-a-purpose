/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     28/02/2020
 *
 * The Hamming distance between two bit strings of length n is equal to the
 * number of bits in which the two strings differ.
 *
 * This program reads in a bit string s and an integer k from the command line,
 * and prints all bit strings that have Hamming distance at most k from s.
 *
 * For example, if k is 2 and s is 0000, then the output is:
 *   0011 0101 0110 1001 1010 1100
 *
 **************************************************************************** */

public class HammingDistance {


    private static void hammingDistance(String s, int k, int start) {
        /* To print out all the strings at Hamming distance k from s, we need to
        invert all combinations of k digits from the string s.
         */

        // Base case of the recursion
        if (k == 0) System.out.println(s);

        // Recursive case
        // If start >= s.length then the recursion terminates as we have
        // exhausted the string without reaching the target distance
        String reducedS;
        for (int i = start; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("0")) {
                reducedS = s.substring(0, i) + "1";
                if (i + 1 <= s.length()) reducedS += s.substring(i + 1, s.length());
            }
            else {
                reducedS = s.substring(0, i) + "0";
                if (i + 1 <= s.length()) reducedS += s.substring(i + 1, s.length());
            }
            hammingDistance(reducedS, k - 1, i + 1);
        }

    }


    public static void main(String[] args) {
        int k = Integer.parseInt(args[1]);
        String s = args[0];
        System.out.println("The strings that have Hamming distance " + k +
                                   " from '" + s + "' are: ");
        hammingDistance(s, k, 0);
    }
}
