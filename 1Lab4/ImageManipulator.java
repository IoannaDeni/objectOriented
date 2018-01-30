import java.awt.*;
import objectdraw.*;

/**
 * This  
 * 
 * @author (Ioanna Deni) 
 * @version (Monday 20 February 2017)
 */

public class ImageManipulator extends WindowController
{
    //This variable will hold the picture that we loaded for that program
    private Picture picture;
    private VisibleImage visibleImage;

    //These variables are for the lenght of the window that contains the picture and the buttons
    private static final int MARGIN = 5; //I use this for both the space between the buttons and the margins of the image and theh window
    private Button buttonGray;
    private Button buttonMirror;
    private Button buttonOriginal;
    private Button buttonBlur;
    private static final int WINDOW_HEADER_HEIGHT = 50;
    private static final int BUTTON_HEIGHT = 70;

    // Location where last drag started
    private Location lastPoint;

    //Instant variable that are given values in begin method but are used in other methods too
    private int getHeight;
    private int getWidth;
    private int left;
    private int top;
    private double buttonLeft;

    /**
     * From the beginning of the program a window will appear with the picture and the buttons
     */
    public void begin () 
    {
        picture = new Picture ("http://www.mtholyoke.edu/~blerner/SnickersInSnow2.jpg");

        //To get the width and height oof the image in order to adjast teh window size
        getHeight = picture.getHeight();
        getWidth = picture.getWidth();

        // We have set the size of the window that we want to have to specific values to broaden it 
        resizeCanvas (getWidth, getHeight + BUTTON_HEIGHT);

        //Where to put the image - instant variables
        left = 0;
        top = BUTTON_HEIGHT; 

        //To display the image
        visibleImage = picture.createVisibleImage(left, top, canvas);

        //To display the buttons
        buttonGray = new Button (MARGIN, MARGIN, "Gray", canvas);
        buttonLeft = buttonGray.getRight()+ MARGIN*2;

        buttonMirror = new Button (buttonLeft , MARGIN, "Mirror", canvas);
        buttonLeft = buttonLeft + buttonMirror.getRight() + MARGIN;

        buttonOriginal = new Button (buttonLeft, MARGIN, "Original", canvas);
        buttonLeft = buttonLeft + buttonOriginal.getRight() + MARGIN;

        buttonBlur = new Button (buttonLeft, MARGIN, "Blur", canvas);

    }

    /**
     * Changes the size of the canvas.
     * @param width the desired width
     * @param height the desired height
     */
    public void resizeCanvas (double width, double height){
        resize ((int) width, (int) height + WINDOW_HEADER_HEIGHT);
    }

    /**
     * On each mouse click creates a new hot air balloon located where the user clicks.
     * @param point where the user clicked.
     */
    public void onMouseClick (Location Point){
        //I didn't put the remove.image outside the if statements because then if the user clicks outside the poxes he'll see a white canvas
        //While now nothing will happen if he doesn't click on the buttons

        if (buttonGray.contains (Point)) {
            //To save memory and remove the colored picture to set the new picture on the background
            visibleImage.removeFromCanvas();

            //in order to call the gray function
            turnGray(); 
        } 

        if (buttonMirror.contains (Point)) {
            //To save memory and remove the colored picture to set the new picture on the background
            visibleImage.removeFromCanvas();

            //in order to call the mirror function
            mirror(); 
        }

        if (buttonOriginal.contains (Point)) {
            //To save memory and remove the colored picture to set the new picture on the background
            visibleImage.removeFromCanvas();

            //to redraw the original image
            picture = new Picture ("http://www.mtholyoke.edu/~blerner/SnickersInSnow2.jpg");

            //To display the image
            visibleImage = picture.createVisibleImage(left, top, canvas);
        }

        if (buttonBlur.contains (Point)) {
            //To save memory and remove the colored picture to set the new picture on the background
            visibleImage.removeFromCanvas();

            //in order to call the blur function
            blur(); 
        }

        //Saves the exact coordinates of the mouse to the variable 
        lastPoint = Point;
    }

    /**
     * Constructor for the method of turnGray that is making each picture gray 
     * @param is  a picture
     */
    private void turnGray()
    {
        //First we need instant variables to set the while loop 
        int row = top; 
        while (row <= getHeight-1){
            int col = 0;
            while (col <= getWidth-1){
                //We save each color of a pixel to the variable pixel
                Color pixel = picture.getPixel (row, col);

                //We save each color of each pixel in different instant variables
                int pixelRed = pixel.getRed ();
                int pixelGreen = pixel.getGreen ();
                int pixelBlue = pixel.getBlue();

                //Calculate average gray for each pixel
                int gray = (pixelRed + pixelGreen + pixelBlue)/3;
                Color colorGray = new Color (gray, gray, gray);

                //creating the new pictures
                picture.setPixel(row, col, colorGray);

                //Updating the col so it keeps moving to all of the columns in a row
                col = col +1;
            }

            //Updating the row so it keeps moving down to all of the width of the picture
            row = row +1;
        }

        //To redisplay the image
        visibleImage = picture.createVisibleImage(left, top, canvas);
    }

    /**
     * Constructor for the method of mirror that flips the picture 
     * @param is  a picture
     */
    private void mirror()
    {
        //First we create a blank picture

        Picture mirrorPicture = new Picture (getWidth, getHeight);

        //Then we need instant variables to set the while loop 
        int row = 0; 
        while (row <= getHeight-1){
            int col = 0;
            while (col <= getWidth -1 ){
                //We save each color of a pixel to the variable pixel
                Color pixel = picture.getPixel (row , col);

                //creating the new pictures reversing the colors
                mirrorPicture.setPixel(row, getWidth - col - 1, pixel);

                //Updating the col so it keeps moving to all of the columns in a row
                col = col +1;
            }

            //Updating the row so it keeps moving down to all of the width of the picture
            row = row +1;
        }

        //To save the new picture in the picture instant variable
        picture = mirrorPicture;

        //To redisplay the image
        visibleImage = picture.createVisibleImage(left, top, canvas);
    }

    /**
     * Constructor for the method of blur that makes the picture less detailed 
     * @param is  a picture
     */
    private void blur()
    {
        //First we create a blank picture

        Picture blurPicture = new Picture (getWidth, getHeight);

        //Then we need instant variables to set the while loop 
        int row = 0; 
        while (row <= getHeight-1){
            int col = 0;
            while (col <= getWidth -1 ){
                //We save each color of a pixel to the variable pixel
                Color pixel = picture.getPixel (row , col);

                //creating the new pictures out of pixelboxes
                blurPicture.setPixel(row, col, pixel);
                blurPicture.setPixel(row, col+1, pixel);
                blurPicture.setPixel(row+1, col, pixel);
                blurPicture.setPixel(row+1, col+1, pixel);
                blurPicture.setPixel(row-1, col-1, pixel);
                blurPicture.setPixel(row-1, col, pixel);
                blurPicture.setPixel(row, col-1, pixel);

                //Updating the col so it keeps moving to all of the columns in a row
                col = col +2;
            }

            //Updating the row so it keeps moving down to all of the width of the picture
            row = row +2;
        }

        //To save the new picture in the picture instant variable
        picture = blurPicture;

        //To redisplay the image
        visibleImage = picture.createVisibleImage(left, top, canvas);
    }
}
