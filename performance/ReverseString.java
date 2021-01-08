/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     15/03/2020
 *
 * Implements a linear time algorithm for reversing a string s
 *
 * Note 1:
 * Strings in Java are immutable objects
 *
 * Note 2:
 * A new string can be created as follows:
 *          String str = "abc";
 *
 * which is equivalent to:
 *
 *          char data[] = {'a', 'b', 'c'};
 *          String str = new String(data);
 *
 **************************************************************************** */

public class ReverseString {

    private static String reverse(String s) {

        char[] reversed = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            reversed[s.length() - 1 - i] = s.charAt(i);
        }
        String reversedString = new String(reversed);
        return reversedString;
    }

    public static void main(String[] args) {
        String s = args[0];
        System.out.println(reverse(s));
    }
}
