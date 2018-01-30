import java.awt.*;
import objectdraw.*;

/**
 * This is a contructor for buttons used for the ImageManipulator
 * 
 * @author (Ioanna Deni) 
 * @version (Monday 20 February 2017)
 * 
 */
public class Button
{
    // Initial locations and sizes of the different parts of the button
    private int BUTTON_TOPMARGIN = 2;
    private int BUTTON_LEFTMARGIN = 2;
    private double width;
    private double height;
    private Text text;
    private FramedRect button; 

    /**
     * Constructor for objects of class button draws all the parts of a button
     * as a whole. The parameters are the location the button, the text and the canvas 
     */
    public Button (double left, double top, String label, DrawingCanvas canvas)
    {
        // This is for random color we call the random number generator (no restriction 0-255)
        RandomIntGenerator colorGen = new RandomIntGenerator (0, 255);

        // Generate the RGB values
        int redness = colorGen.nextValue();
        int blueness = colorGen.nextValue();
        int greenness = colorGen.nextValue();

        //Draw the text last so it can appear on top of the other shapes
        text = new Text (label, left + BUTTON_LEFTMARGIN, top + BUTTON_TOPMARGIN, canvas);
        Font font = new Font("Jokerman", Font.PLAIN, 35);
        text.setFont(font);
        Color fontColor = new Color ((redness), (greenness), (blueness));
        text.setColor(fontColor);

        //I did the getRight method a little different - it gets the width and height of the text  
        //getRight();

        //Returns the coordinates of the height and width
        width = text.getWidth();
        height = text.getHeight();

        //Draw the frame rectangle that is the button and give it color
        button = new FramedRect(left, top, width + BUTTON_LEFTMARGIN*2, height + BUTTON_TOPMARGIN*2, canvas);
        Color Color = new Color ((255-redness), (255-greenness), (255-blueness));
        button.setColor(Color);
    }

    /**
     * Here we define what happens when the method getRight is called for the button coordinates
     */
    public double getRight()
    {     
        //Returns the coordinates of the width
        return width + BUTTON_LEFTMARGIN*2;
    }
    
    /**
     * Here we define what happens when point in somewhere on top of the button
     * @param point the location to check for containment 
     */
    public boolean contains(Location point)
    {
        //if the point is contained in the area forming the button
        
        if (button.contains (point)) {
            return true;
        }
        else if (text.contains (point)){
            return true;
        }
        //If the point is not in any of the parts of the button then
        return false;
        }
}
