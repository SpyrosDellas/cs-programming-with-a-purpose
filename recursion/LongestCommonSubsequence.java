/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     29/02/2020
 *
 * The longest common subsequence (LCS) problem is the problem of finding the
 * longest subsequence common to all sequences in a set of strings or sequences
 * in general (often just two strings / sequences).
 *
 * Note:
 * The subsequence needs to maintain the order of appearance of its elements
 * within the string/sequence itself
 *
 * It differs from the longest common substring problem: unlike substrings,
 * subsequences are not required to occupy consecutive positions within the
 * original sequences.
 *
 * The longest common subsequence problem is a classic computer science problem,
 * the basis of data comparison programs such as the diff utility, and has
 * applications in computational linguistics and bioinformatics. It is also
 * widely used by revision control systems such as Git for reconciling multiple
 * changes made to a revision-controlled collection of files.
 *
 * In this program we adopt a bottom-up dynamic programming approach to
 * find the solution:
 *
 * - If s and t begin with the same character, then the LCS of s and t contains
 *   that first character. Thus, our problem reduces to finding the LCS of the
 *   suffixes s[1..m) and t[1..n)
 * - If s and t begin with different characters, both characters cannot be part
 *   of a common subsequence, so can safely discard one or the other. In either
 *   case, the problem reduces to finding the LCS of two strings—either
 *   s[0..m) and t[1..n) or s[1..m) and t[0..n).
 *
 * The final challenge is to recover the longest common subsequence itself,
 * not just its length. The key idea is to retrace the steps of the dynamic
 * programming algorithm backward, rediscovering the path of choices.
 *
 **************************************************************************** */

import java.util.Arrays;

public class LongestCommonSubsequence {


    private static int lcsLength(String s, String t) {

        int[][] lcsLengths = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    lcsLengths[i + 1][j + 1] = lcsLengths[i][j] + 1;
                }
                else {
                    lcsLengths[i + 1][j + 1] = Math.max(lcsLengths[i][j + 1], lcsLengths[i + 1][j]);
                }
            }
        }
        // Print lcsLength for visualization purposes
        for (int[] line : lcsLengths) System.out.println(Arrays.toString(line));
        return lcsLengths[s.length()][t.length()];
    }


    private static String lcs(String s, String t) {

        int[][] lcsLengths = new int[s.length() + 1][t.length() + 1];
        StringBuilder lcs = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    lcsLengths[i + 1][j + 1] = lcsLengths[i][j] + 1;
                }
                else {
                    lcsLengths[i + 1][j + 1] = Math.max(lcsLengths[i][j + 1], lcsLengths[i + 1][j]);
                }
            }
        }

        int i = s.length();
        int j = t.length();
        while (i >= 1 && j >= 1) {
            while (lcsLengths[i][j - 1] == lcsLengths[i][j]) j--;
            while (lcsLengths[i][j] == lcsLengths[i - 1][j]) i--;
            lcs.insert(0, s.charAt(i - 1));
            i--;
            j--;
        }
        return lcs.toString();
    }

    public static void main(String[] args) {

        System.out.println("Longest common subsequence length: " + lcsLength(args[0], args[1]));
        System.out.println("Longest common subsequence: " + lcs(args[0], args[1]));
    }
}
