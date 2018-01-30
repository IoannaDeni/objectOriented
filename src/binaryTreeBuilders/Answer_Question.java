package binaryTreeBuilders;
/**
 * This class specifies the T data of the tree as a unique object Answer_Question and 
 * defines method to return these objects as type string
 * 
 * @author Ioanna Deni 
 * @version 12/9/2017
 *
 */
public class Answer_Question {
	
	//the variable holding all information
	private String attribute;
	
	/**
	 * the constructor to fill the private variable
	 * 
	 * @param attribute
	 */
	public Answer_Question(String attribute){
		//setting the variable equal to the instance variable of the class
		this.attribute = attribute;
	}
	
	/**
	 * Method that returns a string containing the content of the variable as string.
	 */
	public String toString(){
		return attribute;
	}

}
