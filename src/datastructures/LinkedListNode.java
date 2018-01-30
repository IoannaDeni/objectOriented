package datastructures;
/**
 * This class creates nodes. Pointers with values and direction.
 * Generic types are used so this class can be used for all types of data.
 * Written for Assignment4
 * @author Ioanna Deni
 * @version 11/1/2017
 *
 * @param <T> - generics are used
 */
public class LinkedListNode<T> {
	
	private LinkedListNode<T> nextValue = null;
	
	private T dataSet;
	
	/**
	 * The constructor that does nothing.
	 */
	public LinkedListNode (){
	}

	
	/**
	 * Set the data stored at this node.
	 * 
	 * @param data - the information
	 */
	public void setData( T data ){
		dataSet = data;
	}
	 
	/**
	 * Get the data stored at this node.
	 * 
	 * @return the information
	 */
	public T getData(){
		return dataSet;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 * 
	 * @param node - the position
	 */
	public void setNext( LinkedListNode<T> node ){
		nextValue=node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 * 
	 * @return the node
	 */
	public LinkedListNode<T> getNext(){
		return nextValue;
	}

}
