import java.awt.*;
import objectdraw.*;

/**
 * This class constructs a caterpillar accepting a canvas an x and a y coordinates builds 4 circles of a specific size and color one next to the other.
 * This class also defines methods so the caterpillar can be moved as a whole by moving all the different parts together 
 * or it returns values needed for the dragging motion in the controller. 
 * 
 * @author (Ioanna Deni) 
 * @version (Tuesday 7 March 2017)
 */
public class Caterpillar
{
    // The size of the caterpillar are hold in static instance variables for future change conviniences  
    private static final int BODY_SIZE = 30;
    private static final int EYE_SIZE = 10;

    //The Margin for the eye from the left and top
    private static final int MARGIN = 5;

    //The different parts of the body are saved in variables so the methods can use the current positions too
    private FilledOval body1;
    private FilledOval body2;
    private FilledOval body3;
    private FilledOval body4;
    private FilledOval eye;

    /**
     * Constructor for the caterpillar that draws all the parts of a caterpillar
     * as a whole. The parameters are the location of the mouse LEFT and TOP 
     * where the caterpillar is drawn
     */
    public Caterpillar(double left, double top, DrawingCanvas canvas)
    {
        //To draw the tree little circles that are the body 
        body1 = new FilledOval (left, top, BODY_SIZE, BODY_SIZE, canvas);
        body2 = new FilledOval (left + BODY_SIZE, top, BODY_SIZE, BODY_SIZE, canvas);
        body3 = new FilledOval (left + BODY_SIZE*2, top, BODY_SIZE, BODY_SIZE, canvas);
        body4 = new FilledOval (left + BODY_SIZE*3, top, BODY_SIZE, BODY_SIZE, canvas);

        //To give the body parts color green
        body1.setColor (Color.GREEN);
        body2.setColor (Color.GREEN);
        body3.setColor (Color.GREEN);
        body4.setColor (Color.GREEN);

        //This is drawn after so it can be drawn on top of the other filled circles and it's black
        eye = new FilledOval (left + MARGIN, top + MARGIN, EYE_SIZE, EYE_SIZE, canvas);
    }

    /**
     * Here we define a method that containes what happens when the user clicks inside the area defined as caterpillar
     * @param point the location of the mouse (x and y coordinates)to check if they are inside the circles  
     */
    public boolean contains(Location point)
    {
        //if the point is contained in the area forming the caterpillar then each part is selected independently but as a whole

        if (body1.contains (point)) {
            return true;
        }
        else if (body2.contains (point)){
            return true;
        }
        else if (body3.contains (point) ){
            return true;
        }
        else if (body4.contains (point) ){
            return true;
        }
        else if (eye.contains (point) ){
            return true;
        }

        //If the point is not in any of the parts of the caterpillar then that area isn't selected
        return false;
    }

    /**
     * Here we define a method that containes what happens when the method move is called for the caterpillar
     * @param dx the distance to move right
     * @param dy the distance to move down 
     */
    public void move (double dx, double dy)
    {
        //Each part moves independently but as a whole 
        body1.move (dx, dy);
        body2.move (dx, dy);
        body3.move (dx, dy);
        body4.move (dx, dy);
        eye.move (dx, dy);
    }

    /**
     * Here we define a method that containes what happens when the method getX is called for the caterpillar
     * @param none
     */
    public double getX ()
    {
        //It returns the x and y coordinates of the head of the caterpillar 
        double x = body1.getX ();
        return x;
    }

    /**
     * Here we define a method that containes what happens when the method getLastX is called for the caterpillar
     * @param none
     */
    public double getLastX ()
    {
        //It returns the x coordinates of the last body part of the caterpillar 
        double lastX = body4.getX ();
        return lastX;
    }

    /**
     * Here we define a method that containes what happens when the method getY is called for the caterpillar
     * @param none
     */
    public double getY ()
    {
        //It returns the y coordinates of the start of any circle forming the caterpillar 
        double y = body1.getY ();
        return y;
    }

    /**
     * Here we define a method that containes what happens when the method getLastY is called for the caterpillar
     * @param none
     */
    public double getLastY ()
    {
        //It returns the y coordinates of the bottom of any circle forming the caterpillar 
        double lastY = body1.getY () + BODY_SIZE;
        return lastY;
    }
}
