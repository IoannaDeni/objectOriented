import java.awt.*;
import objectdraw.*;

/**
 * The HighRise class manages the entire collection of windows after drawing a building with 8 of them. It has a constuctor for the buildings and 
 * then it keeps the entire collection of windows in an array for all buildings. It also has definitions for methods like the turnOff that goes through all added windows 
 * in the array and turns the lights off, or on for the turnOn method. A contain method that takes a location point on the canvas and returns true of false
 * wether the user clicked on top of a building and lastly a lightSwitch method that takes a location point on the canvas and checks whether it is on top of a window 
 * and if it is it switchwes the light on that particlar window. The windows are only created in this class.
 * 
 * @author Ioanna Deni
 * @version 5/1/2017
 */
public class HighRise
{

    //This variables hold the sized of the buildings 
    private static final int BUILDING_HEIGHT = 200;
    private static final int BUILDING_WIDTH = 100;

    // The color for the building 
    private static final Color COLOR = Color.GRAY;

    //These variables hold the maximun number of buuildings available for the user the maximun number of windows in each building and finally the total of all windows in all buildings 
    private static final int MAX_BUILDINGS = 5;
    private static final int WINDOW_BUILDING = 8;
    private static final int MAX_WINDOWS = MAX_BUILDINGS * WINDOW_BUILDING;

    // Array to hold all the windows
    private Window[] windows = new Window[MAX_WINDOWS];;

    private int numWindow = 0;

    //This variables hold the sized of the window for all the buildings  
    private static final int WINDOW_SIZE = 20;

    //This variables hold the space from the walls across the width of the building relative to the window size
    private static final int MARGIN_WIDTH = (BUILDING_WIDTH - 2*WINDOW_SIZE)/3;

    //This variables hold the space from the walls across the width of the building relative to the window size
    private static final int MARGIN_HEIGHT = (BUILDING_HEIGHT - 4*WINDOW_SIZE)/5;

    //We store the building variable so we can use it in anoter methods apart from the one created.
    private FilledRect building;
    
    
    /**
     * Constructor for the bulding with the windows, Creates a rectangle with specified height and width 
     * colored gray at teh canvas. 
     * 
     * @param int coordinates of where is the ground and how big is the width of the window because the location of the x-coordinate is randomized   
     * @param a canvas
     */
    public HighRise (int top, int windowWidth, DrawingCanvas canvas)
    {

        // This is for random positioning of the building number restriction between 0 to WINDOW_WIDTH - 100 which is as wide as a building so the building isn't outside our window
        RandomIntGenerator left = new RandomIntGenerator (0, windowWidth - BUILDING_WIDTH);

        // Here the actual value is generated
        int valueLeft = left.nextValue();

        //This objectDraw constractor will make a building like rectangle in a random left position but in a specified y-position so it is above the ground
        building = new FilledRect (valueLeft, top - BUILDING_HEIGHT, BUILDING_WIDTH, BUILDING_HEIGHT, canvas);

        //This is the outlined frame rectangle that holds the exact coordinates of the building
        FramedRect aroundBuild = new FramedRect (valueLeft, top - BUILDING_HEIGHT, BUILDING_WIDTH, BUILDING_HEIGHT, canvas);

        //Set the color of the building to its color
        building.setColor(COLOR);

        //Here the windows are placed in two columns and four rows 
        for (int numXWindow = 0; numXWindow < WINDOW_BUILDING/4; numXWindow ++)
        {
            //The one loop goes throught the x columns of the windows on the building
            //While the next loop goes throught the y rows of the windows on the building

            for (int numYWindow = 0; numYWindow < WINDOW_BUILDING/2; numYWindow ++) 
            {

                //After defining the number coordinates for eact window in each building we are building the window based on the pre-defined margins and building size
                Window window = new Window (numXWindow*(WINDOW_SIZE + MARGIN_WIDTH) + MARGIN_WIDTH + valueLeft, numYWindow*(WINDOW_SIZE + MARGIN_HEIGHT) + MARGIN_HEIGHT + top - BUILDING_HEIGHT, WINDOW_SIZE, canvas);

                //After we have created we are adding it to the collection so we can use it later
                if (numWindow < windows.length) {
                    //For as long as the window number is smaller than the actual defined lenght of the array the position which is empty fill it with a window 

                    //The window that fills the position is represented by an index which is happening with order so first window is window[1] 
                    windows[numWindow] = window;

                    //Now we add the new  window to the array of windows
                    numWindow++;
                }
            }
        }
    }

    /**
     * This method goes over all windows and turns the lights on.
     */
    public void turnOn () {
        //First all the indexes as checked

        for (int i = 0; i < numWindow; i++) {

            //For every single index of all windows made the turnOn method is and turns them on
            windows[i].turnON();
        }
    }

    /**
     * This method determines if the user clicked on a building or not
     */
    public boolean contain (Location point)
    {
        //The rectangle which is named building returns true if the user clicked on it
        if (building.contains (point)) {
            return true;
        }

        //else false is return and nothing happens
        return false;

    }

    /**
     * This method goes over all windows and turns the lights off.
     */
    public void turnOff () {
        //First all the indexes as checked

        for (int i = 0; i < numWindow; i++) {

            //For every single index of all windows made the turnOn method is and turns them on
            windows[i].turnOFF();
        }
    }

    /**
     * This method checks all windows on the array of this class and swicths the lights from yellow o black or the other way around
     */
    public void lightSwitch(Location point)
    {
        //First all the indexes as checked
        
        for (int i = 0; i < numWindow; i++) {

            //For every single index the windows collection contains is checked and the specific one that contains that point is loaded to the method switchColor
            windows[i].swictColor (point);
        }
    }
}