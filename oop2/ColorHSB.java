/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     24/03/2020
 *
 * ColorHSB.java represents a color in hue–saturation–brightness (HSB) format,
 * along with a sample client. The HSB color format is widely used in color
 * pickers.
 *
 * A color in HSB format is composed of three components:
 * - The hue is an integer between 0 and 359. It represents a pure color on the
 * color wheel, with 0° for red, 120° for green, and 240° for blue.
 * - The saturation is an integer between 0 and 100. It represents the purity of
 * the hue.
 * - The brightness is an integer between 0 and 100. It represents the
 * percentage of white that is mixed with the hue.
 *
 * Required behavior
 * Corner cases:
 * Throw an IllegalArgumentException in the constructor if any
 * component is outside its prescribed range (0 to 359 for the hue, 0 to 100
 * for the saturation and brightness); throw an IllegalArgumentException in
 * distanceSquaredTo() if its argument is null.
 * String representation:
 * Return a string composed of the integers for hue, saturation, and brightness
 * (in that order), separated by commas, and enclosed in parentheses. An
 * example is (26, 85, 96).
 * Grayscale:
 * A color in HSB format is a shade of gray if either its saturation or
 * brightness component is 0% (or both).
 * Distance:
 * The squared distance between two colors (h1,s1,b1) and (h2,s2,b2) is defined
 * to be min[(h1−h2)^2, (360−|h1−h2|)^2] + (s1−s2)^2 + (b1−b2)^2
 * For example, the squared distance between (350, 100, 45) and (0, 100, 50) is
 * 102+02+52=125.
 * Sample client:
 * The main() method should takes three integer command-line arguments h, s,
 * and b; read a list of pre-defined colors from standard input; and print to
 * standard output the pre-defined color that is closest to (h,s,b).
 *
 * Input specification:
 * The input from standard input consists of a sequence of one or more lines.
 * Each line contains a string (the name of a pre-defined color) and three
 * integers (its hue, saturation, and brightness components), separated by
 * whitespace. The data files web.txt and wiki.txt are in the specified format.
 *
 * Output specification:
 * The output to standard output consists of one line: the name of the nearest
 * pre-defined color and the string representation of that color, separated
 * by whitespace.
 *
 **************************************************************************** */

public class ColorHSB {
    private final int hue;
    private final int saturation;
    private final int brightness;

    /* Creates a color with hue h, saturation s, and brightness b.
     */
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) throw new IllegalArgumentException(
                "Hue must be in the range [0, 359]");
        if (s < 0 || s > 100) throw new IllegalArgumentException(
                "Saturation must be in the range [0, 100]");
        if (b < 0 || b > 100) throw new IllegalArgumentException(
                "Brightness must be in the range [0, 100]");
        hue = h;
        saturation = s;
        brightness = b;
    }

    /*
    Returns a string representation of this color, using the format (h, s, b).
     */
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    /* Is this color a shade of gray?
     */
    public boolean isGrayscale() {
        return (saturation == 0 || brightness == 0);
    }

    /* Returns the squared distance between the two colors.
     */
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException(
                "ColorHSB argument expected, not null");
        int hDiff1 = hue - that.hue;
        int hDiff2 = 360 - Math.abs(hDiff1);
        int sDiff = saturation - that.saturation;
        int bDiff = brightness - that.brightness;
        return Math.min(hDiff1 * hDiff1, hDiff2 * hDiff2) +
                sDiff * sDiff +
                bDiff * bDiff;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB inColor = new ColorHSB(h, s, b);

        if (StdIn.isEmpty()) return;

        String closestColorName = "";
        ColorHSB closestColor = new ColorHSB(0, 0, 0);
        int minDistance = Integer.MAX_VALUE;
        int distance;

        while (!StdIn.isEmpty() && minDistance > 0) {
            String colorName = StdIn.readString();
            ColorHSB color = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            distance = inColor.distanceSquaredTo(color);
            if (distance < minDistance) {
                minDistance = distance;
                closestColorName = colorName;
                closestColor = color;
            }
        }
        System.out.println(closestColorName + " " + closestColor);
    }
}
