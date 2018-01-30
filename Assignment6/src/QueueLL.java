/**
 * 
 * This class allows the manipulation of a queue of type LinkedList.
 * Code borrowed from Assignment5
 * 
 * @author Ioanna Deni
 * @version 11/12/2017
 *
 */

public class QueueLL<T> implements Queue<T>{
	
	private List<T> list = new LinkedList<T>();
	
	public QueueLL(){
		
	}
	
	/**
	 * adds an element on the end of the queue.
	 */
	public void enqueue( T data ){
		
		//put it on end of the queue which is at index as big as the size 
		list.add(list.size(), data);
	}
 
	/**
	 * Removes the first item on the queue and returns it.
	 * @return the popped data
	 */
	public T dequeue(){
		
		//We get the first element which is at index 0
		T element = null;
		
		if (list.get(0) != null){
			element = list.get(0);
			
			//We delete the element
			list.delete(0);
		}
		
		//and return it
		return element;
	}
 
	/** 
	 * Gets the element at the front of the queue without removing it.
	 * @return the peeked data
	 */
	public T peek(){
		
		//We get the first element which is at index 0
		T element = list.get(0);
		
		return element;
	}
 
	/** 
	 * Tests if the queue is empty.
	 * @return true if the queue is empty
	 */
	public boolean isEmpty(){
		if (list.isEmpty()){
			return true;
		}
		return false;
	}
 
	/** 
	 * Returns a String representation of the queue.
	 * @return stack as String
	 */
	public String toString(){
		return list.toString();
	}
	
	/** 
	 * Returns the size of the queue.
	 *
	 */
	public int size(){
		return list.size();
	}
	

}

