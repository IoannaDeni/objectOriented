import java.awt.*;
import objectdraw.*;

/**
 * Draws a pretty firework on the display.
 * 
 * @author Barbara Lerner
 */
public class Firework extends ActiveObject
{
    // The radius we want the fully-grown firework to have
    private int fireworkRadius;
    
    // Time to pause between growth spurts.  Measured in milliseconds.
    private static final int DELAY = 33;
    
    // The color the firework should have.
    private Color fireworkColor;
    
    // Where the center of the firework should be.
    private Location center;
    
    // The part of the screen to draw on
    private DrawingCanvas fireworkCanvas;
    
    /**
     * Creates and displays a firework
     * @param point the center of the firework
     * @param color the color the firework should be
     * @param radius the size of the firework
     * @param canvas the canvas to draw on
     */
    public Firework(Location point, Color color, int radius, DrawingCanvas canvas)
    {
        fireworkRadius = radius;
        fireworkColor = color;
        fireworkCanvas = canvas;
        center = point;
        start();
    }
    
    /**
     * Draw a firework that grows over time.
     */
    public void run() {
        // Length of the line for the current drawing.
        int lineLength = 1;
        
        // Repeatedly draw the firework at increasing lengths until we reach the 
        // desired size.  Pause within drawings for the user to see it.
        while (lineLength <= fireworkRadius) {
            draw (lineLength);
            pause (DELAY);
            lineLength = lineLength + 2;
        }
    }
    
    /**
     * Draw the firework at a fixed size.
     * @param rayLength the radius for this drawing.
     */
    private void draw(int rayLength) {
        // angle is the angle of the line from the center.  The first line
        // is horizontal
        double angle = 0;

        // Repeat until we have swept through a circle
        while (angle < 2 * Math.PI) {
            // Draw a line starting at the center.  Calculate where the other endpoint
            // should be based on the angle and length of line desired.
            new Line (center.getX(), center.getY(),
                      center.getX() + rayLength * Math.cos (angle),
                      center.getY() + rayLength * Math.sin (angle),
                      fireworkCanvas).setColor (fireworkColor);
                      
            // Increase the angle so the next line will be angled differently
            // and also so the loop will eventually exit.
            angle = angle + Math.PI / 8;
        }
    }
}



