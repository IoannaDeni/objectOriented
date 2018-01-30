import java.awt.*;
import objectdraw.*;

/**  
 * This class allows manipulation from the user. It draws the initial race of the four mascots of Moho and with the users click 
 * another class is called so the mascots race in different random speeds
 * 
 * Ioanna Deni 
 * Monday 27 March 2017
 */

public class RacingMohos extends WindowController
{
    //These variables will hold the pictures that are loaded for the first window were they aren't racing and so they can be passed as parameters later
    private Picture lion;
    private Picture pegasus;
    private Picture griffin;
    private Picture sphinx;

    //This variable holds the size of the header of the window that pops up so we can resize it
    private static final int WINDOW_HEADER_HEIGHT = 50;

    //These instance static variables are for the lenght of the lines and the window which is like the one of the lines plus the text
    private static final  int LINE_LENGHT = 800;
    private static final int WINDOW_HEIGHT = 560;

    //This variable is for the the space between the mascots and the lines as well as the lines and the window size and the lines and the text
    private static final int MARGIN = 20; 

    //These instance variables are given values in begin method but are used in other methods too
    private int left;
    private int topG;
    private int topL;
    private int topP;
    private int topS;
    private Text text;

    //These variables will hold the visible pictures that are loaded so they can be used later on teh mouseClick method
    private VisibleImage visibleP;
    private VisibleImage visibleL;
    private VisibleImage visibleG;
    private VisibleImage visibleS;

    /**
     * From the beginning of the program a window will appear with the pictures and the racing lines
     */
    public void begin () 
    {
        //First we load the pictures into the instance variables defined above
        griffin = new Picture ("http://www.mtholyoke.edu/~blerner/green_griffin.jpg");
        lion = new Picture ("http://www.mtholyoke.edu/~blerner/lion.png");
        pegasus = new Picture ("http://www.mtholyoke.edu/~blerner/pegasus.png");
        sphinx = new Picture ("http://www.mtholyoke.edu/~blerner/sphinx.png");

        //To get the width and height of the image in order to adjast the left and top variables of where the images will be placed 
        int getHeight = griffin.getHeight();
        int getWidth = griffin.getWidth();

        // We have set the size of the window that we want to have to specific values to broaden it 
        resizeCanvas (LINE_LENGHT + (MARGIN*2), WINDOW_HEIGHT);

        //These lines will build the horizontal racing lines
        new Line (MARGIN, MARGIN*2 + getHeight, LINE_LENGHT, MARGIN*2 + getHeight, canvas);
        new Line (MARGIN, MARGIN*4 + getHeight*2, LINE_LENGHT, MARGIN*4 + getHeight*2, canvas);
        new Line (MARGIN, MARGIN*6 + getHeight*3, LINE_LENGHT, MARGIN*6 + getHeight*3, canvas);

        //These lines will build the vertical racing lines
        new Line (getWidth + MARGIN*2, MARGIN, getWidth + MARGIN*2, getHeight*4 + MARGIN*8, canvas);
        new Line (LINE_LENGHT -getWidth - MARGIN*2, MARGIN, LINE_LENGHT - getWidth - MARGIN*2, getHeight*4 + MARGIN*8, canvas);

        //Here we give values to left and top variables of every picture so we can use them in the other methods
        left = LINE_LENGHT -getWidth - MARGIN;
        topG = MARGIN;
        topL = MARGIN*3 + getHeight;
        topP = MARGIN*5 + getHeight*2;
        topS = MARGIN*7 + getHeight*3;

        //To display the images
        visibleG = griffin.createVisibleImage(left, topG, canvas);
        visibleL = lion.createVisibleImage(left, topL, canvas);
        visibleP = pegasus.createVisibleImage(left, topP, canvas);
        visibleS = sphinx.createVisibleImage(left, topS, canvas);

        //Now the text is manipulated to look better
        text = new Text ("Racing Mohos", LINE_LENGHT/2, topS + MARGIN + getHeight, canvas);
        Font font = new Font("Jokerman", Font.PLAIN, 35);
        text.setFont(font);
        Color fontColor = new Color (180, 0, 255);
        text.setColor(fontColor);
        double width = text.getWidth();
        text.moveTo(LINE_LENGHT/2 - width/2, topS + MARGIN + getHeight);
    }

    /**
     * Changes the size of the canvas.
     * @param width the desired width
     * @param height the desired height
     */
    private void resizeCanvas (double width, double height){
        resize ((int) width, (int) height + WINDOW_HEADER_HEIGHT);
    }

    /**
     * On one mouse click create the mascots and start the race
     * After that mouse clicks do nothing.
     * @param point where the user clicked.
     */
    public void onMouseClick (Location point) {
        //First we remove the pictures that are already drawn on the canvas
        visibleG.removeFromCanvas();
        visibleL.removeFromCanvas();
        visibleP.removeFromCanvas();
        visibleS.removeFromCanvas();

        // In order to make this run only once then we set
        int x=1;

        // where the user clicked.
        if (x==1) {
            //Nwo we call the mascot class for its mascot in the new lane
            Mascot lionM = new Mascot (left, topL, lion, canvas, MARGIN);
            Mascot pegasusM = new Mascot (left, topP, pegasus, canvas, MARGIN);
            Mascot griffinM = new Mascot (left, topG, griffin, canvas, MARGIN);
            Mascot sphinxM = new Mascot (left, topS, sphinx, canvas, MARGIN);

            //Here we set x to 2 so the code is repeated only once
            x=2;
        }
    }
}
