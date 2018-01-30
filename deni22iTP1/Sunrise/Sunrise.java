import java.awt.*;
import objectdraw.*;

/**
 * This class allows the formation of a window with a specified size and a rectangular grass and a house figure.
 * Everytime the user clicks the mouse then the moon sets and the sun rises changing color from red to yellow till it is up on the very top of the sky.
 * On the exit of the users mouse the window goes back to be with the moon on the sky
 * 
 * @author (Ioanna Deni) 
 * @version (Tuesday 7 March 2017)
 */

public class Sunrise extends WindowController
{
    // In order to draw the moon and sun in the window we give then sizes 
    private static final int MOON_SIZE = 100;
    private static final int SUN_SIZE = 150;
    
    //We save each time the moon and the sun in instant variables
    private FilledOval moon;
    private FilledOval sun;

    // We save the location point of the user so we know when it was outside the window and when in
    private Location lastPoint;

    //Creating these variables the user can change the window size and the program still works calculating the distances on each own
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;

    // We give the location of the grass and the house relative to the window
    private static final int GRASS_SIZE = 150;
    private static final int GRASS_TOP = WINDOW_HEIGHT - GRASS_SIZE;
    private static final int HOUSE_HEIGHT = 50;
    private static final int HOUSE_WIDTH = 80;
    private static final int LINE1_TOP = GRASS_TOP - HOUSE_HEIGHT;
    private static final int LINE2_TOP = LINE1_TOP - 20;
    
    //We save the color of the sun which keep changing to let the whole program know its current value and add on that  
    private Color colorNew;
    
    //We save the distance that the sun and the moon travels and also the value that changes the color of the sun
    //We have two values because the sun is much bigger and we don't want that to effect the movement of the smaller moon
    int x = 10;
    int y = 0;
        
    /**
     * From the beginning of the program a grass area, a sky area, a house and a circle that is the moon appears
     */
    public void begin () 
    {
        // We have set the size of the window that we want to have to specific values to broaden it 
        resize (WINDOW_WIDTH, WINDOW_HEIGHT);

        // First we draw a rectangle to be the grass 
        FilledRect grass = new FilledRect (0, GRASS_TOP, getWidth(), getHeight() - GRASS_TOP, canvas);
        grass.setColor (Color.GREEN);

        //To draw the house
        FilledRect house = new FilledRect (getWidth()/2 + HOUSE_WIDTH, GRASS_TOP - HOUSE_HEIGHT, HOUSE_WIDTH, HOUSE_HEIGHT, canvas);
        Line line1 = new Line (getWidth()/2 + HOUSE_WIDTH, LINE1_TOP, getWidth()/2 + HOUSE_WIDTH + HOUSE_WIDTH/2, LINE2_TOP, canvas); 
        Line line2 = new Line (getWidth()/2 + HOUSE_WIDTH + HOUSE_WIDTH/2, LINE2_TOP, getWidth()/2 + HOUSE_WIDTH*2, LINE1_TOP, canvas);         

        // The moon in the begging
        moon = new FilledOval (0, 0, MOON_SIZE, MOON_SIZE, canvas);
        moon.setColor (Color.GRAY);

    }

    /**
     * On each mouse click creates a sun bright red located behind the grass and the moon sets
     * @param point where the user clicked.
     */
    public void onMouseClick (Location point) {
        //To save memory we clean the drawings and add new ones so we draw on top of them
        canvas.clear();

        //To draw the house
        FilledRect house = new FilledRect (getWidth()/2 + HOUSE_WIDTH, GRASS_TOP - HOUSE_HEIGHT, HOUSE_WIDTH, HOUSE_HEIGHT, canvas);
        Line line1 = new Line (getWidth()/2 + HOUSE_WIDTH, LINE1_TOP, getWidth()/2 + HOUSE_WIDTH + HOUSE_WIDTH/2, LINE2_TOP, canvas); 
        Line line2 = new Line (getWidth()/2 + HOUSE_WIDTH + HOUSE_WIDTH/2, LINE2_TOP, getWidth()/2 + HOUSE_WIDTH*2, LINE1_TOP, canvas);

        //We need the sun to start from just above the grass lenght and rise 10 pixels at a time till it reaches the height of the window   
        if (x <= WINDOW_HEIGHT - SUN_SIZE){
            // To create the sun
            sun = new FilledOval (0, GRASS_TOP - x, SUN_SIZE, SUN_SIZE, canvas);
            
            //We create this loop so if the required yellow is created then we just stop adding green and use that
            if (x < 255){
                //The color red is 255 thus the color is red then slowly we add green (by 10) to make it bright yelllow
                colorNew = new Color (255, y, 0);
            }
            //This is outside the loop so it can still have coolor even if we have the brightest yellow
            sun.setColor(colorNew);

            //Updating the x so it keeps moving up to all of the height of the window
            x = x + 10;
        }
        
        //We need these lines of code so when we reach the height of the window to stop the previous loop and just stay there
        sun = new FilledOval (0, GRASS_TOP - x, SUN_SIZE, SUN_SIZE, canvas);
        sun.setColor(colorNew);
        
        //This is for the moon so it keeps setting while the sun is rising. It is after the sun loop so it is drawn in front of it
        if (y < WINDOW_HEIGHT ){
            // To create the moon 
            
            moon = new FilledOval (0, 0 + y, MOON_SIZE, MOON_SIZE, canvas);
            moon.setColor (Color.GRAY);

            //Updating the y so it keeps moving to all of the height of the window
            y = y +10;
        }
        
        //Draw the grass last so it is drawn in fron od the moon or the sun
        FilledRect grass = new FilledRect (0, GRASS_TOP, getWidth(), getHeight() - GRASS_TOP, canvas);
        grass.setColor (Color.GREEN);

        //Saves the exact coordinates of the mouse to the variable 
        lastPoint = point;
    }

    /**
     * This is for when the mouse exits the window and the drawings are set to their original state 
     */
    public void onMouseExit (Location point) {
        //To save memory we clean the drawings and add new ones so we draw on top of them
        canvas.clear();

        // First we draw a rectangle to be the grass 
        FilledRect grass = new FilledRect (0, GRASS_TOP, getWidth(), getHeight() - GRASS_TOP, canvas);
        grass.setColor (Color.GREEN);

        //To draw the house
        FilledRect house = new FilledRect (getWidth()/2 + HOUSE_WIDTH, GRASS_TOP - HOUSE_HEIGHT, HOUSE_WIDTH, HOUSE_HEIGHT, canvas);
        Line line1 = new Line (getWidth()/2 + HOUSE_WIDTH, LINE1_TOP, getWidth()/2 + HOUSE_WIDTH + HOUSE_WIDTH/2, LINE2_TOP, canvas); 
        Line line2 = new Line (getWidth()/2 + HOUSE_WIDTH + HOUSE_WIDTH/2, LINE2_TOP, getWidth()/2 + HOUSE_WIDTH*2, LINE1_TOP, canvas);         

        // The moon in the begging
        moon = new FilledOval (0, 0, MOON_SIZE, MOON_SIZE, canvas);
        moon.setColor (Color.GRAY);
        
        //These are also set in their original values so the user can repeat the sunrise
        x = 10;
        y = 0;

        //Saves the exact coordinates of the mouse to the variable 
        lastPoint = point;
    }
}

