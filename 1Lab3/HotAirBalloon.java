import java.awt.*;
import objectdraw.*;

/**
 * This is a contructor for objects of class HotAirBalloon draws all the parts of a hot air balloon
 * as a whole and can be called in other classes too. It also defines what happens to the whole structure when method .move and contains is called. 
 * 
 * @author (Ioanna Deni) 
 * @version (Monday 13 February 2017)
 */
public class HotAirBalloon
{
    // Initial locations and sizes of the different parts of the hot air balloon
    private static final int BALLOON_HEIGHT = 100;
    private static final int BALLOON_WIDTH = 100; 
    private static final int LINE_SIZE = 75;
    private static final int BASKET_HEIGHT = 25;
    private static final int BASKET_WIDTH = 25;
    private static final int SACK_HEIGHT = 15;
    private static final int SACK_WIDTH = 5;
    private static final int SACK_LEFT = BASKET_WIDTH/SACK_WIDTH; 
    private Text text;
    
    //Now we will define the parts of the train
    private FilledOval balloon;
    private Line string1;
    private Line string2;
    private FilledRect basket;
    private FilledRect sand1;
    private FilledRect sand2;
    private FramedOval frame; 
    
    //For colors of the parts of the balloon
    private static final Color BASKET_COLOR = new Color(161, 120, 41);
    private static final Color BASKET_DARK = BASKET_COLOR.darker(); 
    private static final Color SAND1_COLOR = Color.ORANGE;
    private static final Color SAND1_DARK = SAND1_COLOR.darker();
    private static final Color SAND2_COLOR = Color.ORANGE;
    private static final Color SAND2_DARK = SAND2_COLOR.darker();

    /**
     * Constructor for objects of class HotAirBalloon draws all the parts of a hot air balloon
     * as a whole. The parameters the location the balloon will be draw the LEFT and TOP 
     * and which is the canvas and in which y direction it will move up and down
     */
    public HotAirBalloon(double left, double top, DrawingCanvas canvas)
    {
        // This is for random color we call the random number generator (no restriction 0-255)
        RandomIntGenerator colorGen = new RandomIntGenerator (0, 255);
        
        // Generate the RGB values
        int redness = colorGen.nextValue();
        int blueness = colorGen.nextValue();
        int greenness = colorGen.nextValue();
        
        //Draw the strings that hold the balloon which are set to black already - draw them first so if they are not completely touching the balloon
        //or if they are over the area of the balloon the cover and colored balloon covers these imperfections
        string1 = new Line (left + BALLOON_WIDTH/20, top + BALLOON_HEIGHT/2 + BALLOON_HEIGHT/4, left + BALLOON_WIDTH/2 - BASKET_WIDTH/2, top + BALLOON_HEIGHT + LINE_SIZE, canvas);
        string2 = new Line (left + BALLOON_WIDTH - BALLOON_WIDTH/20, top + BALLOON_HEIGHT/2 + BALLOON_HEIGHT/4, left + BALLOON_WIDTH/2 + BASKET_WIDTH/2, top + BALLOON_HEIGHT + LINE_SIZE, canvas);
        
        //Draw the basket
        basket = new FilledRect(left + BALLOON_WIDTH/2 - BASKET_WIDTH/2, top + BALLOON_HEIGHT + LINE_SIZE, BASKET_WIDTH, BASKET_HEIGHT, canvas);
        basket.setColor(BASKET_COLOR);
        
        //Draw the balloon
        balloon = new FilledOval (left, top, BALLOON_WIDTH, BALLOON_HEIGHT, canvas);
        
        //Give the balloon a random color
        Color balloonColor = new Color (redness, greenness, blueness);
        balloon.setColor (balloonColor);
        
        //Drawing the sand sacks
        sand1 = new FilledRect(left + BALLOON_WIDTH/2 - BASKET_WIDTH/2 + SACK_LEFT, top + BALLOON_HEIGHT + LINE_SIZE, SACK_WIDTH, SACK_HEIGHT, canvas);
        sand2 = new FilledRect(left + BALLOON_WIDTH/2 - BASKET_WIDTH/2 + SACK_LEFT*2 + SACK_WIDTH, top + BALLOON_HEIGHT + LINE_SIZE, SACK_WIDTH, SACK_HEIGHT, canvas); 
        
        //To set the color of the sand sacks to orange because sand is orange
        sand1.setColor(SAND1_COLOR);
        sand2.setColor(SAND2_COLOR);
        
        //This is to include the balloon in a frame so if the color is similar to the background it can still be distinquished 
        //Also it is drawn after the balloon so it is on top
        frame = new FramedOval (left, top, BALLOON_WIDTH, BALLOON_HEIGHT, canvas);
        
        //Draw the text last so it can appear on top of the other shapes
        text = new Text ("MHC", left + 13, top + 30, canvas);
        
        //Now the text is manipulated to look better
        Font font = new Font("Jokerman", Font.PLAIN, 35);
        text.setFont(font);
        Color fontColor = new Color ((255 - redness), (255 - greenness), ( 255 -  blueness));
        text.setColor(fontColor);

    }

    /**
     * Here we define what happens when point in somewhere on top of the hot air balloon
     * @param point the location to check for containment 
     */
    public boolean contains(Location point)
    {
        //if the point is contained in the area forming the hot air balloon then each part moves independently but as a whole
        
        if (balloon.contains (point)) {
            return true;
        }
        else if (basket.contains (point)){
            return true;
        }
        else if (sand1.contains (point) ){
            return true;
        }
        else if (sand2.contains (point) ){
            return true;
        }
        
        //If the point is not in any of the parts of the hot air balloon then
        return false;
        }
        
    /**
     * Here we define what happens when the method move is called for the hot air balloon
     * @param dx the distance to move right
     * @param dy the distance to move down 
     */
    public void move (double dy)
    {
       //Each part moves independently but as a whole 
       balloon.move (0, dy);
       frame.move (0, dy);
       text.move (0, dy);
       sand1.move(0, dy);
       sand2.move (0, dy);
       string1.move (0, dy);
       string2.move (0, dy);
       basket.move (0, dy); 
    }
    
    /**
     * Here we define what happens when the method darken is called for the hot air balloon
     */
    public void darker ()
    {
       //Each part darkens  independently but as a whole 
       Color brightColor = balloon.getColor();
       balloon.setColor(brightColor.darker());
       Color fontColor = text.getColor();
       text.setColor(fontColor.darker());
       sand1.setColor(SAND1_DARK);
       sand2.setColor(SAND2_DARK);
       basket.setColor(BASKET_DARK);
    }
    
    /**
     * Here we define what happens when the method lighten is called for the hot air balloon
     */
    public void lighter ()
    {
       //Each part darkens  independently but as a whole 
       sand1.setColor(SAND1_COLOR);
       sand2.setColor(SAND2_COLOR);
       basket.setColor(BASKET_COLOR);
       Color darkColor = balloon.getColor();
       balloon.setColor(darkColor.brighter());
       Color fontColor = text.getColor();
       text.setColor(fontColor.brighter());
    }
}



