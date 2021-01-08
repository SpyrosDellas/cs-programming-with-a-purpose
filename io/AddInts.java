/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     19/02/2020
 *
 *
 *
 *  This program takes a command-line argument n, reads in n integers,
 *  and prints out their sum.
 *
 *  % java AddInts n
 *
 ******************************************************************************/

public class AddInts {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int value = StdIn.readInt();
            sum = sum + value;
        }
        StdOut.println("Sum is " + sum);
    }
}
