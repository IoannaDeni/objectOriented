import java.awt.*;
import objectdraw.*;

/**  
 *This is a constructor that calls a mascot which a picture and it calculates a random number and 
 *deletes the previous picture and then creates one moved the calculated number till the cross the finishing line 
 *and in the end of the race another class is called and fireworkds fill the screen
 *
 * Ioanna Deni 
 * Monday 27 March 2017
 */

public class Mascot extends ActiveObject
{
    // Time to delay between steps, measured in milliseconds
    private static final int DELAY_TIME = 33;

    // Width at which the figure should stop racing
    private double offScreen;

    //The final canvas where the picture is drawn and the y coordinates which is constant for each picture
    double yTop;
    DrawingCanvas finalCanvas;

    //These variable holds the location of where the figure should be in the end of the race 
    double leftMargin;

    //We make the picture an instance variable to use it later in the move method
    private VisibleImage visiblePicture;
    private Picture newPicture;
    
    //The speed of the figure - the bigger the speed the more likely to have a winner
    int xSpeed;
    
    //This is the final time that it takes the figure to finish
    int longPause;
    
    /**
     * Draws the mascot figure and gives it a random speed
     * @param left for where to draw the figure
     * @param top for where to draw the figure
     * @param picture so it has a picture loaded
     * @param canvas where to draw
     */
    public Mascot(double left, double top, Picture picture, DrawingCanvas canvas, int offscreen)
    {
        //To display the image in the same canvas as the window in the window controller
        finalCanvas = canvas;
        yTop = top;
        newPicture = picture;

        //In order to have the MARGIN we need to save where the picture starts
        leftMargin = left;

        //To display the images
        visiblePicture = picture.createVisibleImage(left, top, finalCanvas);

        //In order to later use the race finishing lenght
        offScreen = offscreen;

        start();
    }

    /**
     * In order for the figure to move
     */
    public void run() {
        // Stop when we reach the finishing line
        
        //This is so we start with time zero
        longPause =0;

        while (leftMargin > offScreen) {
            //Generates a random number of pixels in x direction to be the speed of the figure
            RandomIntGenerator speedGen = new RandomIntGenerator (4, 8);
            xSpeed = speedGen.nextValue();

            //Move the figure a small amount
            move(leftMargin);

            // In order to move like it is racing it has a delay time so we don't just see the final destination
            pause (DELAY_TIME);

            // Increase the counter so that the while loop will eventually end.
            leftMargin = leftMargin - xSpeed;
            longPause = longPause + DELAY_TIME; 
        }

        //Add fireworks with random color
        RandomIntGenerator ColorGenerator = new RandomIntGenerator (0, 255);

        // The random number generator used to determine the size of the firework.
        RandomIntGenerator sizeGenerator = new RandomIntGenerator (25, 75);

        new Finale(ColorGenerator, ColorGenerator, sizeGenerator, finalCanvas);
    }

    /**
     * Here we define what happens when the method move is called for the mascot
     * @param dx the distance to move right
     */
    private void move (double dx)
    {
        //First we remove the picture that already is drawn on the canvas
        visiblePicture.removeFromCanvas();

        //To display the images in the new coordinates in the x direction
        visiblePicture = newPicture.createVisibleImage(leftMargin, yTop, finalCanvas);
    }
    
    /**
     * Here we define what happens when the method winner is called in the controller
     * and return the int of the speed
     */
    public int winner ()
    {
        pause(longPause);
        return xSpeed;
    }
}
