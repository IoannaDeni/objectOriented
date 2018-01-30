import java.util.Arrays;

/** 
 * The main class in SorterTester tests your implementations of 
 * three different sorting algorithms. For each algorithm, it
 * will create an int array, print the array, instantiate one of the
 * three Sorter objects (InsertionSorter, SelectionSorter, or BubbleSorter),
 * call that object's sortArrayInPlace method on the array, 
 * and then print the array again.
 * Updated: 1/19/16
 * @author ponbarry
 */

public class SorterTester {

	private static final int ARRAY_LEN = 8;
	private static final int MAX_VALUE = 10;
	
	/**
	 * generateRandomIntArray is a helper method. Given an integer
	 * value as input, it returns an int array of that length, 
	 * where each array element is a random int.
	 */
	private static int[] generateRandomIntArray(int length) {
		
		int[] randomNumberArray = new int[length];
		for (int i=0; i < length; i++) {
			randomNumberArray[i] = (int)(Math.random() * MAX_VALUE) + 1;
		}
		return randomNumberArray;
	}

	/**
	 * generateFixedIntArray is a helper method. It returns an array
	 * that has the same elements each time it is called.
	 * Use this method if you want to compare, step-by-step, the 
	 * differences between two sorting algorithms.
	 * You can call this method as an alternative to calling
	 * generateRandomIntArray in main (below).
	 * fixedArray can be set to any values that you choose to test.
	 */ 
	private static int[] generateFixedIntArray() {
		int[] fixedArray = { 0, 1, 0, 7, 5 }; 
		return fixedArray;
	}
	
	/**
	 * main is the method that is executed when a user runs:
	 *     java SorterTester
	 * from the command line.
	 */
	public static void main(String[] args) {
		
		int[] testArray1 = generateRandomIntArray(ARRAY_LEN); 
		int[] testArray2 = generateRandomIntArray(ARRAY_LEN); 
		int[] testArray3 = generateRandomIntArray(ARRAY_LEN); 
		int[] testArray4 = generateRandomIntArray(ARRAY_LEN); 
				
		// Testing INSERTION SORT
		System.out.println("=== INSERTION SORT ===");
		System.currentTimeMillis();
		System.out.println("testArray1 (before): " + Arrays.toString(testArray1));	
		Sorter mySorter = new InsertionSorter();
		mySorter.sortArrayInPlace(testArray1);		
		System.out.println("testArray1 (after): " + Arrays.toString(testArray1));	
		System.currentTimeMillis();
				
		// Testing SELECTION SORT
		System.out.println("\n=== SELECTION SORT ===");	
		System.currentTimeMillis();
		System.out.println("testArray2 (before): " + Arrays.toString(testArray2));
		mySorter = new SelectionSorter();
		mySorter.sortArrayInPlace(testArray2);		
		System.out.println("testArray2 (after): " + Arrays.toString(testArray2));
		System.currentTimeMillis();
				
		// Testing BUBBLE SORT
		System.out.println("\n=== BUBBLE SORT ===");
		System.currentTimeMillis();
		System.out.println("testArray3 (before): " + Arrays.toString(testArray3));		
		Sorter mySorter3 = new BubbleSorter();
		mySorter3.sortArrayInPlace(testArray3);		
		System.out.println("testArray3 (after): " + Arrays.toString(testArray3));
		System.currentTimeMillis();
		
		// Testing Quicksort SORT
		System.out.println("\n=== QUICK SORT ===");	
		System.currentTimeMillis();
		System.out.println("testArray4 (before): " + Arrays.toString(testArray4));		
		Sorter mySorter4 = new Quicksort();
		mySorter4.sortArrayInPlace(testArray4);		
		System.out.println("testArray4 (after): " + Arrays.toString(testArray4));
		System.currentTimeMillis();
	}
}
