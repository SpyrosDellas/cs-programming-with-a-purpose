/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     24/03/2020
 *
 * Bar data type.
 * A bar aggregates related information (name, value, and category) for use in
 * a bar chart. For example, the first bar drawn in the bar chart represents
 * name = Beijing, value = 672, and category = East Asia. In addition to methods
 * for accessing the individual fields, the bar data type implements Java's
 * 'Comparable' interface to allow sorting of bars in order of value.
 *
 * Corner cases:
 * - Throws an IllegalArgumentException in the constructor if name is null,
 * value is negative, or category is null.
 * - Throws a NullPointerException if the argument to compareTo() is null.
 *
 **************************************************************************** */

import java.util.Arrays;

public class Bar implements Comparable<Bar> {

    private final String name;
    private final int value;
    private final String category;

    /* Creates a new bar
     */
    public Bar(String name, int value, String category) {
        if (name == null) throw new IllegalArgumentException(
                "Bar name cannot be null.");
        if (value < 0) throw new IllegalArgumentException(
                "Value cannot be negative.");
        if (category == null) throw new IllegalArgumentException(
                "Bar category cannot be null.");
        this.name = name;
        this.value = value;
        this.category = category;
    }

    /* Returns the name of this bar
     */
    public String getName() {
        return name;
    }

    /* Returns the value of this bar
     */
    public int getValue() {
        return value;
    }

    /* Returns the category of this bar
     */
    public String getCategory() {
        return category;
    }

    /* Compare two bars by value.
    Returns a { negative integer, zero, positive integer } if value of the
    invoking object is { less than, equal to, greater than } the value of the
    argument object.
     */
    public int compareTo(Bar that) {
        if (that == null) throw new NullPointerException(
                "Cannot compare with null.");
        return value - that.value;
    }

    /* Sample client
     */
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];
        bars[0] = new Bar("Beijing", 22674, "East Asia");
        bars[1] = new Bar("Cairo", 19850, "Middle East");
        bars[2] = new Bar("Delhi", 27890, "South Asia");
        bars[3] = new Bar("Dhaka", 19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai", 22120, "South Asia");
        bars[6] = new Bar("Osaka", 20409, "East Asia");
        bars[7] = new Bar("São Paulo", 21698, "Latin America");
        bars[8] = new Bar("Shanghai", 25779, "East Asia");
        bars[9] = new Bar("Tokyo", 38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);
        for (Bar b : bars) {
            System.out.printf("%15s %8s %15s\n",
                              b.getName(), b.getValue(), b.getCategory());
        }
    }

}
