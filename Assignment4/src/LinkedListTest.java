import static org.junit.Assert.*;

/**
 * This test class contains test for the linked list class.
 * Description for each test is provided just before the test.
 * 
 * @author Ioanna Deni
 * @version 10/31/2017
 */

import org.junit.Test;

public class LinkedListTest {
	
	private LinkedList<String> myStringList;

	/**
	 * This test creates an empty list thus when tested for empty true is expected
	 * and size zero is expected too
	 */
	@Test
	public void testEmptyList() {
		myStringList = new LinkedList<String>();
		
		assertTrue(myStringList.isEmpty());
		assertEquals(0, myStringList.size());
		
	}
	/**
	 * This test evaluates the add method where the list is not empty
	 * false is expected for that and the size is as much as the additions
	 */
	@Test
	public void testAdd() {
		myStringList = new LinkedList<String>();
		
		myStringList.add(0, "a");
		myStringList.add(0, "b");
		
		
		assertFalse(myStringList.isEmpty());
		assertEquals(2, myStringList.size());
	}
	/**
	 * This test proves that if the get method is tested for a not empty list at a position 
	 * outside the list null is returned
	 */
	@Test
	public void testGetWrongly() {
		myStringList = new LinkedList<String>();
		
		myStringList.add(0, "a");
		
		assertFalse(myStringList.isEmpty());
		assertEquals(1, myStringList.size());
		assertEquals(null, myStringList.get(4));
	}
	/**
	 * This test shows that in a initiated list with values when get is on a actual valid position 
	 * the data at this position are returned as strings
	 */
	@Test
	public void testGet() {
		myStringList = new LinkedList<String>();
		
		myStringList.add(0, "a");
		
		assertFalse(myStringList.isEmpty());
		assertEquals(1, myStringList.size());
		assertEquals("a", myStringList.get(0));
	}
	/**
	 * This test proves that in an initiated list when the add method is called in an index 
	 * far outside the size of the list, the add method just adds on the end of the list
	 */
	@Test
	public void testAddWrongly() {
		myStringList = new LinkedList<String>();
		
		myStringList.add(0, "a");
		myStringList.add(3, "a");
		
		assertFalse(myStringList.isEmpty());
		assertEquals("a", myStringList.get(0));
		assertEquals("a", myStringList.get(1));
	}
	
	/**
	 * This test tries to show that the additions on the same index just push the rest of the indexes further down.
	 * Also it shows that when an element is deleted the node is still so the size is still there but the node is skipped. 
	 */
	@Test
	public void testAddManyDelete() {
		myStringList = new LinkedList<String>();
		
		myStringList.add(0, "a");
		myStringList.add(0, "v");
		myStringList.add(0, "a");
		myStringList.add(3, "l");
		myStringList.add(4, "k");
		myStringList.add(5, "k");
		myStringList.delete(2);
		
		assertFalse(myStringList.isEmpty());
		assertEquals("k", myStringList.get(4));
		assertEquals("k", myStringList.get(3));
		assertEquals("l", myStringList.get(2));
		assertEquals("a", myStringList.get(1));
		assertEquals("a", myStringList.get(0));
		assertEquals(5, myStringList.size());
	}

}
