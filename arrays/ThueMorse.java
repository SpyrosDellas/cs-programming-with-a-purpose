/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     18/02/2020
 *
 * Thue–Morse weave.
 * Takes an integer command-line argument n and prints
 * an n-by-n pattern of the Thue-Morse sequence; includes two space characters
 * between each + and - character.
 * We assume that n is a positive integer (but it need not be a power of 2).
 *
 * The Thue–Morse sequence is an infinite sequence of 0s and 1s that is
 * constructed by starting with 0 and successively appending the bitwise
 * negation (interchange 0s and 1s) of the existing sequence.
 * Here are the first few steps of this construction:
 *   0
 *   01
 *   0110
 *   01101001
 *   0110100110010110
 *
 * To visualize the Thue–Morse sequence, we create an n-by-n pattern by
 * printing a + (plus sign) in row i and column j if bits i and j in the
 * sequence are equal, and a - (minus sign) if they are different.
 *
 * NOTE:
 * The Thue–Morse sequence has many fascinating properties and arises in
 * graphic design and in music composition.
 *
 *  */

public class ThueMorse {

    public static void main(String[] args) {

        int seqLength = Integer.parseInt(args[0]);
        boolean[] thueMorse = new boolean[seqLength];

        // First find the biggest power of 2 to satisfy 2^p <= seqLength
        // int p = (int) (Math.log(seqLength) / Math.log(2));

        // Create the first p elements of the sequence, with p a power of 2
        int p = 2;
        while (p <= seqLength) {
            for (int i = p / 2; i < seqLength; i++) {
                thueMorse[i] = !thueMorse[i - p / 2];
            }
            p = 2 * p;
        }

        // Create the remaining elements, restoring p first
        p = p / 2;
        for (int i = p; i < seqLength; i++) {
            thueMorse[i] = !thueMorse[i - p];
        }

        // Create the n-by-n pattern of the sequence
        String[][] thueMorseWeave = new String[seqLength][seqLength];
        for (int i = 0; i < seqLength; i++) {
            for (int j = 0; j < seqLength; j++) {
                if (thueMorse[i] == thueMorse[j]) {
                    thueMorseWeave[i][j] = "+";
                }
                else {
                    thueMorseWeave[i][j] = "-";
                }
            }
        }
        // Print the pattern
        for (int i = 0; i < seqLength; i++) {
            for (int j = 0; j < seqLength; j++) {
                System.out.print(thueMorseWeave[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
