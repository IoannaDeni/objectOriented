import java.awt.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * This class is the only class that extends WindowController and thus it is held responsible for drawing the starting screen and defining the methods for the event handlers.
 * The starting screen or else begin method draws the background and makes available to the user the different buttons that can be clicked to build buildings or turn all the light on or off.
 * On every click this class contains a method that interprets where the user clicked and if it is on top of any window the color is changed else if it is on the buttons
 * then if a build highrise button is clicked the program will build another building up to five, if the turn on button is clicked all windows will become yellow and if the turn off button is clicked all windows will become black.
 * 
 * @author (Ioanna Deni) 
 * @version (Monday 1 May 2017)
 */

public class HighRiseController extends WindowController implements ActionListener
{
    // These RGB values are found on line and represent the colors for the background for the sky and the ground
    private static final Color GROUND_COLOR = new Color(139,69,19);
    private static final Color SKY_COLOR = new Color(0,0,204);

    // Size of the window for the initial display
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 700;

    // Location of ground relative to the window size
    private static final int GROUND_SIZE = 150;
    private static final int GROUND_TOP = WINDOW_HEIGHT - GROUND_SIZE;

    //This variable holds the size of the header of the window that pops up so we can resize it
    private static final int WINDOW_HEADER_HEIGHT = 50;

    // The three button that are available on the starting screen for the user to click to insert another building into the canvas or turn on or off all lights in all the building on the canvas.
    private JButton TurnOn;
    private JButton TurnOff;
    private JButton Build;

    //These variable hold the border location of the panels the buttons are added to
    private JPanel southPanel;

    //This variable is the collection of buildings that is initially established in the begin method and used in all others
    private HighRise[] collection;

    //These variables hold the maximun number of buuildings available for the user the maximun number of windows in each building and finally the total of all windows in all buildings 
    private static final int MAX_BUILDINGS = 5;
    private static final int WINDOW_BUILDING = 8;
    private static final int MAX_WINDOWS = MAX_BUILDINGS * WINDOW_BUILDING;

    //This variable holds the number of current buildings on the screen
    private int numBuildings;

    /**
     * From the beginning of the program a window will appear with the sky and the ground and the available buttons 
     */
    public void begin () 
    {
        // We have set the size of the window that we want to have to specific values to broaden it 
        resizeCanvas (WINDOW_WIDTH, WINDOW_HEIGHT);

        // First we draw a rectangle to be the grass and set it to its color
        FilledRect ground = new FilledRect (0, GROUND_TOP, canvas.getWidth(), canvas.getHeight() - GROUND_TOP, canvas);
        ground.setColor (GROUND_COLOR);

        //Then we draw another rectangle to fill the area that the sky takes and set that to its color
        FilledRect sky = new FilledRect (0, 0, canvas.getWidth(), GROUND_TOP, canvas);
        sky.setColor (SKY_COLOR);

        // Create the buttons and label them as they are going to appear on the canvas.
        TurnOn = new JButton ("Turn lights on");
        TurnOff = new JButton ("Turn lights off");
        Build = new JButton ("Build highrise");

        // Put the buttons in the border panel and then the panel below the canvas.
        southPanel = new JPanel();
        southPanel.add (TurnOn);
        southPanel.add (TurnOff);
        southPanel.add (Build);
        add(southPanel, BorderLayout.SOUTH);

        // Tell the 3 Swing components that this class is providing the event handlers for those components.
        TurnOn.addActionListener(this);
        TurnOff.addActionListener(this);
        Build.addActionListener(this);

        //Here we create an empty collection as big as the total of all buildings
        collection = new HighRise [MAX_BUILDINGS];

    }

    /**
     * This method should determine which, if any, window has been
     * clicked on. If the user clicks on a turned off light window the window becomes yellow else if the user clicks on a turned on light window the window becomes black 
     * @param  Location point 
     */
    public void onMouseClick(Location point)
    {

        //We go through all buildings and see if the user clicked on top of any of them
        for (int i = 0; i < numBuildings; i++) {

            //if he did click on top then we go on seeing if the user clicked on top of a window
            if (collection[i]. contain(point))
            {

                //so now we call the method switch that will change the light state of the window the user clicked on
                collection[i].lightSwitch(point);

            }
        }

        //If any of those conditions are false nothing happens
    }

    /**
     * This method handles the events that occur when the user clicks on one ofthe three buttons.
     * @param event information about the user action being handled
     */
    public void actionPerformed (ActionEvent event) {
        // Find out which Swing component the user interacted with
        Object source = event.getSource();

        // When the user clicks on the turnOn button.
        if (source == TurnOn) 
        {
            for (int i = 0; i < numBuildings; i++) {
                //then all the windows on the collection of the windows are turned on no matter what color they were before by calling this method defined in the HighRise class
                collection[i].turnOn();
            }
        }
        // When the user clicks on the turnOff button.
        else if (source == TurnOff) 
        {
            for (int i = 0; i < numBuildings; i++) {
                //then all the windows on the collection of the windows are turned off no matter what color they were before by calling this method defined in the HighRise class
                collection[i].turnOff();
            }
        }
        // When the user clicks on the build button.
        else if (source == Build)
        {

            //To have only 5 buildings we create a conditional that will check if they are less than five buildings every time we run the program
            if (numBuildings < collection.length)
            {
                //Here we are creating the building and adding it to the collection 

                HighRise building = new HighRise (GROUND_TOP, WINDOW_WIDTH, canvas); 

                //The building that fills the position is represented by an index which is happening with order so first building is collection[1] 
                collection[numBuildings] = building;

                //Now we add the new building to the array of buildings
                numBuildings++;

            }
        }
    }

    /**
     * Changes the size of the canvas.
     * @param width the desired width
     * @param height the desired height
     */
    private void resizeCanvas (double width, double height){
        resize ((int) width, (int) height + WINDOW_HEADER_HEIGHT);
    }
}