import java.util.Arrays;

/** 
 * InsertionSorter class implements the Sorter interface.
 * @author ponbarry
 * Modified: 9/12/2017 by Ioanna Deni
 */
public class InsertionSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public InsertionSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the insertion sort algorithm to modify the passed-in array
	 * so that its elements are in ascending, sorted order.
	 * Prints out the current state of array for each iteration (each 
	 * time the index marking the "sorted" section of the array is updated). 
	 * Assumes that the passed-in array is an array of int elements.
	 */
	public void sortArrayInPlace(int[] array) {
		//Now we split the array into parts, sorted and unsorted but we do that every time we select a position.
		for (int i=0; i < (array.length); i++) {
			//for the elements before this element (the sorted elements)
			for  (int n=0; n<=i; n++) {
				//if the current position holds a bigger elements
				if (array[n] > array[i]){
					
					int temp = array[i] ;
					
					//if the first value is larger we assign the second value to the first value's position 
					array[i] = array[n];
					//and the second value's position we give the value we have saved which is the smaller
					array[n] = temp;
				}
		}
		//We print the step we are into and the array as a string
		System.out.println("     (step " + (i) + "):" + Arrays.toString(array));
		
		}
	}	
}
	
