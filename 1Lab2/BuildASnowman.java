import java.awt.*;
import objectdraw.*;
/**
 * This class anables the user to move three circles and form a snowman. 
 * With pressing the mouse the user selects a circle and drags it on the screen. If the circle is brought close enough to the right circle the two of then snap together and can be moved around together.
 * If all are snapped together correctly the snowman is complete and "Good job!" appears. The snow man can be completed on any part of the screen.
 * 
 * @author (Ioanna Deni) 
 * @version (Monday 6th February 2017)
 */
public class BuildASnowman extends WindowController
{
    //The distance from the left of the display for the first ball initially
    private static final int LEFT = 10;
    
    //The distance from the top of the display to the tops of the ball initially
    private static final int TOP = 10;
    
    // The diameter of the snowman’s head
    private static final int HEAD_SIZE = 65;
    
    // The ball that represents the snowman’s head
    private FramedOval head;
    
    // The diameter of the snowman’s body
    private static final int BELLY_SIZE = 100;
    
    // The ball that represents the snowman’s head
    private FramedOval belly;
    
    //The diameter of the snowman’s feet
    private static final int FEET_SIZE = 150;
    
    // The ball that represents the snowman’s head
    private FramedOval feet;
    
    // Here we create a instant variable to keep saving the exact coordinates of the mouse 
    private Location lastPoint;
    
    // In order to remember which ball was clicked on, if any we create 3 boolean instance variables foe the space of each circle 
    private boolean headGrabbed = false;
    private boolean bellyGrabbed = false;
    private boolean feetGrabbed = false;
    
    // It is the error which is allowed and still brings all the balls centered 
    private static final int ERROR_MARGIN=30;
    
    //To make the program run only once we allow the operations to occur only when this is false and then set it to true 
    private boolean afterCreation;
    
    //The moment we open the program:
    public void begin()
    {
        // In the begining the display will be of three balls, the head, the body and the feet 
        head = new FramedOval (LEFT, TOP, HEAD_SIZE, HEAD_SIZE, canvas);
        
        // The distance between the center of each ball is the diameter plus left that is why we multiply LEFT by 2 and add the size
        belly = new FramedOval (2*LEFT+HEAD_SIZE, TOP, BELLY_SIZE, BELLY_SIZE, canvas);
        
        // Similarly here only now by 3 because we have all three circles - TOP remains the same 
        feet = new FramedOval (3*LEFT+HEAD_SIZE+BELLY_SIZE, TOP, FEET_SIZE, FEET_SIZE, canvas);
       
        afterCreation = false;
    }
    
    //Determine if the user selected one of the balls
    public void onMousePress(Location point)
    {
        //This will allow later the operations to occur only once when set to true onMouseRelease            
        if (head.contains (point))
        {
            headGrabbed = true;
            lastPoint = point; //Saves the exact coordinates of the mouse to the variable 
        }
        else if (belly.contains (point))
        {
             bellyGrabbed = true;
             lastPoint = point;
        }
        else if (feet.contains (point))
        {
             feetGrabbed = true;
             lastPoint = point;
        }
    }
    
    //If any of the balls are grabbed they are moved - dragged as the mouse moves
    public void onMouseDrag (Location point)
    {
        //This will allow later the operations to occur only once when set to true onMouseRelease
        if (afterCreation == false) { 
            
            if (headGrabbed) {
                double headX = point.getX() - lastPoint.getX();
                double headY = point.getY() - lastPoint.getY();
                
                //This is when the head and the belly are snapped together so they move together
                if (head.getY()+ HEAD_SIZE == belly.getY() && belly.getX() + BELLY_SIZE/2 - HEAD_SIZE/2 == head.getX() ){
                    belly.move(headX, headY);
                    head.move(headX, headY);
                    lastPoint = point;
                    }
                    else{//This is if head and belly aren't snapped together
                        head.move(headX, headY);
                        lastPoint = point;
                        }
            }
            
            if (bellyGrabbed) {
                double bellyX = point.getX() - lastPoint.getX();
                double bellyY = point.getY() - lastPoint.getY();
                
                //This is when the head and the belly are snapped together so they move together
                if (belly.getY() - HEAD_SIZE == head.getY() && head.getX() == belly.getX() + BELLY_SIZE/2 - HEAD_SIZE/2){
                    head.move(bellyX, bellyY);
                    belly.move(bellyX, bellyY);
                    lastPoint = point;
                    }
                
                if (belly.getY() + BELLY_SIZE == feet.getY() && belly.getX() + BELLY_SIZE/2 - FEET_SIZE/2 == feet.getX() ){//This is when the feet and the belly are snapped together so they move together
                        belly.move(bellyX, bellyY);
                        feet.move(bellyX, bellyY);
                        lastPoint = point;
                        }
                        
                if (belly.getY() + BELLY_SIZE != feet.getY() &&
                    belly.getX() + BELLY_SIZE/2- FEET_SIZE/2 != feet.getY() &&
                    belly.getX() + BELLY_SIZE/2 - HEAD_SIZE/2 != head.getX() &&
                    belly.getY() - HEAD_SIZE != head.getY()){//This is if head and belly and feet aren't snapped together
                        belly.move(bellyX, bellyY);
                        lastPoint = point;
                        }

            }
            
            if (feetGrabbed) {
                double feetX = point.getX() - lastPoint.getX();
                double feetY = point.getY() - lastPoint.getY();
                
                //This is when the feet and the belly are snapped together so they move together
                if (belly.getY() + BELLY_SIZE == feet.getY() && feet.getX() == belly.getX() + BELLY_SIZE/2 - FEET_SIZE/2 ){
                    feet.move(feetX, feetY);
                    belly.move(feetX, feetY);
                    lastPoint = point;
                    }
                    else{//This is if feet and belly aren't snapped together
                        feet.move(feetX, feetY);
                        lastPoint = point;
                        }
            }
        }
    }
    
  /**
     * End the drag
     * @param point where the mouse is when the button is released
     */
    
    public void onMouseRelease(Location point){
        //This will allow later the operations to occur only once when set to true onMouseRelease
        if (afterCreation == false) {
            if (headGrabbed){
                //This is so the head is released from the mouse till we pick it again
                headGrabbed = false;
                
                //To find the location of the centered head in compare with the belly we define where the centerX of the belly is 
                //and then we find the coordinates of the Left, Top box that encloses the head
                double bellyCenterX = belly.getX()+ BELLY_SIZE/2;
                double headTop = belly.getY() - HEAD_SIZE;
                double headLeft = bellyCenterX - HEAD_SIZE/2;
                
                //if the head is close by the ERROR_MARGIN to the belly then we assign the final location of the head to the calculated one (see above) 
                if (head.getX()>headLeft - ERROR_MARGIN &&
                    head.getX()<headLeft + ERROR_MARGIN && 
                    head.getY()>headTop - ERROR_MARGIN&& 
                    head.getY()<headTop + ERROR_MARGIN)
                    {
                        head.moveTo(headLeft, headTop);
                    }
            }
        
            if(bellyGrabbed){
                //This is so the belly is released from the mouse till we pick it again
                bellyGrabbed = false;
            
                //To find the location of the centered belly in compare with the head or feet we define where the centerX of the belly and the feet is 
                //and then we find the coordinates of the Left, Top box that encloses the in relation to the feet and in relation to the head
                double feetCenterX = feet.getX()+ FEET_SIZE/2;
                double feetToBellyLeft = feetCenterX - BELLY_SIZE/2;
                double feetToBellyTop = feet.getY() - BELLY_SIZE;
                double headCenterX = head.getX()+ HEAD_SIZE/2;
                double headToBellyLeft = headCenterX - BELLY_SIZE/2;
                double headToBellyTop = head.getY() + HEAD_SIZE;
            
                //if the belly is close by the ERROR_MARGIN to the feet then we assign the final location of the belly to the calculated one (see above)
                if (belly.getX()>feetToBellyLeft - ERROR_MARGIN &&
                    belly.getX()< feetToBellyLeft + ERROR_MARGIN && 
                    belly.getY()>feetToBellyTop - ERROR_MARGIN && 
                    belly.getY()<feetToBellyTop + ERROR_MARGIN) {
                        belly.moveTo(feetToBellyLeft, feetToBellyTop);
                }
                    
                //if the belly is close by the ERROR_MARGIN to the head then we assign the final location of the belly to the calculated one (see above)
                if(belly.getX()>headToBellyLeft - ERROR_MARGIN && 
                   belly.getX()< headToBellyLeft + ERROR_MARGIN && 
                   belly.getY()>headToBellyTop - ERROR_MARGIN && 
                   belly.getY()<headToBellyTop + ERROR_MARGIN) {
                       belly.moveTo(headToBellyLeft, headToBellyTop);
                }
            }
        
            if (feetGrabbed){
                //This is so the feet is released from the mouse till we pick it again
                feetGrabbed = false;
                  
                //To find the location of the centered feet in compare with the belly we define where the centerX of the belly is 
                //and then we find the coordinates of the Left, Top box that encloses the feet 
                double bellyCenterX = belly.getX()+ BELLY_SIZE/2;
                double feetLeft = bellyCenterX - FEET_SIZE/2;
                double feetTop = belly.getY() + BELLY_SIZE;
                    
                //if the feet is close by the ERROR_MARGIN to the belly then we assign the final location of the feet to the calculated one (see above)
                if (feet.getX()>feetLeft - ERROR_MARGIN &&
                    feet.getX()<feetLeft + ERROR_MARGIN && 
                    feet.getY()>feetTop - ERROR_MARGIN&& 
                    feet.getY()<feetTop + ERROR_MARGIN){
                        feet.moveTo(feetLeft, feetTop);
                }
            }
                
            if (head.getY()+ HEAD_SIZE + BELLY_SIZE == feet.getY() && head.getX() + HEAD_SIZE/2 - FEET_SIZE/2 == feet.getX()) {
                afterCreation= true; //Doing this line of code is setting the value to true thus nothing will happen onMouseDrag or onMouseRelease and the text will appear on the top left corner
                new Text("Good job!", LEFT, TOP, canvas);
            }
        }
    }
}
