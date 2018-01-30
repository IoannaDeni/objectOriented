import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used for us to create any kinds of arrays ordered in increasing order
 * and test for any number based to what we would expect it to return.
 * Currently it has a n odd number array and a normal array starting from -10
 * 
 * @author Ioanna Deni
 * @version 9/30/2017
 */

public class BinarySearchTest {
	
	
	//default number of odds to test on
	public static int NUM_ODDS = 100;
	
	// testing array
	private int[] array;
	
	// testing second array
	private int[] secArray;
	
	//empty array - length of zero
	private int[] thirdArray = new int[0];
	
	@Before
	public void initOddsArray() 
	{
		array = createOddsArray( NUM_ODDS );
	}
	
	@Before
	/**
	 * This filles another array with another type of array
	 */
	public void secInitOddsArray()
	{
		secArray = secCreateOddsArray( NUM_ODDS );
	}
	
	
	/**
	 * Create array with first numOdds odd numbers.
	 **/
	public static int[] createOddsArray( int numOdds )
	{
		// array for odd numbers in order
		int[] oddsArray = new int[numOdds];
 
		// current odd number
		int currentOdd = 1;
 
		// fill with odd numbers in order
		for ( int i = 0; i < oddsArray.length; i++ )
		{
			// put in current odd number
			oddsArray[i] = currentOdd;
 
			// update to next odd
			currentOdd += 2;
		}		
 
		return oddsArray;
		}
	
	/**
	 * Create array the first 100 numbers from -10.
	 **/
	public static int[] secCreateOddsArray( int numOdds )
	{
		// array for numbers
		int[] oddsArray = new int[numOdds];
 
		// first number
		int currentOdd = -10;
 
		// fill the array with the order numbers
		for ( int i = 0; i < oddsArray.length; i++ )
		{
			// put in current position equal to the number
			oddsArray[i] = currentOdd;
			
			// update to the number to the next by adding one
			currentOdd += 1;
		}		
 
		return oddsArray;
		}
	
	@Test
	public void test26()
	{
		// check searching for 26
		assertEquals("Searching for 26 in an array of the first 100 odds should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(array, 26)); 	
	}
 
	@Test
	public void test13()
	{
		// check searching for 13
		assertEquals("Searching for 13 in an array of the first 100 odds should give 6", 
				6, // correct answer
				BinarySearch.binarySearch(array, 13)); 	
	}
	
	@Test
	public void test78()
	{
		// check searching for 78
		assertEquals("Searching for 78 in an array of the first 100 odds should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(array, 78)); 	
	}
	
	@Test
	public void test100()
	{
		// check searching for 100
		assertEquals("Searching for 100 in an array of the first 100 odds should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(array, 100)); 	
	}
	
	@Test
	public void test186()
	{
		// check searching for 186
		assertEquals("Searching for 186 in an array of the first 100 odds should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(array, 186)); 	
	}
	
	@Test
	public void test99()
	{
		// check searching for 99
		assertEquals("Searching for 99 in an array of the first 100 odds should give 49", 
				49, // correct answer
				BinarySearch.binarySearch(array, 99)); 	
	}
	
	@Test
	public void test101()
	{
		// check searching for 101
		assertEquals("Searching for 101 in an array of the first 100 odds should give 50", 
				50, // correct answer
				BinarySearch.binarySearch(array, 101)); 	
	}
	
	@Test
	public void test177()
	{
		// check searching for 177
		assertEquals("Searching for 177 in an array of the first 100 odds should give 88", 
				88, // correct answer
				BinarySearch.binarySearch(array, 177)); 	
	}
	
	@Test
	public void testMinus5()
	{
		// check searching for -5
		assertEquals("Searching for -5 in an array of 100 numbers strarting from -10 should give 5", 
				5, // correct answer
				BinarySearch.binarySearch(secArray, -5)); 	
	}
	
	@Test
	public void test1()
	{
		// check searching for 1
		assertEquals("Searching for 1 in an array of 100 numbers strarting from -10 should give 11", 
				11, // correct answer
				BinarySearch.binarySearch(secArray, 1)); 	
	}
	
	@Test
	public void test3()
	{
		// check searching for 3
		assertEquals("Searching for 3 in an array of 100 numbers strarting from -10 should give 13", 
				13, // correct answer
				BinarySearch.binarySearch(secArray, 3)); 	
	}
	
	@Test
	public void test4()
	{
		// check searching for 4
		assertEquals("Searching for 4 in an array of 100 numbers strarting from -10 should give 14", 
				14, // correct answer
				BinarySearch.binarySearch(secArray, 4)); 	
	}
	
	@Test
	public void testMinus12()
	{
		// check searching for -12
		assertEquals("Searching for -12 in an array of 100 numbers strarting from -10 should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(secArray, -12)); 	
	}
	
	@Test
	public void testMinus100()
	{
		// check searching for -100
		assertEquals("Searching for -100 in an array of 100 numbers strarting from -10 should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(secArray, -100)); 	
	}
	
	@Test
	public void test200()
	{
		// check searching for 200
		assertEquals("Searching for 200 in an array of 100 numbers strarting from -10 should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(secArray, 200)); 	
	}
	
	@Test
	public void test210()
	{
		// check searching for 210
		assertEquals("Searching for 210 in an array of 100 numbers strarting from -10 should give -1", 
				-1, // correct answer
				BinarySearch.binarySearch(secArray, 210)); 	
	}
	
	@Test
	public void test10()
	{
		// check searching for 10
		assertEquals("Searching for 10 in an array of empty positions", 
				-1, // correct answer
				BinarySearch.binarySearch(thirdArray, 10)); 	
	}
	
	}
