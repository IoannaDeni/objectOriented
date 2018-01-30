import java.awt.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This is a ActiveObject constructor it takes as parameters x and y coordinates of where to start drawing
 * a canvas, rectangular boundary area and another pair of coordinates x, y and draws a ball staring in the first pair of coordinates
 * that is located on the canvas and bounches of the boundaries of the rectangle. Also it has a set delayed time and 
 * uses the second pair of coordinates to move in the x and y direction after waiting the delay time so the ball
 * can have an incorporated constsnt movement - like an animation - and not all of the movement happens at once.
 * 
 * @author Ioanna Deni
 * @version 4/9/2017
 */
public class BouncingBall extends ActiveObject {
    // Diameter of the ball
    private static final int BALLSIZE = 30;

    // Distance to move on each step vertically
    private double ySpeed;

    // Distance to move on each step horizontally
    private double xSpeed;

    // Time to delay between steps, measured in milliseconds
    private static final int DELAY_TIME = 33;

    // the pong ball
    private FilledOval ball;

    // boundaries of playing area
    private double playingAreaLeft;
    private double playingAreaRight;
    private double playingAreaTop;
    private double playingAreaBottom;

    private DrawingCanvas newCanvas;

    /**
     * Create a ball that bounces when it hits a walls.
     * @param ballLeft left side of the ball
     * @param ballTop top of the ball
     * @param canvas portion of screen to draw on
     * @param boundary rectangular area of the screen the ball stays within
     */
    public BouncingBall(double ballLeft, double ballTop, DrawingCanvas canvas, FramedRect boundary, double x, double y) {
        //For later use
        xSpeed = x;
        ySpeed = y;

        // Create the ball
        ball = new FilledOval(ballLeft, ballTop, BALLSIZE, BALLSIZE,
            canvas);

        // give names to boundary values
        playingAreaLeft = boundary.getX();
        playingAreaTop = boundary.getY();
        playingAreaRight = playingAreaLeft + boundary.getWidth() - BALLSIZE;
        playingAreaBottom = playingAreaTop + boundary.getHeight() - BALLSIZE;

        newCanvas = canvas;

        // Start the ball moving
        start();
    }

    /**
     * Cause the ball to move around the playing area at a specified (initial speed) speed. The ball 
     * bounces off the walls of the boundary.
     */
    public void run() {
        // Continue as long as the ball is still visible
        while (true) {

            // Move the ball a small initial amount
            ball.move(xSpeed, ySpeed);

            // Check that the ball has not hit a wall.  If it has, move it so that it
            // does not appear to go outside the boundary.  Negate its speed so that
            // on the next time through this loop it will move in the opposite direction.
            if (ball.getX() <= playingAreaLeft) {
                // Bounce to the right
                ball.moveTo (playingAreaLeft, ball.getY());
                xSpeed = -xSpeed;
            }
            else if (ball.getX() >= playingAreaRight) {
                // Bounce to the left
                ball.moveTo (playingAreaRight, ball.getY());
                xSpeed = -xSpeed;
            }

            if (ball.getY() <= playingAreaTop) {
                // Bounce down
                ball.moveTo (ball.getX(), playingAreaTop);
                ySpeed = -ySpeed;
            }
            else if (ball.getY() >= playingAreaBottom) {
                // Bounce up.
                ball.moveTo (ball.getX(), playingAreaBottom);
                ySpeed = -ySpeed;
            }

            // Pause to allow the display to update and give the feeling of animation
            pause(DELAY_TIME);
        }
    }

    /**
     * Cause the ball to change color.
     */
    public void color(Color color)
    {
        //To change the color of the ball
        ball.setColor(color);
    }

    /**
     * Cause the ball to be removed from the canvas that was saved both in the constructor and the WindowController.
     */
    public void remove()
    {
        //To remove it from the canvas
        ball.removeFromCanvas();
    }

    /**
     * This method returns the X coordinates of the ball at any given time.
     */
    public double getX()
    {
        //To find the x coordinate of the ball
        return ball.getX();
    }
    
    /**
     * This method returns the y coordinates of the ball at any given time.
     */
    public double getY()
    {
        //To find the y coordinate of the ball
        return ball.getY();
    }
}
