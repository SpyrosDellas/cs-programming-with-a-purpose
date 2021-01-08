/* *****************************************************************************
 *  Name:              Spyridon Theodoros Dellas
 *  Coursera User ID:  spyrosdellas@yahoo.com
 *  Last modified:     20/02/2020
 *
 *
 *  Draw a blue filled circle wherever the mouse is, in cyan if the
 *  mouse is pressed.
 *
 ******************************************************************************/


public class MouseFollower {

    public static void main(String[] args) {

        StdDraw.enableDoubleBuffering();

        while (true) {

            // mouse click
            if (StdDraw.isMousePressed()) StdDraw.setPenColor(StdDraw.CYAN);
            else StdDraw.setPenColor(StdDraw.BLUE);

            // mouse location
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            StdDraw.filledCircle(x, y, 0.05);
            StdDraw.show();
            // pause for 20 ms
            StdDraw.pause(10);

            // Clear the screen
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledCircle(x, y, 0.051);
        }
    }
}
