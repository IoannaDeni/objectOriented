import java.awt.*;
import objectdraw.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class is responsibe for defining the begin method which builds a 6x6 grid filled with cards 
 * and the handles the events of the mouse so if the mouse hits the button for new game or the cheat buton 
 * here is the code that defines what happens. For the first a new set of cards appears at the same position but shuffled and the cheat button reveals you deck of cards symbols.
 * Further in every first and second mouse click on top of any card causes the cards to turn face up to reveal the character in every third mouse click anywhere on the board 
 * the two characters are compaired and if they are the same they are deleted from the deck and removed from the array else they turn back face down. 
 * 
 * @author Ioanna Deni
 * @version 4/25/2017
 */
public class Concentration extends WindowController implements ActionListener
{
    //This variable holds the size of the header of the window that pops up so we can resize it
    private static final int WINDOW_HEADER_HEIGHT = 50;

    //To set margins around the cards and between hte cards we define the margins
    private static final int MARGIN = 20;

    // The button the user can click to insert another ball into the canvas.
    private JButton newGame;
    private JButton cheat;

    //These variable hold the border location of the panels the buttons are added to
    private JPanel northPanel;

    // Maximum number of cards in the x and y axis
    private static final int MAX_XCARDS = 6;
    private static final int MAX_YCARDS = 6;

    //This variable is the collection of cards
    private CardCollection cardCollection;

    //To keep track of the number of clicks we name the card
    Card card1;
    Card card2;

    // Array to hold all the characters
    private char[] characters;

    /**
     * From the beginning of the program a window will appear with the 36 cards 
     * all reversed and not revealling the letters and buttons available
     */
    public void begin () 
    {
        resize (700, 700);

        // Create the buttons labeled "New Game" and "Cheat".
        newGame = new JButton ("New Game");
        cheat = new JButton ("Cheat");

        // Put the buttons above the canvas.
        northPanel = new JPanel();
        northPanel.add (newGame);
        northPanel.add (cheat);
        add(northPanel, BorderLayout.NORTH);

        // Tell the 2 Swing components that this class is providing the event handlers
        // for those components.
        newGame.addActionListener(this);
        cheat.addActionListener(this);

        //Here we create an empty cardCollection 
        cardCollection = new CardCollection (MAX_XCARDS*MAX_YCARDS);

        //This variable hold the width and height of the cards themselves in relation to the canvas
        int cardWidth = (int)canvas.getWidth()/MAX_XCARDS - 2* MARGIN;
        int cardHeight = (int)canvas.getHeight()/MAX_YCARDS - MARGIN;

        //Here we will create an empty array of characters that are 36
        characters  = new char[36];

        //The array will be made of letters type char starting with a and going all the way up to r (36th letter) since we will have pairs 
        char c = '\u03B1';

        //This loop creates the pairs, fills the arrray
        for (int i=0; i<35; i = i +2){

            //The characters in position i and i+1 will hold the same character
            characters[i] = c;
            characters[i+1] = c;

            //Here we are updating c from a to b form b to c and goes on
            c++;
        }

        //This loop now will shuffle in another loop that can be ass big as we want so 100 can be any value
        for (int i=0; i<100; i++) {

            //first we have two random numbers chosen from our array of organised by pairs characters
            RandomIntGenerator random = new RandomIntGenerator (0, 35);

            //We are saving two random positions positions
            int randomIndex1 = random.nextValue();
            int randomIndex2 = random.nextValue();

            //This variable is temporary holding the character in index randomIndex1 because in next line 
            //we will replace the value with a new value and the value in randomIndex1 will be lost
            char temporary = characters[randomIndex1];

            //Here we switch the values from the one index to the other and the other to the temporary
            characters[randomIndex1] = characters[randomIndex2];
            characters[randomIndex2] = temporary;
        }

        //to define the position of the character that we will give to the card - the position is executive but we don't mind because the characteres are already randomized  
        int index = 0;
        for (int numXCards = 0; numXCards < MAX_XCARDS; numXCards ++) {
            //The one loop goes throught the x columns of the grid
            //While the next loop goes throught the y rows of the grid

            for (int numYCards = 0; numYCards < MAX_YCARDS; numYCards ++) 
            {
                //After defining where the positions of the array are we create a card
                Card card = new Card (numXCards*(cardHeight + MARGIN) + MARGIN, numYCards*(cardWidth + MARGIN) + MARGIN + MARGIN/2, cardHeight,cardWidth, characters[index], canvas);

                //Here we add all those cards inside the array formed by the card collection
                cardCollection.addCard(card, canvas);

                //In order to keep the indexes going forward 
                index = index +1;
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

    /**
     * This method should determine which, if any, card has been
     * clicked on. If the user clicks on a facedown card and there are currently 0 or 1 faceup
     * cards, the card is turned faceup. If the user clicks anywhere with 2 faceup cards,
     * if the cards have the same symbol, they are both removed from the display. If the 2
     * faceup cards have different symbols, they are both turned facedown. 
     * @param  Location point 
     */
    public void onMouseClick(Location point)
    {
        //With one click on top of a card the collection recognizes the specific card 
        //calls the card and makes the specified card reveal the hidden symbol all these kept in a variable

        if (card1==null && card2==null) {
            //First we ge tthe card that contains the point
            card1 = cardCollection.getCardAt (point);

            if (card1!= null){
                //Then we display the symbol - turn the card
                card1.showSymbol();
            }
        }
        else if (card1!=null && card2==null && cardCollection.getCardAt (point)!= card1) {
            //First we ge tthe card that contains the point
            card2 = cardCollection.getCardAt (point);

            if (card2!= null){
                //Then we display the symbol - turn the card
                card2.showSymbol();
            }
        }
        else if (card1!=null && card2!=null)
        {
            //Here we get the symbols that exist on th etwo cards
            char symbol1 = card1.getSymbol();
            char symbol2 = card2.getSymbol();

            if (symbol1 == symbol2){
                //If the user clicks matched cards the cards with the same symbol are removed from the array of cards
                cardCollection.removeCard (symbol1);

                //And here they are removed from the canvas
                card1.removeFromCanvas();
                card2.removeFromCanvas();
            }
            else {
                //If the user clicks unmatched cards they turn face down 
                card1.hideSymbol();
                card2.hideSymbol();
            }

            //The two variables that were saving the two cards are empty again by setting them to null
            card1 = null;
            card2 = null;
        }

    }

    /**
     * This method handles clicks on the buttons. When the user
     * clicks on the Cheat button, the cards should all be turned faceup. The New Game
     * button is extra credit. If the user clicks on it, it should begin a new game with a full
     * grid of facedown cards. It should be possible to click this button at any time. 
     * @param event information about the user action being handled
     */
    public void actionPerformed (ActionEvent event) {
        // Find out which Swing component the user interacted with
        Object source = event.getSource();

        // When the user clicks on the buttons.
        if (source == newGame) 
        {
            //First we clean the canvas
            canvas.clear();

            //Then we create a new empty cardCollection 
            cardCollection = new CardCollection (MAX_XCARDS*MAX_YCARDS);

            //This variable hold the width and height of the cards themselves in relation to the canvas
            int cardWidth = (int)canvas.getWidth()/MAX_XCARDS - 2* MARGIN;
            int cardHeight = (int)canvas.getHeight()/MAX_YCARDS - MARGIN;

            //This loop now will shuffle in another loop that can be ass big as we want so 100 can be any value
            for (int i=0; i<100; i++) {

                //first we have two random numbers chosen from our array of organised by pairs characters
                RandomIntGenerator random = new RandomIntGenerator (0, 35);

                //We are saving two positions
                int randomIndex1 = random.nextValue();
                int randomIndex2 = random.nextValue();

                //This variable is temporary holding the character in index randomIndex1 because in next line 
                //we will replace the value with a new value and the value in randomIndex1 will be lost
                char temporary = characters[randomIndex1];

                //Here we switch the values from the one index to the other and the other to the temporary
                characters[randomIndex1] = characters[randomIndex2];
                characters[randomIndex2] = temporary;
            }

            //to define the position of the character that we will give to the card - the position is executive but we don't mind because the characteres are already randomized  
            int index = 0;
            for (int numXCards = 0; numXCards < MAX_XCARDS; numXCards ++) {
                //The one loop goes throught the x columns of the grid
                //While the next loop goes throught the y rows of the grid

                for (int numYCards = 0; numYCards < MAX_YCARDS; numYCards ++) 
                {
                    //After defining where the positions of the array are we create a card
                    Card card = new Card (numXCards*(cardHeight + MARGIN) + 2*MARGIN, numYCards*(cardWidth + MARGIN) + MARGIN + MARGIN/2, cardHeight,cardWidth, characters[index], canvas);

                    //Here we add all those cards inside the array formed by the card collection
                    cardCollection.addCard(card, canvas);

                    //In order to keep the indexes going forward 
                    index = index +1;
                }
            }
        }
        else if   (source == cheat) 
        {
            //This line calls hte collection with the saved cards and goes through the whole array and shows the hidden symbol
            cardCollection.reveal();
        }
    }
}
