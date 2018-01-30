import objectdraw.*;
import java.awt.*;

/**
 * Draws a stick figure
 * 
 * @author Barbara Lerner
 */
public class StickFigure extends WindowController
{
    // The location and size of the head
    private static final int HEAD_LEFT = 100;
    private static final int HEAD_TOP = 100;
    private static final int HEAD_SIZE = 100;
    
    // The location and size of the body
    private static final int BODY_LEFT = HEAD_LEFT + (HEAD_SIZE / 2);
    private static final int BODY_TOP = HEAD_TOP + HEAD_SIZE;
    private static final int BODY_SIZE = HEAD_SIZE;
    
    // The location and size of the arms
    private static final int ARM_X_OFFSET = HEAD_SIZE / 2;
    private static final int ARM_Y_OFFSET = HEAD_SIZE / 2;
    private static final int ARM_BOTTOM = BODY_TOP + ARM_Y_OFFSET;
    private static final int ARM_TOP = BODY_TOP;
    private static final int LEFT_ARM_LEFT = BODY_LEFT - ARM_X_OFFSET;
    private static final int RIGHT_ARM_RIGHT = BODY_LEFT + ARM_X_OFFSET;
    
    // The location and size of the legs.
    private static final int LEG_X_OFFSET = HEAD_SIZE / 2;
    private static final int LEG_Y_OFFSET = LEG_X_OFFSET;
    private static final int LEG_TOP = BODY_TOP + BODY_SIZE;
    private static final int LEFT_LEG_LEFT = BODY_LEFT - LEG_X_OFFSET;
    private static final int RIGHT_LEG_RIGHT = BODY_LEFT + LEG_X_OFFSET;
    private static final int LEG_BOTTOM = LEG_TOP + LEG_Y_OFFSET;
    
    /**
     * Draws a stick figure
     */
    public void begin () {
        // Draw the head
        FilledOval head = new FilledOval (HEAD_LEFT, HEAD_TOP, HEAD_SIZE, HEAD_SIZE, canvas);
        
        // Create the random number generator
        RandomIntGenerator colorGen = new RandomIntGenerator (0, 255);
        
        // Generate the RGB values
        int redness = colorGen.nextValue();
        int blueness = colorGen.nextValue();
        int greenness = colorGen.nextValue();
        
        // Draw a frame around the head if the color is very light
        if (redness > 230 || greenness > 230 || blueness > 230) {
            new FramedOval (HEAD_LEFT, HEAD_TOP, HEAD_SIZE, HEAD_SIZE, canvas);
        }

        // Create the color
        Color headColor = new Color (redness, greenness, blueness);
        head.setColor (headColor);
        
        // Draw the body
        new Line (BODY_LEFT, BODY_TOP, BODY_LEFT, BODY_TOP + BODY_SIZE, canvas);
        
        // Draw the arms
        new Line (LEFT_ARM_LEFT, ARM_TOP, BODY_LEFT, ARM_BOTTOM, canvas);
        new Line (RIGHT_ARM_RIGHT, ARM_TOP, BODY_LEFT, ARM_BOTTOM, canvas);
        
        // Draw the legs
        new Line (BODY_LEFT, LEG_TOP, LEFT_LEG_LEFT, LEG_BOTTOM, canvas);
        new Line (BODY_LEFT, LEG_TOP, RIGHT_LEG_RIGHT, LEG_BOTTOM, canvas);
    }
}
