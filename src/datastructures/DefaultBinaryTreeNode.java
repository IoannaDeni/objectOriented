package datastructures;
/**
 * This class creates the tree nodes. Pointers with values and direction (left or right child).
 * Generic types are used so this class can be used for all types of data.
 * @author Ioanna Deni
 * @version 11/24/2017
 *
 * @param <T> - generics are used
 */
		
public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T>{
	
	//These are all the instances that are necessary for this class
	private T currentData;
	private BinaryTreeNode<T> leftChild;
	private BinaryTreeNode<T> rightChild;
	
	/**
	 * The constructor sets all the values to null (even though java does that as a default).
	 */
	public DefaultBinaryTreeNode(){
		currentData = null;
		leftChild = null;
		rightChild = null;
	}
	
	  /**
	   * Get the data stored at this node.
	   * @return Object data.
	   */
	  public T getData(){
		  
		  return currentData;
	  }

	  /**
	   * Set the data stored at this node.
	   */
	  public void setData(T data){
		  
		  currentData = data;
	  }

	  /**
	   * Get the left child.
	   * @return BinaryTreeNode that is left child,
	   * or null if no child.
	   */
	  public BinaryTreeNode<T> getLeftChild(){
		  return leftChild;
	  }

	  /**
	   * Get the right child.
	   * @return BinaryTreeNode that is right child,
	   * or null if no child.
	   */
	  public BinaryTreeNode<T> getRightChild(){
		  return rightChild;
	  }

	  /**
	   * Set the left child.
	   */
	  public void setLeftChild( BinaryTreeNode<T> left ){
		  leftChild = left;
	  }

	  /**
	   * Set the right child.
	   */
	  public void setRightChild( BinaryTreeNode<T> right ){
		  rightChild = right;
	  }

	  /**
	   * Tests if this node is a leaf (has no children).
	   * @return true if leaf node.
	   */
	  public boolean isLeaf(){
		  if (getLeftChild() == null && getRightChild() == null){
			  return true;}
		  return false;
	  }


}
