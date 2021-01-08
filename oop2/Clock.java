/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     24/03/2020
 *
 * Clock.java represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59).
 *
 * Required behavior:
 * Two-argument constructor:
 * Throw an IllegalArgumentException if either integer argument is outside its
 * prescribed bounds (hours between 0 and 23, minutes between 0 and 59).
 * One-argument constructor:
 * The string argument is composed of two digits, followed by a colon, followed
 * by two digits, such as 09:45. Throw an IllegalArgumentException if either
 * the string argument is not in this format or if it does not correspond to a
 * valid time between 00:00 and 23:59.
 * String representation:
 * The format is the hours (2 digits), followed by a colon, followed by the
 * minutes (2 digits). Two examples are 00:00 and 23:59.
 * Ordering:
 * Times are ordered from 00:00 (earliest) to 23:59 (latest).
 * Tic:
 * Add one minute to the current time. For example, one minute after 06:00 is
 * 06:01; one minute after 23:59 is 00:00.
 * Toc:
 * Add delta minutes to the current time. For example, 60 minutes after 12:34
 * is 13:34. Throw an IllegalArgumentException if delta is negative.
 * Test client:
 * The main() method must call each instance method directly and help verify
 * that they work as prescribed.
 * Performance:
 * All instance methods must take constant time.
 *
 **************************************************************************** */

public class Clock {

    private int hours;
    private int minutes;

    /* Creates a clock whose initial time is h hours and m minutes.
     */
    public Clock(int h, int m) {
        if (h < 0 || h > 23) throw new IllegalArgumentException(
                "Hours must be between 0 and 23");
        if (m < 0 || m > 59) throw new IllegalArgumentException(
                "Minutes must be between 0 and 59");
        hours = h;
        minutes = m;
    }

    /* Creates a clock whose initial time is specified as a string, using the
    format HH:MM.
     */
    public Clock(String s) {
        if (s.length() != 5) throw new IllegalArgumentException(
                "The input string format is the hours (2 digits), followed by "
                        + "a colon, followed by the minutes (2 digits)");
        if (s.charAt(2) != ':' ||
                !Character.isDigit(s.charAt(0)) ||
                !Character.isDigit(s.charAt(1)) ||
                !Character.isDigit(s.charAt(3)) ||
                !Character.isDigit(s.charAt(4))) throw new IllegalArgumentException(
                "The input string format is the hours (2 digits), followed by "
                        + "a colon, followed by the minutes (2 digits)");
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(3, 5));
        if (h < 0 || h > 23 || m < 0 || m > 59) throw new IllegalArgumentException(
                "Input string does not correspond to a valid time between "
                        + "00:00 and 23:59");
        hours = h;
        minutes = m;
    }

    /* Returns a string representation of this clock, using the format HH:MM.
     */
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    /* Is the time on this clock earlier than the time on that one?
     */
    public boolean isEarlierThan(Clock that) {
        if (hours < that.hours) return true;
        else if (hours == that.hours && minutes < that.minutes) return true;
        return false;
    }

    /* Adds 1 minute to the time on this clock.
     */
    public void tic() {
        int newMinutes = minutes + 1;
        minutes = newMinutes % 60;
        hours = (hours + newMinutes / 60) % 24;
    }

    /* Adds delta minutes to the time on this clock.
     */
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException(
                "Parameter delta cannot be negative");
        int newMinutes = minutes + delta;
        minutes = newMinutes % 60;
        hours = (hours + newMinutes / 60) % 24;
    }

    public static void main(String[] args) {
        Clock testClock = new Clock(0, 0);
        System.out.println(testClock);
        testClock.tic();
        System.out.println(testClock);
        testClock.tic();
        System.out.println(testClock);
        testClock.toc(58);
        System.out.println(testClock);
        testClock.toc(23 * 60 + 1);
        System.out.println(testClock);
        System.out.println(testClock.isEarlierThan(new Clock("00:02")));
    }

}
