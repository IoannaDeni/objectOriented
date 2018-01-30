package learner;
import org.w3c.dom.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;

/**
 * This class pops up a new window and allows the user to enter information to expand the game.
 * The game is expanded by reading the information of the user and expanding the tree
 * 
 * @author Ioanna Deni
 * @version 12/9/2017
 */
public class UpdateGame implements KeyListener {
	
	//the frame of the window and the document
	private JFrame frame;
	private Document document;
	
	//the current node and root of the expansion of the tree is saved here as well as the tree
	private BinaryTreeNode<String> root;
	private DefaultBinaryTree<String> tree;
	
	//this is where the user input will be saved
	private JTextArea answer;
	
	/**
	 * The constructor creates a new frame with panels for instruction and user input
	 */
	public UpdateGame(BinaryTreeNode<String> root, Document document, DefaultBinaryTree<String> tree){
		
		//saving the root, the document and the tree
		this.root = root;
		this.document = document;
		this.tree = tree;
		
		//creating a new window to pop up
		frame = new JFrame("Help us improve the game!");
	
		//Create a panel to hold all information
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		//organize the panel in a border layout way
		panel.setLayout(new BorderLayout());
		
		//the instructions and the question
		JLabel instructions = new JLabel("This game couldn't guess your country, help it!",  SwingConstants.CENTER);
		instructions.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			
		JLabel question = new JLabel("Please type your country!",  SwingConstants.CENTER);
		question.setFont(new Font("Times New Roman", Font.ITALIC, 35));
		
		//this is the area that the user will input the country
		answer = new JTextArea();
		answer.setText("i.e. Albania - press Enter");
		answer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		answer.addKeyListener(this);
		
		//adding the information to the panel
		panel.add(instructions, BorderLayout.NORTH);
		panel.add(question, BorderLayout.CENTER);
		panel.add(answer, BorderLayout.SOUTH);
		
		//adding the panel to the frame
		frame.add(panel);
		
		//editing the frame to look nice be on the right position and be of the right size
		frame.setBackground(Color.WHITE);
		frame.setSize(400, 200);
		frame.setResizable(false); 
		frame.setAlwaysOnTop(true); 
		frame.setLocation(300, 150);;
		frame.setVisible(true); 	
	}
	
	/**
	 * This method reads the input of the user and modifies the already existed nodes
	 *  
	 */
	private void updateTree(){
		
		//if the user inputed characters
		if (!answer.getText().isEmpty()){
			
			//the input is retrieved
			String newInput = answer.getText();
			
			//the question node changes to include the new input
			root.setData(root.getData() + " Or " + newInput + "?");
			
			//the child node of the question which is the answer
			BinaryTreeNode<String> child = root.getLeftChild();
			
			//also changes to include the new input
			child.setData(child.getData() + " or " + newInput);
			
			//the new frame is closed and a new game can begin
			frame.dispose();
		}
	}
	
	/**
	 * Handles the key typed event.
	 * @param e
	 */
	@Override
	public void keyTyped(KeyEvent e){
		
	}
	
	/**
	 * Handles the key-released event.
	 * Code borrowed from Tetris part3
	 * 
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e){
	
		//"KeyCode" is the enum of the key that was pressed
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_ENTER){
			//Here we are updating the xml file
			updateTree();
	    }
	}
	
	/**
	 * Handles the key-pressed event.
	 * 
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e){
	}

}
