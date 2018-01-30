import java.util.Arrays;

/**
 * This sorter implements the Sorter but it's recursive
 * 
 * @author Ioanna Deni
 * @version 11/8/2017
 *
 */
public class Quicksort implements Sorter{
	
	/** 
	 * Constructor
	 */
	public Quicksort() { 
		// nothing needs to be done
	}
	
	public void sortArrayInPlace( int[] array ){
		
		Sorter (array, 0, array.length);
		
		System.out.println("     (last step): " + Arrays.toString(array));
	}	
		
		private int[] Sorter (int[] array, int low, int high){
			
			//This is the base case where the searchVlue is not found so the program returns -1 
			if (high<2) {
				
				//We print the step we are into and the array as a string
				return array;
				}
			
			else{
				
				//this counters holds the positions 
				int bigCounter = 0;
				int smallCounter = 0;
				int sameCounter = 0;
				
				//this array will hold the values that are bigger and smaller than a value
				int [] smallArray = new int[high];
				int [] bigArray =  new int[high];
				int [] sameArray = new int[high];
				
				//This is a random value of the array and it will be the value we will compare
				int random = array[0];
				
				//for all the array length
				for (int i=0; i<high; i++){
					
					//if the values are bigger than the random value
					if (array[i]>random){
						//we are adding those value to the smallArray array
						bigArray[bigCounter] = array[i]; 
						//update the position
						bigCounter++;
							}
					
					//if the values are smaller than the random value
					if (array[i]<random){
						//we are adding those value to the bigArray array
						smallArray[smallCounter] = array[i]; 
						//update the position
						smallCounter++;
						}
					
					//if the values are the same as the random value
					if (array[i]==random){
						//we are adding those value to the sameArray array
						sameArray[smallCounter] = array[i]; 
						//update the position
						sameCounter++;
					}
				}
				
				smallArray = Sorter(smallArray, 0, smallCounter);
				bigArray = Sorter(bigArray, 0, bigCounter);
				
				int[] newArray = new int[smallArray.length+sameArray.length+bigArray.length-3];
				
				//Filling the array 
				for (int j=0; j<smallArray.length-1; j++){
					
					newArray[j]=smallArray[j];
				}
				
				for (int l=0; l<sameArray.length-1; l++){
					
					newArray[l+smallCounter]=sameArray[l];
				}
				
				for (int k=0; k<bigArray.length-1; k++){
					
					newArray[k+sameCounter+smallCounter]=bigArray[k];
				}
				
				newArray = Sorter(newArray, 0, newArray.length-1);
				
				return newArray;
		}
	}
}
