import java.awt.*;
import objectdraw.*;

/**
 * This class allows the formation of a window with iteractions with the mouse and calls of class HotAir Balloon.
 * It creates what is instructed in the HotAirBalloon class and it allows the user to use the mouse to manipulate the structures.
 * 
 * @author (Ioanna Deni) 
 * @version (Monday 13 February 2017)
 */

public class BalloonController extends WindowController
{
    // In order to draw the hot air balloon in the window
    public HotAirBalloon balloon;
    
    // The background
    private FilledRect sky;
    private FilledRect grass;
    
    // Remember which object is being dragged, if either
    private boolean balloonGrabbed;
    
    // Location where last drag started
    private Location lastPoint;
    
    // Colors for the background
    private static final Color GRASS_COLOR = Color.GREEN;
    private static final Color DARK_GRASS = GRASS_COLOR.darker();
    private static final Color SKY_COLOR = Color.BLUE;
    private static final Color DARK_SKY = SKY_COLOR.darker();
    
    // Size of the window
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;
    
    // Location of grass
    private static final int GRASS_SIZE = 150;
    private static final int GRASS_TOP = WINDOW_HEIGHT - GRASS_SIZE;
    
    // Balloon location
    private static final int BALLOON_LEFT = 50;
    private static final int BALLOON_HEIGHT = WINDOW_HEIGHT - 350;
    
    //This variable will hold the last balloonGrabbed so the lastBalloon that the mouse was in can move 
    public HotAirBalloon lastBalloon;
     

    /**
     * From the beginning of the program a grass area, a sky area and a balloon appears in a fixed location
     */
    public void begin () 
    {
        // We have set the size of the window that we want to have to specific values to broaden it 
        resize (WINDOW_WIDTH, WINDOW_HEIGHT);

        // First we draw a rectangle to be the grass 
        grass = new FilledRect (0, GRASS_TOP, getWidth(), getHeight() - GRASS_TOP, canvas);
        grass.setColor (GRASS_COLOR);
        
        //Then we draw another rectangle to fill the area that the sky takes
        sky = new FilledRect (0, 0, getWidth(), GRASS_TOP, canvas);
        sky.setColor (SKY_COLOR);
        
        // The very first balloon appears since we call it in specific location
        balloon = new HotAirBalloon (BALLOON_LEFT, BALLOON_HEIGHT, canvas);
    }

    /**
      * On each mouse click creates a new hot air balloon located where the user clicks.
      * @param point where the user clicked.
      */
     public void onMouseClick (Location point) {
         balloon = new HotAirBalloon (point.getX(), point.getY(), canvas);
     }
     
    /**
      * If the user presses the mouse button over the area of the hot air balloon we can drag it around
      * @param point where the user pressed the mouse button down
      */
     public void onMousePress (Location point) {
         
         // If the balloon is picked which means the user press either on the balloon area or the basket 
         if (balloon.contains (point)) {
             balloonGrabbed = true;
             
             //Saves the exact coordinates of the mouse to the variable 
             lastPoint = point;
             lastBalloon = balloon;
         }
     } 
     
     /**
      * This is to drag the balloon if it is grabbed and moved it as the mouse moves
      * @param point where the mouse is at the end of the drag
      */
     public void onMouseDrag (Location point) {
         
        // Drag the balloon only moves on the horizontal axis (the y), so ignore how far the mouse moved vertically
         if (balloonGrabbed){
            double dy = point.getY() - lastPoint.getY(); // to find the distance travelled by the mouse
            lastBalloon.move (dy);
            
            //Saves the exact coordinates of the mouse to the variable
            lastPoint = point;
            lastBalloon = balloon;
        }
    } 
    
    /**
     * End of the drag in order to release the balloon the user picked
     * @param point where the mouse is when the button is released
     */
    public void onMouseRelease (Location point) {
        balloonGrabbed = false;
    }
    
    /**
     * This is for when the mouse exits the window and the colors of the sky the grass 
     * and the last balloon that the user clicked on become darker 
     * (the method for the darkening for the lastBallon doesn't work - don't know why)
     */
    public void onMouseExit (Location point) {
        //lastBalloon.darker();
        sky.setColor (DARK_SKY);
        grass.setColor (DARK_GRASS);
    }
   
    /**
     * This is for when the mouse enters the window again the colors of the sky the grass 
     * and the last balloon that the user clicked on become their initial color
     * (the method for the lightening for the lastBallon also doesn't work - don't know why)
     * (if I added these lines of code that now are in comments-form the program won't run)
     */
    public void onMouseEnter (Location point) {
        //lastBalloon.lighter();
        sky.setColor (SKY_COLOR);
        grass.setColor (GRASS_COLOR);
    }
}
