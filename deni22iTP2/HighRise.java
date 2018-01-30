import java.awt.*;
import objectdraw.*;

/**
 * (The HighRise class manages the entire collection of windows after drawing a building with 8 of them.) 
 * (This class keeps the entire collection of windows in an array for every uilding.)
 * 
 * @author Ioanna Deni
 * @version 5/1/2017
 */
public class HighRise
{
    // Array to hold all the windows
    private Window[] windows;

    int numWindow = 0;

    /**
     * Constructor for HighRise that creates an array 
     *
     */
    public HighRise(int size)
    {
        //First we create the array based on the information that the constractor returns
        windows = new Window[size];
    }

    /**
     * Create a window and put it into the right position on ythe building and add it in the array.
     * Make sure there is enough space for all buildings.
     */
    public void addWindow (Window window, DrawingCanvas canvas) {
        //For as long as the window number is smaller than the actual defined lenght of the array the position which is empty
        // fill it with a window 
        if (numWindow < windows.length) {

            //The window that fills the position is represented by an index which is happening with order so first window is window[1] 
            windows[numWindow] = window;

            //Now we add the newCard to the array of cards
            numWindow++;
        }
    }

    /**
     * This method goes over all windows and turns them on.
     */
    public void turnOn () {
        //First all the indexes as checked

        for (int i = 0; i < numWindow; i++) {

            //For every single index of all windows made the turnOn method is and turns them on
            windows[i].turnON();
        }
    }

    /**
     * This method finds a card at a particular location
     */
    public Window getWindowAt (Location point) {

        //First all the indexes as checked
        for (int i = 0; i < numWindow; i++) {

            //first every single index the windows collection contains is checked and the specific one that contains that point is returned
            if (windows[i].contains (point)) {

                //The index of the specific window that contains that point is returned
                return windows[i];
            }
        }

        //If the user clicked outside all windows then null is returned and nothing happens
        return null;
    }

    /**
     * This method goes over all windows and turns them off.
     */
    public void turnOff () {
        //First all the indexes as checked

        for (int i = 0; i < numWindow; i++) {

            //For every single index of all windows made the turnOn method is and turns them on
            windows[i].turnOFF();
        }
    }
}
