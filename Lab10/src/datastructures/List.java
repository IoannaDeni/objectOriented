package datastructures;

/**
 * List interface for simplest ADT of sequentially stored data with changing length.
 * 
 * @author astjohn
 *
 * @param <T> generics are used
 * 
 */
public interface List<T> {
 
	/**
	 * Add (insert) data at specific index in list,
	 * e.g., add( 0, data ) inserts data to front/head of list
	 * 
	 * @param index - the position 
	 * @param data - the information
	 */
	public void add( int index, T data );
 
	/**
	 * Get data stored at specific index in list.
	 * 
	 * @param index - the position
	 * @return the information
	 */
	public T get( int index );
 
	/**
	 * Delete data at specific index in list,
	 * e.g., delete( 0 ) removes the first element from the list
	 * 
	 * @param index - the position
	 */
	public void delete( int index );
 
	/**
	 *  Get the number of elements in this list. 
	 *  
	 * @return the size
	 */
	public int size();
 
	/**
	 * Check if the list is empty.
	 * 
	 * @return true or false
	 */
	public boolean isEmpty();
}
