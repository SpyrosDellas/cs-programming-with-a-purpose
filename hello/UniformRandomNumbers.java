/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import java.util.Arrays;

public class UniformRandomNumbers {
    public static void main(String[] args) {
        double[] nums = new double[5];

        nums[0] = Math.random();
        nums[1] = Math.random();
        nums[2] = Math.random();
        nums[3] = Math.random();
        nums[4] = Math.random();

        double max = StdStats.max(nums);
        double min = StdStats.min(nums);
        double average = StdStats.mean(nums);

        StdOut.println("The 5 random numbers are: " + Arrays.toString(nums));
        StdOut.println("Their mean is: " + average);
        StdOut.println("The max value is: " + max);
        StdOut.println("The min value is: " + min);
    }
}
