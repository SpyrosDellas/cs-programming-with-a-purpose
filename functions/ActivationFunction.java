/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     22/02/2020
 *
 * Computes various activation functions that arise in neural networks.
 *
 * API:
 *
 *   // Returns the Heaviside function of x.
 *   public static double heaviside(double x)
 *
 *   // Returns the sigmoid function of x.
 *   public static double sigmoid(double x)
 *
 *   // Returns the hyperbolic tangent of x.
 *   public static double tanh(double x)
 *
 *   // Returns the softsign function of x.
 *   public static double softsign(double x)
 *
 *   // Returns the square nonlinearity function of x.
 *   public static double sqnl(double x)
 *
 *   // Takes a double command-line argument x and prints each activation
 *   // function
 *   public static void main(String[] args)
 *
 * NOTE:
 * All activation functions should return NaN if the argument is NaN.
 *
 **************************************************************************** */

public class ActivationFunction {

    public static double heaviside(double x) {

        if (Double.isNaN(x)) return Double.NaN;

        if (x < 0) return 0.0;
        else if (x == 0) return 0.5;
        else return 1.0;
    }

    public static double sigmoid(double x) {

        if (Double.isNaN(x)) return Double.NaN;

        return (1 / (1 + Math.pow(Math.E, -x)));
    }

    public static double tanh(double x) {

        if (Double.isNaN(x)) return Double.NaN;

        // The formula is refactored to handle either large negative or large
        // positive values of x
        if (x > 0) {
            return (1 - Math.pow(Math.E, -2 * x)) /
                    (1 + Math.pow(Math.E, -2 * x));
        }
        else {
            return (Math.pow(Math.E, 2 * x) - 1) /
                    (Math.pow(Math.E, 2 * x) + 1);
        }
    }

    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        else if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }
        else if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        }
        return x / (1 + Math.abs(x));
    }

    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        if (x <= -2) return -1.0;
        else if (x < 0) return (x + x * x / 4);
        else if (x < 2) return (x - x * x / 4);
        else return 1.0;
    }

    public static void main(String[] args) {

        double x = Double.parseDouble(args[0]);

        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("tanh(" + x + ") = " + tanh(x));
        System.out.println("softsign(" + x + ") = " + softsign(x));
        System.out.println("sqnl(" + x + ") = " + sqnl(x));
    }
}
