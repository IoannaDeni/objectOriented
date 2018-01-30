package datastructures;
/** 
 * This class contains the method definitions for a linked list. 
 * Written for Assignment4
 * @author Ioanna Deni
 * @version 11/1/2017
 *
 * @param <T> - generics are used
 */
public class LinkedList<T> implements List<T> {
	
	private LinkedListNode<T> head;
	
	/**
	 * The constructor does nothing.
	 * 
	 */
	public LinkedList(){
		
	}
	
	/**
	 * Add (insert) data at specific index in list,
	 * e.g., add( 0, data ) inserts data to front/head of list
	 **/
	public void add( int index, T data ){
		
		//If the list hasn't been initiated before and the index is zero we create the head.
		if (head == null){
			head = new LinkedListNode<T>();
			head.setData(data);
		}
		else {
			//if the list has been initiated the head is the first
			LinkedListNode<T> current = head;
			//iterate through the nodes before the desired index
			for (int i = 1; i < index; i++){
				//if the node has a next we change it
				if (current.getNext() != null){
					current = current.getNext();
				}				
			}
			
			//if the node doesn't have a next then we add on the end of the last nod
			LinkedListNode<T> newAddition = new LinkedListNode<T>();
			newAddition.setData(data);
			//updating the new node to direct to the next
			newAddition.setNext(current.getNext());
			//updating the previous node to direct to the new
			current.setNext(newAddition);
		}
	}
	
	/**
	 * Get data stored at specific index in list.
	 **/
	public T get(int index){

		T data = null;
		
		LinkedListNode<T> current = null;
		
		//if the index is invalid null is returned
		if (index==0 && head!=null){
			data = head.getData();
			}
		
		else if (head != null){
			//if the head is not null so data exist in our list
			current = head;
			//we iterate through the indexes before the desired index
			for (int i=0; i<index; i++){
				
				//if any of them is null then that is returned
				if (current.getNext() == null){
					return null;
				}
				//we update the variable to move to the next index
				current = current.getNext();
			}
			//and we return the data saved in the specific index
			data = current.getData();
		}
		return data;
	}
	
	
	/**
	 * Delete data at specific index in list,
	 * e.g., delete( 0 ) removes the first element from the list
	 **/
	public void delete( int index ){
		LinkedListNode<T> current = head;
		//if the index is bigger then the size or the list is empty an exception is thrown
		if (index > size() || head==null){
			//do nothing
		}
		//Constructed the following statement with lots of help from Amy
		
		//if the head is the only think on the stack then set that to null
		else if (head.getNext()==null){
			head=null;
		}
		else if (index ==0){
			
			//This is to catch the case where we change the head in the queue
			head = head.getNext();
		}
		
		//if the head is not null so data exist in our list
		else if (current != null){
			//we iterate through the indexes one node before the  desired index
			for (int i=1; i<index; i++){
				//if the current node has a next node 
				if (current.getNext()!= null ){
					//the current node is set to the next node 
					current = current.getNext();
				}
			}
			//we set the current node to skip the next and have the second next as a pointer in order to skip the "deleted" element
			current.setNext(current.getNext().getNext());
		}
	}
	
	/**
	 * Get the number of elements in this list.
	 **/
	public int size(){
		int size = 0;
		//we set a counter and a head
		LinkedListNode<T> current = head;
		//as long as the nodes are not null we update the counter
		while (current!=null){
			current = current.getNext();
			size ++;
		}
		return size;
	}
	
	/**
	 * returns the head
	 * @return the head
	 */
	public LinkedListNode<T> getFirstNode(){
		
		if (head != null){
			return head;
		}
		
		return null;
	}
	
	/**
	 * Check if the list is empty.
 	 **/
	public boolean isEmpty(){
		//if the size is bigger than zero then the list has values
		if (size()>0){
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a String representation of this node.
	 */
	public String toString(){
		
		String myList = "";
		
		//we set a counter and a head
		LinkedListNode<T> current = head;
		
		while (current!= null){
			
			//as long as the nextValue is not null the string is elongated 
			myList +=  current.getData().toString() + ", ";
			current = current.getNext();
		}

		return myList;
	}
}