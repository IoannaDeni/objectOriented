import java.awt.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This WindiwController class allows both interaction of the user with the program and calls an animated class the BouncingBall. This class has implemented both ActionListener and ChangeListener
 * both of which are defined in the class and allow the swing components to return expected behaviors manippulating the animated object. The swing components are a create button that makes a new ball
 * a color menu that changes the color of the last ball a slide controlling the speed of the ball in the x direction and another one controlling it in the y direction. Also the features of the ball 
 * have set default characteristics, first the ball is black and running at 5, 5 speed.
 * 
 * @author Ioanna Deni
 * @version 4/9/2017
 */
public class ControllerBall extends WindowController implements ActionListener, ChangeListener
{
    // Approximate height of the menu bar added by Java
    private static final int MENU_BAR_HEIGHT = 50;

    // The last ball created and its color are saved becaues the two listeners will need those values passed from one to the other
    private BouncingBall lastBall;
    private Color lastColor;

    // The button the user can click to insert another ball into the canvas.
    private JButton button;

    // A menu that the user can use to select what color the ball displays.
    private JComboBox colorMenu;

    // A slider that is used to give the x speed of the ball.
    private JSlider xSpeedSlider;

    // A slider that is used to give the x speed of the ball.
    private JSlider ySpeedSlider;

    //These variables are taken after the borderLayouts 
    //are created in order to know the x, y coordinates of the rectangle used to create the boundary area in the bounching ball class
    private JPanel northPanel;
    private JPanel southPanel;
    private JPanel westPanel;

    //This is for the boundary region that the constractor requires to bounch the ball of the walls and is found in both action perform and change state methods
    private FramedRect rect;

    /**
     * Create the display.  The Swing components are arranged around objectdraw's canvas.
     */
    public ControllerBall()
    {
        resize (500, 500);

        // Create a vertical slider whose minimum value is 0, maximum value is 100 and
        // initial value is 50.  Place it to the left of the canvas.
        xSpeedSlider = new JSlider (JSlider.VERTICAL, 0, 100, 50);
        westPanel = new JPanel();
        westPanel.add(xSpeedSlider);
        add(westPanel, BorderLayout.WEST);

        // Create a horizontal slider whose minimum value is 0, maximum value is 100 and
        // initial value is 50.  Place it below the canvas.
        ySpeedSlider = new JSlider (JSlider.HORIZONTAL, 0, 100, 50);
        southPanel = new JPanel();
        southPanel.add(ySpeedSlider);
        add(southPanel, BorderLayout.SOUTH);

        // Create a button labeled "Create Ball".
        button = new JButton ("Create Ball");

        // Create a color menu with 3 entries.
        colorMenu = new JComboBox();
        colorMenu.addItem ("black");
        colorMenu.addItem ("red");
        colorMenu.addItem ("green");
        colorMenu.addItem ("blue");

        // Put the menu and button above the canvas.
        northPanel = new JPanel();
        northPanel.add (button);
        northPanel.add (colorMenu);
        add(northPanel, BorderLayout.NORTH);

        // Tell the 4 Swing components that this class is providing the event handlers
        // for those components.
        xSpeedSlider.addChangeListener (this);
        colorMenu.addActionListener(this);
        ySpeedSlider.addChangeListener (this);
        button.addActionListener(this);
    }

    /**
     * Handle events caused by the user clicking the button, or selecting a color using the menu. 
     * @param event information about the user action being handled
     */
    public void actionPerformed (ActionEvent event) {
        // Find out which Swing component the user interacted with
        Object source = event.getSource();

        //Give the variables values after the J compoonents are added in order to know how to construct the boundary rectangle that the ball constructor will use to bounce the ball of
        double height = northPanel.getHeight();
        double width = westPanel.getWidth();
        double bottom = southPanel.getHeight();

        //Here we create the boundaries and set them to white so the canvas looks empty
        double canvasWidth =canvas.getWidth()- width;
        double canvasHeight = canvas.getHeight() - height - bottom;
        rect = new FramedRect (width, height,canvasWidth, canvasHeight, canvas);
        rect.setColor(Color.white);

        // When the user clicks on the button.  Create a new ball on the canvas using the initial speed and color.
        if (source == button) {
            lastBall = new BouncingBall(width, height, canvas, rect, 5, 5);    

            //this sets the default choises
            colorMenu.setSelectedItem("black");
            xSpeedSlider.setValue(50);
            ySpeedSlider.setValue(50);
        }
        // Make the text bold face if the box is checked.
        else if   (source == colorMenu) {
            //In order to change the last ball's color
            if (colorMenu.getSelectedItem().equals("black")) {
                lastBall.color(Color.black);

                lastColor = Color.black;
            }
            else if (colorMenu.getSelectedItem().equals("red")) {
                lastBall.color(Color.red);

                lastColor = Color.red;
            }
            else if (colorMenu.getSelectedItem().equals("green")) {
                lastBall.color(Color.green);

                lastColor = Color.green;
            } 
            else if (colorMenu.getSelectedItem().equals("blue")) {
                lastBall.color(Color.blue);

                lastColor = Color.blue;
            } 
        }
    }

    /**
     * When the user moves the slider, the speed on the x and y axis of the ball change. 
     * @param event Information about the user's interaction with the slider.
     */
    public void stateChanged (ChangeEvent event) {
        //First we get the location of the ball when the slider is chosed
        double x = lastBall.getX();
        double y = lastBall.getY();
        
        //The slider has values from 0 to 100 but we can't have that as teh speed of the ball 
        //so we multiply it by 0.1 to make small and adding one so the ball always moves even slightly when the slider value is 0
        double xSpeed = xSpeedSlider.getValue() * 0.1 + 1; 
        double ySpeed = ySpeedSlider.getValue() * 0.1 + 1;  
        
        //We remove the last ball and create a new one with the same color as the last one and at the same location as the last one with the new speed 
        lastBall.remove();
        lastBall = new BouncingBall(x, y, canvas, rect, xSpeed, ySpeed);
        lastBall.color(lastColor);
    }
}