package binaryTreeBuilders;
import org.w3c.dom.*;
import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * This class is designed based on the code of lab 10 and assignment 7 combining reading an xml file and 
 * building a binary tree based on the Nodes of the xml file.
 * 
 * @author Ioanna Deni
 * @version 12/9/2017
 *
 */
public class ParsedBinaryTree{
	
	//These are all the necessary instances to fill a binary tree with the parsed 
	public DefaultBinaryTree<String> tree = new DefaultBinaryTree<String>();
	public DefaultBinaryTreeNode<String> root;
	
	/**
	 * The constructor does nothing the tree is already initiated
	 */
	public ParsedBinaryTree(){
	}
	
	/**
	 * This method starts the recursive parsing by taking the root of the document 
	 * and calling the method that is recursive which returns a DefaultBinaryTreeNode node
	 * 
	 * @param document
	 */
	public DefaultBinaryTree<String> parsedTree( Document document ){
		
		//getting the root of the document in type Node
		Node docRoot =  document.getDocumentElement();
		
		//the recursion happens here and the root in type DefaultBinaryTreeNode is saved
		root = parseNode(docRoot);
		
		//here we set the root node of the DefaultBinaryTree to be equal with what was returned after the recursion
		tree.setRoot(root);
		
		//return the tree
		return tree;
	}
	

	/**
	 * This methods selects the desired information 
	 * and prints the values of text to have the desired design
	 * 
	 * @param n
	 */
	private DefaultBinaryTreeNode<String> parseNode(Node n){
		
		//first we build a DefaultBinaryTreeNode node
		DefaultBinaryTreeNode<String> questionNode = new DefaultBinaryTreeNode<String>();
		
		//if the node type Node is an element (we remove possible non desired text like #text)
		if( n.getNodeType() == Node.ELEMENT_NODE){
	
			//we get only the element
			Element currentElt = (Element)n;
			
			//If it's a question Node
			if (currentElt.getNodeName().equals("question")){
				
				//the question nodes have attributes that need to be returned as strings which are done by 
				//the Answer_Question class
				Answer_Question answer = parseQElement(currentElt);
				
				// set the data of the DefaultBinaryTreeNode node to the return value type string 
				questionNode.setData(answer.toString());
			}
			
			//If it's a answer Node
			else if (currentElt.getNodeName().equals("answer")){
				
				//set the data of the DefaultBinaryTreeNode node to the return value type string 
				questionNode.setData(n.getTextContent());
			}
		}
		
		//if the node type Node is an element has branches/leaves
		if (n.hasChildNodes()){
			
			//we create a list of them to keep track of them
			NodeList list = n.getChildNodes();
			
			//we look at all their branches separately
			for (int i = 0; i < list.getLength(); i++){
				
				Node node = list.item(i);
				
				//if they are elements (we remove possible non desired text like #text)
				if( node.getNodeType() == Node.ELEMENT_NODE ){
			
					//First we look at the left child of the node and if it is empty
					if (questionNode.getLeftChild() == null){
						
						//we set the left child to be the root to another two branched tree made by the recursion 
						questionNode.setLeftChild(parseNode(node));
					}
					
					//if the left child is not empty we fill the right child of the node 
					else if (questionNode.getLeftChild() != null){
						
						//we set the right child to be the root to another two branched tree made by the recursion 
						questionNode.setRightChild(parseNode(node));
					}
				}
			}
		}
		
		//return the root
		return questionNode;
	}

	/**
	 * This continues the parsing of the question attributed nodes and separates them
	 * in answerYes answerNo nodes and also calls the class that returns the context of those nodes
	 * 
	 * @param an element
	 * @return the context of the element
	 */
	private Answer_Question parseQElement(Element q){
		
		//the context is a string
		String attribute = "";
		
		//first check if the node is answerYes
		if (q.hasAttribute("answerYes")){
			
			//sets the attribute to the context of the node
			attribute = q.getAttribute("answerYes");
			
			//returns the context of the node
			return new Answer_Question(attribute);
		}
		//we check if the node is answerNo
		else if (q.hasAttribute("answerNo")){
			
			//sets the attribute to the context of the node
			attribute = q.getAttribute("answerNo");
			
			//returns the context of the node
			return new Answer_Question(attribute);
		}
		
		//returns null if the previous conditions aren't met
		return null;
		}
	
	/**
	 * This method returns the tree that has been filled with the xml content
	 * 
	 * @return tree
	 */
	public DefaultBinaryTree<String> getTree(){
		return tree;
	}
	
	/**
	 * This method returns the root of the parsed tree
	 * 
	 * @return root
	 */
	public DefaultBinaryTreeNode<String> getRoot(){
		return root;
	}
	
	/**
	 * This method returns a string containing all possible answers/leafs of the tree
	 * 
	 * @param root of the tree
	 * @return string of possible answers
	 */
	public String leafs(BinaryTreeNode<String> root){
		
		//calls a method in DefaultBinaryTree class by giving it a root to start
		return tree.leafsList(root);
	}
}
