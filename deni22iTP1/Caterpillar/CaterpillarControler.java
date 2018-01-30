import java.awt.*;
import objectdraw.*;

/**
 * This class is calling the caterpillar class to draw two caterpillars which can be moved with the mouse (dragged) and also if they overlapp they will move as a whole.
 * It provides the caterpillar class with an x and a y value which are coordinates of the mouse both in their formation and in their dragging.
 * 
 * @author (Ioanna Deni) 
 * @version (Tuesday 7 March 2017)
 */
public class CaterpillarControler extends WindowController
{
    //These variables save the location and the selection of each caterpillar else only one could be moved  
    private Caterpillar caterpillar1;
    private Caterpillar caterpillar2;

    // These variables will store which caterpillar was selected so it can be dragged in another method
    private boolean caterpillar1Grabbed = false;
    private boolean caterpillar2Grabbed = false;

    // This variable saves the location where the mouse was clicked or dragged
    private Location lastPoint;

    //This variables allows the formation of only two caterpillars
    private int x=0;

    /**
     * This metod allows the formation of a new caterpillar in each click of the user and where the user clicks.
     * @param point where the user clicked.
     */
    public void onMouseClick (Location point) {
        //This iif statement will allow the formation of only two new caterpillars

        if (x<2) {

            if (x==0) {
                caterpillar1= new Caterpillar (point.getX(), point.getY(), canvas);
            }

            if (x==1) {
                caterpillar2= new Caterpillar (point.getX(), point.getY(), canvas);
            }

            x = x +1;
        }
    }

    /**
     * If the user presses the mouse button over the area of the caterpillar then it can be moved around as a whole 
     * @param point where the user pressed the mouse button down
     */
    public void onMousePress (Location point) {
        // If the cateripillar is picked then the user press either on the three circles or the are of the eye 

        if (caterpillar1.contains (point)) {
            caterpillar1Grabbed = true;

            //Saves the exact coordinates of the mouse to the variable 
            lastPoint = point;
        }

        if (caterpillar2.contains (point)) {
            caterpillar2Grabbed = true;

            //Saves the exact coordinates of the mouse to the variable 
            lastPoint = point;
        }
        
        //The variable lastPoint=point is not outside the inner ifs because we want them to happen only if the caterpillar is grabbed - if it is outside it messes up with the onClick method
    } 

    /**
     * This is to drag the caterpillar if it is grabbed and moved it as the mouse moves
     * @param point where the mouse is at the end of the drag
     */
    public void onMouseDrag (Location point)
    {
        //The grabbed caterpillar is moved across x and y axis
        //The distance that the mouse travels in both axis is calculated and passed to the move method

        double dx = point.getX() - lastPoint.getX();
        double dy = point.getY() - lastPoint.getY();

        if (caterpillar1Grabbed) {
            //The inner if is there so the two figures can move together when they are close together 

            if (caterpillar1.getX() >= caterpillar2.getLastX() && caterpillar1.getX() <= caterpillar2.getX() && caterpillar1.getY() >= caterpillar2.getY() && caterpillar1.getY() <= caterpillar2.getLastY()){
                caterpillar1.move(dx, dy);
                caterpillar2.move(dx, dy);
            }
            else {
                //This is if the figures aren't together
                caterpillar1.move(dx, dy);
            }
        }

        if (caterpillar2Grabbed) {
            //The inner if is there so the two figures can move together when they are close together 

            if (caterpillar2.getX() >= caterpillar1.getLastX() && caterpillar2.getX() <= caterpillar1.getX() && caterpillar2.getY() >= caterpillar1.getY() && caterpillar2.getY() <= caterpillar1.getLastY()){
                caterpillar1.move(dx, dy);
                caterpillar2.move(dx, dy);
            }
            else {
                //This is if the figures aren't together
                caterpillar2.move(dx, dy);
            }
        }

        lastPoint = point;
    }

    /**
     * End the drag
     * @param point where the mouse is when the button is released
     */

    public void onMouseRelease(Location point){
        //This will allow later the operations to occur again after the release of the mouse 

        if (caterpillar1Grabbed) {
            caterpillar1Grabbed = false;
        }

        if (caterpillar2Grabbed) {
            caterpillar2Grabbed = false;
        }
    }
}
