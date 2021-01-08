/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     24/03/2020
 *
 * BarChartRacer.java
 * Produces animated bar charts, using BarChart.java to draw static bar charts.
 *
 * Canonical example:
 * An animated bar chart of the 10 most populous cities in the world, from 1500
 * to 2018. To produce the visualization, the program will successively draw
 * 519 individual bar charts (one per year of data), with a short pause between
 * each drawing. Each bar chart contains the 10 most populous cities in that
 * year, arranged in descending order of population.
 *
 * Input file format specification:
 * A bar-chart-racer data file is organized as a sequence of lines. The first
 * three lines comprise the header:
 * - The title
 * - The x-axis label
 * - The source of the data
 * Following the header is a blank line, followed by the raw data. Each line
 * (or record) consists of 5 fields, separated by commas:
 * - The year or date (e.g, 2018)
 * - The name (e.g., Mumbai)
 * - The associated country (e.g., India)
 * - The value (e.g, 22120)
 * - The category (e.g., South Asia)
 * The value field is an integer; the other fields can be arbitrary strings
 * (except that they can’t contain commas or newlines).
 * Records corresponding to the same year (or time period) are grouped together.
 * A group of records consists of an integer n, followed by n records. Within
 * a group, the records are sorted by name. A blank line separates each group.
 *
 * Command-line arguments:
 * The program takes two command-line arguments: the name of a bar-chart-racer
 * file and an integer k that specifies how many bars to display in each bar
 * chart.
 *
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {


    public static void main(String[] args) {

        In data = new In(args[0]);

        // k specifies how many bars to display in each bar chart
        int k = Integer.parseInt(args[1]);

        // A musical accompaniment to the animation
        // StdAudio.loop("soundtrackE.wav");

        // Initialise the bar chart
        String title;
        String xAxisLabel;
        String source;
        if (data.hasNextLine()) {
            title = data.readLine();
        }
        else return;
        if (data.hasNextLine()) {
            xAxisLabel = data.readLine();
        }
        else return;
        if (data.hasNextLine()) {
            source = data.readLine();
        }
        else return;

        BarChart chart = new BarChart(title, xAxisLabel, source);

        // Initialise StdDraw canvas size and enable double buffering
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        // Main loop: Creates and displays a new bar chart in each iteration
        while (data.hasNextLine()) {

            // Consume the blank lines separating the header and the groups
            String nextLine = data.readLine();
            if (nextLine.length() == 0) continue;

            chart.reset();

            // Parse the number of entries in the next group
            int n = Integer.parseInt(nextLine);
            Bar[] entries = new Bar[n];

            // Read first entry in the group and extract the caption and the Bar
            String[] line = data.readLine().split(",");
            chart.setCaption(line[0]);
            String name = line[1];
            int value = Integer.parseInt(line[3]);
            String category = line[4];
            entries[0] = new Bar(name, value, category);

            // Read the remaining entries in the group and extract the Bars
            for (int i = 1; i < n; i++) {
                line = data.readLine().split(",");
                name = line[1];
                value = Integer.parseInt(line[3]);
                category = line[4];
                entries[i] = new Bar(name, value, category);
            }

            // Sort the entries in ascending order
            Arrays.sort(entries);

            // Number of bars to display
            int numberOfBars = Math.min(n, k);

            // Add the bars to the bar chart
            for (int i = entries.length - 1; i > entries.length - 1 - numberOfBars; i--) {
                chart.add(entries[i].getName(), entries[i].getValue(), entries[i].getCategory());
            }

            // Plot the bar chart
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(10);

        }
        data.close();

    }
}
