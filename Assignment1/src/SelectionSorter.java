import java.util.Arrays;

/** 
 * SelectionSorter class implements the Sorter interface.
 * @author ponbarry
 * Modified: 9/12/2017 by Ioanna Deni
 */
public class SelectionSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public SelectionSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the selection sort algorithm to modifies the passed-in 
	 * array so that its elements are in ascending, sorted order.
	 * Prints out the current state of array for each iteration (each 
	 * time the index marking the "sorted" section of the array is updated).
	 * Assumes that the passed-in array is an array of int elements.
	 */
	public void sortArrayInPlace(int[] array) {
		//Now we split the array into two parts, sorted and unsorted.
		
		for (int i=0; i < (array.length-1); i++) {
			//We go through the array to find the smallest number
			for (int n=i+1; n<array.length; n++){
				//we have a temporary holder for our smaller value if the first value isn't the smaller
				if (array[n]< array[i]){
					int value = array[n];
					//if the first value is larger we assign the second value to the first value's position 
					array[n] = array[i];
					//and the second value's position we give the value we have saved which is the smaller
					array[i] = value;
				}
				//if the second value isn't smaller the function isn't executed 
			}
			//We print the step we are into and the array as a string
			System.out.println("     (step " + (i+1) + "): " + Arrays.toString(array));
		}
	}
}
