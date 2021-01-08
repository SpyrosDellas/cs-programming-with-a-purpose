/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     21/02/2020
 *
 * WorldMap
 * Reads boundary information of a country (or other geographic entity) from
 * standard input and plots the results to standard drawing.
 * A country consists of a set of regions (e.g., states, provinces, or other
 * administrative divisions), each of which is described by a polygon.
 *
 * Input format:
 * - The first line contains two integers: width and height.
 * - The remaining part of the input is divided into regions.
 *   - The first entry in each region is the name of the region. For simplicity,
 *     names will not contain spaces.
 *   - The next entry is an integer specifying the number of vertices in the
 *     polygon describing the region.
 *   - Finally, the region contains the x- and y-coordinates of the vertices
 *     of the polygon.
 *
 * For simplicity, if a region requires more than one polygon to describe its
 * boundary, we treat it as multiple regions, with one polygon per region.
 *
 * Output format:
 * Draws the polygons to standard drawing, using the following guidelines:
 * - Call StdDraw.setCanvasSize() to set the size of the canvas to be
 *   width-by-height pixels.
 * - Call StdDraw.setXscale() and StdDraw.setYscale() so that x-coordinates
 *   of the canvas range from 0 to width and the y-coordinates range
 *   from 0 to height.
 * - Call StdDraw.polygon() to draw each polygon.
 *
 **************************************************************************** */

public class WorldMap {

    public static void main(String[] args) {

        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        // Enable double buffering
        StdDraw.enableDoubleBuffering();

        // Parse and plot the regions
        while (StdIn.hasNextLine()) {
            String regionName = StdIn.readLine();
            if (regionName.isEmpty()) continue;   // Blank line
            int numVertices = StdIn.readInt();
            double[] xCoordinates = new double[numVertices];
            double[] yCoordinates = new double[numVertices];
            for (int i = 0; i < numVertices; i++) {
                xCoordinates[i] = StdIn.readDouble();
                yCoordinates[i] = StdIn.readDouble();
            }
            StdDraw.polygon(xCoordinates, yCoordinates);
        }

        // Show
        StdDraw.show();
    }
}
