import java.util.Arrays;

/** 
 * BubbleSorter class implements the Sorter interface.
 * @author ponbarry
 * Modified: 9/13/2017 by Ioanna Deni
 */
public class BubbleSorter implements Sorter {

	/** 
	 * Constructor
	 */
	public BubbleSorter() { 
		// nothing needs to be done
	}
	
	/**
	 * Uses the bubble sort algorithm to modify the passed-in array
	 * so that its elements are in ascending, sorted order.
	 * Prints out the current state of array each time any two 
	 * elements swap places. 
	 * Assumes that the passed-in array is an array of int elements.
	 */
	public void sortArrayInPlace(int[] array) {
		//we create two instances one to check each position of the array and one that decreases the
		//length of the array once the biggest number has been found
		int a=1;
		//this local variable will hold the second number (the big one)
		int i = 0;
		//this local variable holds the position of each position of the array
		while (i < (array.length-a)){
			//for all the position of the length of the array check if the pair is in the right order
			if (array[i+1] < array[i]){
				//we have a temporary holder for our smaller value if the first value isn't the smaller
				int value1 = array[i+1];
				//if the second value is larger we assign the small value to the second value's position
				array[i+1] = array[i];
				//and the second value's position we give the value we have saved which is the smaller
				array[i] = value1;
				}
			//now we increase i so we can move to the next position of the array
			i++;
			//when reaching the last position of the array
			if (i == array.length-a){
				//we reset the i to zero
				i = 0;
				//and decrease the length by one
				a++;
			//Thus we return to the loop to execute the sorting for the smaller length till a==length	
			}
			//We print the step we are into and the array as a string
			System.out.println("     (step ):" + Arrays.toString(array));
		}
	}
}

