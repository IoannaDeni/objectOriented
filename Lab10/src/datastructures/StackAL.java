package datastructures;
/**
 * 
 * This class allows the manipulation of a stack of type ArrayList.
 * 
 * @author Ioanna Deni
 * @version 10/31/2017
 *
 * @param <T>
 */

public class StackAL<T> implements Stack<T>{
	
	private List<T> list = new ArrayList<T>();
	
	public StackAL(){
		
	}
	
	/**
	 * Pushes an element onto the top of the stack.
	 */
	public void push( T data ){
		
		//If the stack is empty you store the data at index 0
		if (isEmpty()){
			list.add(0, data);
		}
		
		//else put it on top which is as big as the size 
		list.add(list.size(), data);
	}
 
	/**
	 * Removes the top of the stack and returns it.
	 * @return the popped data
	 */
	public T pop(){
		
		//We get the last element which is at index size minus 1
		T lastElement = list.get(list.size()-1);
		
		//We delete the element
		list.delete(list.size()-1);
		
		//and return it
		return lastElement;
	}
 
	/** 
	 * Gets the element at the top of the stack without removing it.
	 * @return the peeked data
	 */
	public T peek(){
		
		//We get the last element which is at index size minus 1
		T lastElement = list.get(list.size()-1);
		
		return lastElement;
	}
 
	/** 
	 * Tests if the stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty(){
		if (list.isEmpty()){
			return true;
		}
		return false;
	}
 
	/** 
	 * Returns a String representation of the stack.
	 * @return stack as String
	 */
	public String toString(){
		return list.toString();
	}
	
}
