import javax.swing.JPanel;
import org.w3c.dom.Document;
import binaryTreeBuilders.ParsedBinaryTree;
import datastructures.BinaryTreeNode;
import learner.UpdateGame;

/**
 * This is the logic of the game - it controls the methods that make the game restricted or unrestricted 
 * and the methods that return the question or answer of the tree
 * This is the class that calls the class that parses the xml file and creates the tree.
 * This class is also responsible for manipulating inputs by the user and write another file.
 *  
 * @author Ioanna Deni
 * @version 12/7/2017
 *
 */
public class GameController {
	
	//hold the parsed binary tree of the game
	private ParsedBinaryTree tree;
	
	//holds nodes for reference
	private BinaryTreeNode<String> current;
	

	/**
	 * The constructor calls the class that writes the binary tree from the document that 
	 * it takes as a parameter and sets the root of this tree as the current referenced question
	 * 
	 * @param document
	 */
	public GameController(Document document){
		
		//initiate the tree
		tree = new ParsedBinaryTree();
		
		//parse the tree from the beginning
		tree.parsedTree(document);
		
		//set the current node variable to be the tree root
		current = tree.getRoot();
	}
	
	/**
	 * This method returns all possible leafs of the tree at any instance as strings
	 * 
	 * @return string of leafs
	 */
	public String leafLibrary(){
		
		return tree.leafs(current);}
	
	/**
	 * This method returns the data in type string of the current node
	 * 
	 * @return string of Answer_Question
	 */
	public String getQuestion(){
		
		//retrieves the data of the node and makes it a string in a variable
		String question = current.getData().toString();
		
		return question;}
	
	/**
	 * This method returns always the left child of the binary tree that in the way it is written
	 * it is always the next question or answer of the yes response of the user
	 * 
	 * @return a string 
	 */
	public String getYes(){
		
		//first we are checking if the current node of the tree is empty
		if (current.getLeftChild() != null){
			
			//update the current to the next node
			current = current.getLeftChild();
			
			//if the current is a leaf the return string contains the answer of the user
			if (current.isLeaf()){

				//and return the data retrieved by the current node to a string 
				return "Your country is " + current.getData().toString() + "!";}
			
			//if the next node is not the leaf
			else{
				
				//and return the data retrieved by the current node to a string
				return current.getData().toString();}
		}
		
		//if the next node is empty we have reached the end of the tree so "Game Over"
		return "Game Over";
	}

	/**
	 * This method returns always the right child of the binary tree and in the way it is written
	 * it is always the next question or answer of the no response of the user
	 * 
	 * @return a string 
	 */
	public String getNo(){
		
		//first we are checking if the next node of the tree is empty
		if (current.getRightChild() != null){
			
			//update the current to the next node
			current = current.getRightChild();
			
			//if the current is a leaf the return string contains the answer of the user
			if (current.isLeaf()){
				return "Your country is " + current.getData().toString() + "!";}
			
			//if the next node is not the leaf
			else{
				
				//and return the data retrieved by the current node to a string
				return current.getData().toString();}}
		
		//if the next node is empty we have reached the end of the tree so "Game Over"
		return "Game Over";
	}
	
	/**
	 * This method takes the current node which is the one referenced to 
	 * to be the root of the tree which causes the use to replay the possible pahtways of the tree
	 */
	public void restart(){
		//set the current node variable to be the tree root
		current = tree.getRoot();
	}
	
	/**
	 * This method returns always the right child of the binary tree and in the way it is written
	 * it is either the next question or answer of the no response of the user or calls the class for updating the game (xml tree)
	 * 
	 * @return a string  
	 */
	public String updateNo(JPanel panel, Document document){
		
		//first we are checking if the next node of the tree is empty
		if (current.getRightChild() != null){
					
			//update the current to the next node
			current = current.getRightChild();
			
			//if the current is a leaf the return string contains the answer of the user
			if (current.isLeaf()){
				return "Your country is " + current.getData().toString() + "!";}
			
			//if the next node is not the leaf
			else{
				
				//and return the data retrieved by the current node to a string
				return current.getData().toString();}}
		
		//then we are checking if the current node of the tree has a left child
		if (current.getLeftChild() != null){
			
			//if the current is a leaf
			if (current.getLeftChild().isLeaf()){
				
				//we ask the user to update the game
				new UpdateGame(current, document, tree.getTree());
				
				//these freezes the current game
				panel.setEnabled(false);
				
			return "Game Over";}}
		
		return "Game Over";
	}
}
