import objectdraw.*;
import java.awt.*;

/**
 * Shoots off fireworks with a short time delay between each
 * 
 * @author Barbara Lerner
 * @version November 2007
 */
public class Finale extends ActiveObject
{
    // The number of fireworks in the finale
    private static final int NUM_IN_FINALE = 25;
    
    // Used to generate a random color for the firework.  The red & green components are
    // bright while the blue component is dark.  This is done to make it more likely that
    // the color will stand out against the sky background.
    private RandomIntGenerator brightColorGenerator;
    private RandomIntGenerator darkColorGenerator;
    
    // The random number generator used to determine the size of the firework.
    private RandomIntGenerator sizeGenerator = new RandomIntGenerator (25, 75);
    
    // The random number generators used to determine a location for each firework during the finale.
    private RandomIntGenerator xGenerator;
    private RandomIntGenerator yGenerator;

    // The portion of the screen to draw on
    private DrawingCanvas finaleCanvas;
    
    // The length of time between shooting each firework
    private static final int DELAY = 250;
    
    /**
     * Create the finale and start it shooting fireworks
     * @param brightColorGen used to generate a bright value when creating a color
     * @param darkColorGen used to generate a dark value when creating a color
     * @param sizeGen used to generate the size of the next firework
     * @param canvas the canvas to draw on
     */
    public Finale(RandomIntGenerator brightColorGen, RandomIntGenerator darkColorGen,
                  RandomIntGenerator sizeGen, DrawingCanvas canvas )
    {
        brightColorGenerator = brightColorGen;
        darkColorGenerator = darkColorGen;
        sizeGenerator = sizeGen;
        xGenerator = new RandomIntGenerator (0, canvas.getWidth());
        yGenerator = new RandomIntGenerator (0, canvas.getHeight());
        finaleCanvas = canvas;
        start();
    }

    /**
     * Shoot multiple fireworks with a time delay between each
     */
    public void run() {
        // Count how many fireworks have been created in the finale.
        int finaleCount = 0;
        
        // Stop when we reach the number we want to shoot
        while (finaleCount < NUM_IN_FINALE) {
            // Draw the next firework at a random location.
            Color nextColor = new Color (brightColorGenerator.nextValue(),
                                     brightColorGenerator.nextValue(),
                                     darkColorGenerator.nextValue());
            new Firework (new Location (xGenerator.nextValue(), yGenerator.nextValue()), nextColor, 
                          sizeGenerator.nextValue(), finaleCanvas);
            pause (DELAY);
            
            // Increase the counter so that the while loop will eventually end.
            finaleCount++;
        }
        
    }
}
