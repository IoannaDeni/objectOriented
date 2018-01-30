import objectdraw.*;
/**
 * This is the first assigment of the lab and we learnt that we can write commands that can be executed as soon as the program runs,
 * or that we can execute then when pressing the mouse or releasing or clicking 
 * and also store the coordinates of the point we pressed or clicked the mouse and the value can be used as the initial coordinates for our drawing.
 * Lastly, we learnt that we can keep getting the coordinates of the mouse if we hold and drag it it and thus create many drawings in different positions.
 * 
 * @author Ioanna Deni 
 * @version Monday 31 January 2017
 */
public class MyFirstClass extends WindowController
{
    public void begin()
    {
        /* Creates a black rectangle that is 100 pixels wide and 200 pixels tall.
         * It starts at 10 (x-coordinate) and 50 (y-coordinate)
         * The // before the code have to be removed for it to run but I put them in so the second code can run.
         * Because ot will do the same rectangle and I won't be able to see it.
         */ 
        //new FilledRect (10, 50, 100, 200, canvas); 
    }
    
    public void onMousePress (Location point)
    {
        /* Creates a black rectangle like the one above when the users presses the mouse button
         */
        new FilledRect (10, 50, 100, 200, canvas);
    }
    
    public void onMouseRelease (Location point)
    {
        /* Creates a black rectangle that is 10 pixels wide and 20 pixels tall.
         * It starts at 50 (x-coordinate) and 10 (y-coordinate) 
         */
        new FilledRect (50, 10, 10, 20, canvas);
    }
    
    //The two last rectangles can co-exist and when I press the mouse the big one appears when I release the smaller one appears
    
    public void onMouseClick (Location point)
    {
        /* Creates a black rectangle that is 20 pixels wide and 40 pixels tall.
         * It doesn't start on coordinates now but instead it starts at the coordinates of the point we click with the mouse
         */
        new FilledRect (point, 10, 20, canvas);
    }
    
    public void onMouseDrag (Location point)
    {
       /* Creates a black rectangle that is 1 pixels wide and 1 pixels tall.
         * It doesn't start on coordinates but instead it starts at the coordinates of the point we have our mouse after we click it and till we release it.
         */ 
        new FilledRect (point, 2, 2, canvas);
    }
}
