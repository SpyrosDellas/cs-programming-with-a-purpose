/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     04/03/2020
 *
 * Reve’s puzzle
 * Reve’s puzzle is identical to the towers of Hanoi problem, except that there
 * are 4 poles (instead of 3). The task is to move n discs of different sizes
 * from the starting pole to the destination pole, while obeying the following
 * rules:
 * - Move only one disc at a time
 * - Never place a larger disc on a smaller one
 *
 * The following remarkable algorithm, discovered by Frame and Stewart in 1941,
 * transfers n discs from the starting pole to the destination pole using the
 * fewest moves (although this fact was not proven until 2014):
 * - Let k denote the integer nearest to n + 1 - Math.sqrt(2 * n + 1)
 * - Transfer (recursively) the k smallest discs to a single pole other than
 *   the start or destination poles
 * - Transfer the remaining n−k disks to the destination pole (without using
 *   the pole that now contains the smallest k discs). To do so, use the
 *   algorithm for the 3-pole towers of Hanoi problem
 * - Transfer (recursively) the k smallest discs to the destination pole
 *
 * RevesPuzzle.java takes a positive integer command-line argument n and prints
 * a solution to Reve’s puzzle. The discs are labeled in increasing order of
 * size from 1 to n and the poles are labeled A, B, C, and D, with A
 * representing the starting pole and D representing the destination pole.
 *
 * Note:
 * For the towers of Hanoi problem, the minimum number of moves for a 64-disc
 * problem is 2^64 − 1. With the addition of a fourth pole, the minimum number
 * of moves for a 64-disc problem is reduced to 18,433
 *
 **************************************************************************** */

public class RevesPuzzle {

    private static void hanoiTowers(int n, int bottomDisk, String towers,
                                    int position, boolean moveRight) {
        /* Classic Towers of Hanoi problem recursive solution.
        There are three towers with the first tower being the starting point and
        the last tower being the end point.
         */

        // Base case of the recursion
        if (n == 0) return;

        // Recursive case
        if (!moveRight) {
            // Move top n-1 disks one pole to the right
            hanoiTowers(n - 1, bottomDisk - 1, towers, position, true);
            // Move bottom disk to the left
            int destination = position - 1;
            if (destination < 0) destination = 2;
            System.out.println("Move disc " + bottomDisk + " from " +
                                       towers.charAt(position) + " to " +
                                       towers.charAt(destination));
            // Move top n-1 disks one pole to the right
            int newPosition = position + 1;
            if (newPosition > 2) newPosition = 0;
            hanoiTowers(n - 1, bottomDisk - 1, towers, newPosition, true);
        }
        else {
            // Move top n-1 disks one pole to the left
            hanoiTowers(n - 1, bottomDisk - 1, towers, position, false);
            // Move bottom disk to the right
            int destination = position + 1;
            if (destination > 2) destination = 0;
            System.out.println("Move disc " + bottomDisk + " from " +
                                       towers.charAt(position) + " to " +
                                       towers.charAt(destination));
            // Move top n-1 disks one pole to the left
            int newPosition = position - 1;
            if (newPosition < 0) newPosition = 2;
            hanoiTowers(n - 1, bottomDisk - 1, towers, newPosition, false);
        }

    }

    private static void revesPuzzle(int n, int position, String move) {

        // String representation of the 4 poles
        String revesPoles = "ABCD";

        // Calculate the final destination pole, where 0 represents pole A,
        // 1 pole B, 2 pole C and 3 pole D
        int finalDestination = position;
        if (move.equals("L1")) finalDestination -= 1;
        else if (move.equals("L2")) finalDestination -= 2;
        else if (move.equals("R1")) finalDestination += 1;
        else if (move.equals("R2")) finalDestination += 2;
        if (finalDestination < 0) finalDestination += 4;
        if (finalDestination > 3) finalDestination -= 4;

        // Base cases of the recursion
        if (n == 0) return;
        else if (n == 1) {
            System.out.println("Move disc " + n + " from " +
                                       revesPoles.charAt(position) + " to " +
                                       revesPoles.charAt(finalDestination));
            return;
        }

        // RECURSIVE CASE
        // Calculate k for the recursion (see algorithm details above)
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        // Calculate next moves
        String nextMove1 = "";
        String nextMove2 = "";
        if (move.equals("L1")) {
            nextMove1 = "R1";
            nextMove2 = "R2";
        }
        else if (move.equals("L2")) {
            nextMove1 = "R1";
            nextMove2 = "R1";
        }
        else if (move.equals("R1")) {
            nextMove1 = "L1";
            nextMove2 = "L2";
        }
        else if (move.equals("R2")) {
            nextMove1 = "L1";
            nextMove2 = "L1";
        }

        // FIRST STEP
        // Recursively move top k discs to a free pole
        revesPuzzle(k, position, nextMove1);

        // SECOND STEP
        // Calculate the 3 poles for the Hanoi Towers algorithm
        // Starting pole
        String hanoiPoles = revesPoles.substring(position, position + 1);
        // Middle pole
        int midPole = position;
        if (move.equals("L1")) midPole += 2;
        else if (move.equals("L2")) midPole += 3;
        else if (move.equals("R1")) midPole -= 2;
        else if (move.equals("R2")) midPole -= 3;
        if (midPole < 0) midPole += 4;
        if (midPole > 3) midPole -= 4;
        hanoiPoles += revesPoles.substring(midPole, midPole + 1);
        // Destination pole
        hanoiPoles += revesPoles.substring(finalDestination, finalDestination + 1);

        // Transfer the remaining (n − k) discs to the destination pole using
        // the algorithm for the 3-pole towers of Hanoi problem
        hanoiTowers(n - k, n, hanoiPoles, 0, false);

        // THIRD STEP
        // Revover the intermediate destination pole from the first step
        int intermediateDestination = position;
        if (nextMove1.equals("L1")) intermediateDestination -= 1;
        else if (nextMove1.equals("R1")) intermediateDestination += 1;
        if (intermediateDestination < 0) intermediateDestination += 4;
        if (intermediateDestination > 3) intermediateDestination -= 4;
        // Recursively move top k discs from the intermediate pole to
        // the destination pole
        revesPuzzle(k, intermediateDestination, nextMove2);
    }


    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        // Solve Reve's puzzle using Frame and Stewart's algorithm. Start at
        // pole A (0) and move one pole left in cycle, i.e. move to pole D
        revesPuzzle(n, 0, "L1");
    }

}
