import java.awt.*;
import objectdraw.*;

/**
 * The CardCollection class manages the entire collection of cards. 
 * It is very similar to the BalloonCollection class in the HotAirBallonCollection 
 * example that we did in class. This class keeps the entire collection of cards in an array.
 * 
 * @author Ioanna Deni
 * @version 4/25/2017
 */
public class CardCollection 
{
    // Array to hold all the cards
    private Card[] cards;

    // Number of cards currently in the 2Darray 
    private int numCards = 0;

    /**
     * Constructor for CardCollection that creates an array 
     * 
     * @param int for the x direction 
     * @param int for the y direction
     * @param a canvas
     */
    public CardCollection(int size) 
    {
        //First we create the array based on the information that the constractor returns
        cards = new Card[size];
    }

    /**
     * Create a cards and put it into the next slot of the array.
     * Make sure there is enough space first.
     */
    public void addCard (Card card, DrawingCanvas canvas) {
        
        //For as long as the card number is smaller than the actual defined lenght of the array the position which is empty
        //is filled with a card 
        if (numCards < cards.length) {
            
            //The card that fills the position is represented by an index which is happening with order so first card is card[1] 
            cards[numCards] = card;

            //Now we add the newCard to the array of cards
            numCards++;
        }
    }

    /**
     * This method goes over all cards and swapps them to reveal their leter.
     */
    public void reveal () {
        //First all the indexes as checked
        
        for (int i = 0; i < numCards; i++) {
            
            //For every single index the card that is the same as the card that the reveal method is 
            //called on is chosen to showSymbol a method that reveals the character of the specific card 
            cards[i].showSymbol();
        }
    }

    /**
     * This method finds a card at a particular location
     */
    public Card getCardAt (Location point) {
        
        //First all the indexes as checked
        for (int i = 0; i < numCards; i++) {
            
            //For every single index the card contains method checkes wether the specific card contain that point
            if (cards[i] != null && cards[i].contains (point)) {
                
                //The index of the specific card that contains that point is returned
                return cards[i];
            }
        }
        
        //If the user clicked outside all cards then null is returned and nothing happens
        return null;
    }

    /**
     * This method removes a particular card from the collection 
     */
    public void removeCard (char symbol) {
        
        //To remove them from the canvas first we go through the array to figure out which one is chosen
        for (int i = 0; i < numCards; i++) {
            
            //For every single index the card position that isn't empty and the cards in the two position that contain that character loaded in the method are chosen 
            if (cards[i] != null && cards[i].getSymbol() == symbol) {
                 
                //The chosen position are set to null which means empty
                cards[i] = null;
            }
        }
    }
}

