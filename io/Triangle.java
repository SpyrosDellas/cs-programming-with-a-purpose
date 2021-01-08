/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     19/02/2020
 *
 *
 *  Compilation:  javac Triangle.java
 *  Execution:    java Triangle
 *  Dependencies: StdDraw.java
 *
 *  Plot a triangle.
 *
 ******************************************************************************/

public class Triangle {

    public static void main(String[] args) {

        double t = Math.sqrt(3.0) / 2.0;

        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(1.0, 0.0, 0.5, t);
        StdDraw.line(0.5, t, 0.0, 0.0);
        StdDraw.point(0.5, t / 3.0);
    }
}
