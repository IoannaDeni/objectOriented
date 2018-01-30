import objectdraw.*;
import java.awt.*;
/**
 * In the second assigment we create a still picture of a train. We call collors form the java.awt library
 * and we fill rectangles and ovals in order to build a red train with a non-colored chimney, that smokes gary ovalled shape smoke
 * and it has two black wheels in a green background on a line that represents the ground.
 * 
 * @author Ioanna Deni 
 * @version Monday 31 January 2017
 */
public class Train extends WindowController
{
/*
 * we are using begin method because we are building a still image with zero interaction with the mouse.
 * Also the image will be formed as soon as we run the program
 */
   public void begin()
   {
       /*
        * Creates a green rectangle that is 400 pixels wide and 400 pixels tall - filles all the window
        * It starts at 0 (x-coordinate) and 0 (y-coordinate)
        */
       new FilledRect (0, 0, 400, 400, canvas).setColor(Color.GREEN);
       /*
        *Creates a straight line that starts at 0 (x-coordinate) and 380 (y-coordinate) 
        * and finishes at 400 (x-coordinate) and 380 (y-coordinate) 
        * So it can fill all the window
        */
       new Line (0, 380, 400, 380, canvas);
       /*
        * Creates a frame in the shape of rectangle that is 50 pixels wide and 50 pixels tall.
        * It starts at 280 (x-coordinate) and 150 (y-coordinate)
        */
       new FramedRect(280, 150, 50, 50, canvas);
       /*
        * Creates a red rectangle that is 350 pixels wide and 120 pixels tall.
        * It starts at 20 (x-coordinate) and 200 (y-coordinate)
        */
       new FilledRect(20, 200, 350, 120, canvas).setColor(Color.RED);
       /*
        * Creates a light gray oval that is 400 pixels wide and 700 pixels tall
        * It starts at 285 (x-coordinate) and 60 (y-coordinate)
        */
       new FilledOval(285, 60, 40, 70, canvas).setColor(Color.LIGHT_GRAY);
       /*
        * Creates a black oval that is 61 pixels wide and 61 pixels tall - so it is a circle
        * It starts at 80 (x-coordinate) and 319 (y-coordinate)
        */
       new FilledOval(80, 319, 61, 61, canvas);
       /*
        * It does the same as the previous command only now it starts at 270 (x-coordinate) and 319 (y-coordinate) 
        */
       new FilledOval(270, 319, 61, 61, canvas);
    }
}