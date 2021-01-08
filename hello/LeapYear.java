/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class LeapYear {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);

        boolean is_leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);

        if (is_leap) {
            System.out.println("Year " + year + " is a leap year.");
        }
        else {
            System.out.println("Year " + year + " is not a leap year.");
        }

    }
}
