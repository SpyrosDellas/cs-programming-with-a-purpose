/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     18/02/2020
 *
 * Birthday problem.
 * Suppose that people enter a room one at a time. How people must enter
 * until two share a birthday? Counterintuitively, after 23 people enter the
 * room, there is approximately a 50–50 chance that two share a birthday.
 * This phenomenon is known as the birthday problem or birthday paradox.
 *
 * Birthday.java takes two integer command-line arguments 'n' and 'trials' and
 * performs the following experiment, trials times:
 * - Choose a birthday for the next person, uniformly at random between 0
 *   and n−1.
 * - Have that person enter the room.
 * - If that person shares a birthday with someone else in the room, stop;
 *   otherwise repeat.
 *
 * In each experiment, it counts the number of people that enter the room, and
 * prints a table that summarizes the results (the count i, the number of times
 * that exactly i people enter the room, and the fraction of times that i or
 * fewer people enter the room) for each possible value of i from 1 until
 * the fraction reaches (or exceeds) 50%.
 *
 * NOTE:
 * The birthday problem arises in many computer science applications,
 * including hashing, cryptographic attacks, and testing random number
 * generators.
 *
 *  */

public class Birthday {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        // Results must be of size n+1, because at the worst case we need
        // n+1 persons to ensure that 2 persons have the same birthday.
        // For example: for 5 different bithday dates (n=5) the first 5 persons
        // that enter the room can have 5 different birthdays. Therefore, we
        // need an extra 6th person to enter the room.


        // Length of results is n+1, i.e. has indices ranging from [0..n]
        // results[0] corresponds to 1 person in the room
        // results[1] corresponds to 2 persons in the room
        // ...
        // results[n] corresponds to n+1 persons in the room
        int[] results = new int[n + 1];

        // Execute the experiment 'trials' times
        for (int i = 1; i <= trials; i++) {

            // At the beginning of each trial reset the birthdays register to
            // false
            boolean[] birthdays = new boolean[n];
            // Also reset the counter
            int counter = 0;

            while (true) {
                // Choose a birthday for the next person
                int birthday = (int) (Math.random() * n);
                counter += 1;
                if (!birthdays[birthday]) {
                    birthdays[birthday] = true;  // First person to have this birthday
                }
                else {
                    break;  // Someone else in the room has this birthday
                }
            }
            // Save the result of the trial, by incrementing the 'results' index
            // corresponding to counter by 1
            results[counter - 1] += 1;
        }

        double probability = 0.0;
        for (int j = 0; j <= n; j++) {
            probability += (double) results[j] / trials;
            System.out.println((j + 1) + "\t\t" + results[j] +
                                       "\t\t" + probability);
            if (probability >= 0.5) break;
        }
    }
}
