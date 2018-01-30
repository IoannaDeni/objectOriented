import java.awt.*;
import objectdraw.*;

/**
 * The Card class defines an individual card composed of a rectangle with a given collor and a character that 
 * is either shown on the canvas or hidden. This class also defines methods that show the character in a card 
 * or remove it from the canvas or hides the character when it  "turns" so other classes can call these methods. 
 * 
 * @author Ioanna Deni
 * @version 4/25/2017
 */
public class Card
{
    //This variables hold the sized of the card 
    private static final int CARD_HEIGHT = 500/6;
    private static final int CARD_WIDTH = CARD_HEIGHT / 2;

    //This variables hold the actual card and symbol and pattern of the card so they can be used in another methods
    private FilledRect card;
    private Text text;
    private char symbolParameter;

    //This variables will hold the position of the text shown or hidden 
    double textLeft;
    double textTop;

    // Colors for the card when it is face down
    private static final Color CARD_COLOR = Color.GRAY;
    
    // Colors for the card when it is face down
    private static final Color DARK_CARD = CARD_COLOR.darker();

    /**
     * Constructor for Card that creates a rectangle 
     * at the left and top coordinates of the card, 
     * with the symbol to display on the card, on  the canvas. 
     * 
     * @param double for left and top coordinates 
     * @param str symbol to be displayed on the card
     * @param a canvas
     */
    public Card(double left, double top, int height, int width, char symbol, DrawingCanvas canvas) 
    {
        //This objectDraw constractor will make a card like rectangle
        card = new FilledRect (left, top, height, width, canvas);
        
        //Set the color to the color used for turn face down
        card.setColor(DARK_CARD);
        
        //This saves the symbol so at the getSymbol method the character loaded is returned
        symbolParameter = symbol;
        
        //Here we set the symbol to a text and make the text appear in a specific font and size
        text = new Text (symbol, left, top, canvas);
        Font font = new Font("Times New Roman", Font.PLAIN, 40);
        text.setFont(font);

        textLeft = left+width/2 - text.getWidth()/2 ;
        textTop = top+height/2  - text.getHeight()/2;
        
        //Here we set the text to a specified location based on the width of the card and the height of the card
        //and the width and height of the character - text after modifications so it can be centered
        text.moveTo (textLeft, textTop);
        
        
        //We hide the text so the card looks face downyards
        text.hide();
    }

    /**
     * This method should display the symbol, making it appear that the card is faceup. 
     */
    public void showSymbol () {
        //This line makes the card a lighter color so it looks better aesthetically 
        card.setColor(CARD_COLOR);

        //This line shows the hidden text.
        text.show();
    }

    /**
     * This method determines if the user clicked on a card when it's called on the controller
     */
    public boolean contains (Location point) {
        
        //The rectangle which is named card with the character which is named text are returning true - meant 
        //they have been clicked on when the rectangle or the text do contain the point
        if (card.contains (point) || text.contains (point)) {
            return true;
        }

        //else false is return and nothing happens
        return false;
    }

    /**
     * This method should return the symbol displayed on the card 
     */
    public char getSymbol () {
        
        //The saved parameter holding the character is returned
        return symbolParameter;
    }

    /**
     * This method should display the symbol, making it appear that the card is faceup. 
     */
    public void hideSymbol () {
        //This line makes the card a dark color so it looks like it turned 
        card.setColor(DARK_CARD);

        //This line hides the text.
        text.hide();
    }

    /**
     * This method should remove the card and its symbol from the canvas. 
     */
    public void removeFromCanvas () {
        
        //Both the card and the rectangle are removed from canvas with objectDraw methods
        card.removeFromCanvas();
        text.removeFromCanvas();
    }
}
