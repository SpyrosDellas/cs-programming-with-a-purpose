/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     16/02/2020
 **************************************************************************** */

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {

        double[] testArray = {
                Double.parseDouble(args[0]),
                Double.parseDouble(args[1]),
                Double.parseDouble(args[2])
        };

        System.out.println(Arrays.toString(testArray));

        double[] b = Arrays.copyOf(testArray, testArray.length);

        System.out.println(Arrays.toString(b));

        b[0] = 100;
        b[1] = Math.E;
        b[2] = Math.PI;

        for (int i = 0; i < b.length; i++)
            System.out.println(b[i]);
    }
}
