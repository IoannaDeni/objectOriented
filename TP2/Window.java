import java.awt.*;
import objectdraw.*;

/**
 * The Window class defines an individual window composed of a spedific sized rectangle with a given color 
 * when the lights are turned off and a different color if the lights are on. This class also defines methods that 
 * allow the user to turn on or off the lights of the windows including a method that switches the color of the window from the current to the alternative 
 * 
 * @author Ioanna Deni
 * @version 5/1/2017
 */
public class Window
{
    //This variables hold the actual window so we can change the color of them in another methods
    private FilledRect window;

    // Color for the window when the lights are on
    private static final Color WINDOW_ON = Color.YELLOW;

    // Color for the window when the lights are off
    private static final Color WINDOW_OFF = Color.BLACK;

    /**
     * Constructor for Window that creates a rectangle 
     * colored black at the beginning on  the canvas. 
     * 
     * @param double for left and top coordinates 
     * @param a canvas
     */
    public Window(double left, double top, int size, DrawingCanvas canvas)
    {
        //This objectDraw constractor will make a window like rectangle
        window = new FilledRect (left, top, size, size, canvas);

        //Set the color to the color used for lights turn off
        window.setColor(WINDOW_OFF);

    }

    /**
     * This method returns the color of a single window
     */
    public void swictColor(Location point)
    {
        //The rectangle which is named window returns true if the user clicked on it
        
        if (window.contains (point)) {
            
            //If it is true and the color is yellow
            if (window.getColor() == Color.YELLOW)
            {
                //then it is turned to black by calling that method defined in the window class
                 window.setColor(WINDOW_OFF);
            }
            //If the window is black
            else if (window.getColor() == Color.BLACK)
            {
                //then it is turned to yellow by calling that method defined in the window class
                window.setColor(WINDOW_ON);
            }
        }
    }

    /**
     * This method should return the window in color yellow to displayed that the lights are on 
     */
    public void turnON () {

        //Set the color to the color used for lights turn on
        window.setColor(WINDOW_ON);
    }

    /**
     * This method should return the window in color black to displayed that the lights are off 
     */
    public void turnOFF () {

        //Set the color to the color used for lights turn off
        window.setColor(WINDOW_OFF);
    }
}

