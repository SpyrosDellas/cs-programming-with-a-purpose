/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     15/03/2020
 *
 * Maximum square submatrix:
 * Given an n-by-n matrix of 0s and 1s, find a contiguous square submatrix of
 * maximum size that contains only 1s
 *
 * - Size. The size of a square submatrix is its number of rows (or columns).
 * We assume that the argument to the size() method is a square matrix
 * containing only 0s and 1s.
 * - Contiguous. The square submatrix must be contiguous—the row indicies must
 * be consecutive and the column indices must be consecutive.
 * - Performance. The size() method should take time proportional to n^2 in the
 * worst case.
 * - Input format. Standard input will contain a positive integer n, followed
 * by n lines, with each line containing n 0s and 1s, separated by whitespace.
 *
 * Note:
 * The maximum square submatrix problem is related to problems that arise in
 * databases, image processing, and maximum likelihood estimation. It is also
 * a popular technical job interview question.
 *
 **************************************************************************** */

public class MaximumSquareSubmatrix {


    public static int size(int[][] a) {
        /* Returns the size of the largest continuous square submatrix
        of a[][] containing only 1s.
        The algorithm follows a dynamic programming approach to identify the
        largest submatrix for row 1, for rows 1..2, ..., for rows 1..n.
         */

        // Array sums: Keeps track of the consecutive ones for each column. Gets
        // updated for each row of matrix a
        int[] sums = new int[a.length];
        int size = 0;   // Size of the maximum square submatrix
        int index = 0;
        int count = 0;

        // For each row
        for (int i = 0; i < a.length; i++) {
            // For each column
            // If 1 is encountered, increase the count of ones by one
            // If 0 is encountered, the count becomes zero
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 0) sums[j] = 0;
                else sums[j]++;
            }
            // Check if a new square submatrix of size + 1 has been found.
            // Note: As we progress row by row the size of the submatrix can
            // only be increased by one. Therefore, there is no need to scan for
            // sizes less than or equal to the previously identified maximum
            // size and for sizes greater than the previous size plus one.
            // Thus we only need a single pass through the elements
            // of sums

            index = 0;
            count = 0;
            while (index < sums.length) {
                if (sums[index] >= size + 1) {
                    count++;
                    index++;
                    // Check if size + 1 consecutive columns have at least
                    // size + 1 consecutive ones. If true a submatrix of
                    // size + 1 has been found
                    if (count == size + 1) {
                        size++;
                        break;
                    }
                }
                else {
                    index++;
                    count = 0;
                }

            }
        }
        return size;
    }


    public static void main(String[] args) {
        /* Reads an n-by-n matrix of 0s and 1s from standard input
    and prints the size of the largest contiguous square submatrix
    containing only 1s.
         */

        int matrixSize = StdIn.readInt();
        int[][] a = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                a[i][j] = StdIn.readInt();
            }
        }

        System.out.println(size(a));
    }

}
