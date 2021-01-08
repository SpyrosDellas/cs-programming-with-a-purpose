/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     16/02/2020
 ****************************************************************************
 *
 * Converts from CMYK format to RGB format using these mathematical formulas:
 *
 * white = 1 − black
 * red   = 255 × white × (1 − cyan)
 * green = 255 × white × (1 − magenta)
 * blues = 255 × white × (1 − yellow)
 *
 * Takes four double command-line arguments cyan, magenta, yellow, and black;
 * Computes the corresponding RGB values, each rounded to the nearest integer;
 * and prints the RGB values
 *
 * */

public class CMYKtoRGB {
    public static void main(String[] args) {

        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        double white = 1 - black;
        long red = Math.round(255 * white * (1 - cyan));
        long green = Math.round(255 * white * (1 - magenta));
        long blue = Math.round(255 * white * (1 - yellow));

        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);

    }
}
