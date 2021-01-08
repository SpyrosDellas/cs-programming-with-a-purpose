/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     17/02/2020
 ****************************************************************************
 *
 * Takes two integer command-line arguments n and width and prints an n-by-n
 * pattern, with a zero (0) for each element whose distance from the main
 * diagonal is strictly more than width, and an asterisk (*) for each entry
 * that is not, and two spaces between each 0 or *.
 *
 * It assumes that n and width are non-negative integers
 *
 * */

public class BandMatrix {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                if (Math.abs(i - j) <= width) {
                    row.append("*  ");
                }
                else {
                    row.append("0  ");
                }
            }

            // Trims the last two spaces and prints the result
            System.out.println(row.substring(0, row.length() - 2));
        }

    }
}
