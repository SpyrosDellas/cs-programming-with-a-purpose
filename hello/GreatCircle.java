/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     16/02/2020
 ****************************************************************************
 *
 * Takes four double command-line arguments x1, y1, x2, and y2 — the latitude
 * and longitude (in degrees) of two points on the surface of the earth — and
 * prints the great-circle distance (in kilometers) between them.
 *
 * Uses the following Haversine formula (https://en.wikipedia.org/wiki/Haversine_formula):
 *
 * distance = 2 * r * arcsin[sqrt[sin^2((x2 − x1) / 2) +
 *            cos(x1) * cos(x2) * sin^2((y2 − y1) / 2)]],
 *
 * where r = 6,371.0 is the mean radius of the Earth in kilometers
 *
 * */

public class GreatCircle {
    public static void main(String[] args) {

        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double r = 6371.0;

        double distance = 2 * r * Math.asin(Math.sqrt(
                Math.pow(Math.sin((x2 - x1) / 2), 2) + Math.cos(x1) *
                        Math.cos(x2) * Math.pow(Math.sin((y2 - y1) / 2), 2)
        ));

        System.out.println(distance + " kilometers");
    }
}
