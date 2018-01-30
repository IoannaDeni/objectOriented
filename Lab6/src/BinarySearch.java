/** 
 * Main application for the binarySearch algorithm.
 * 
 * Command line usage:
 * 
 * To create a single tree painting:
 *     java -cp bin TreeApplication
 *     
 * To create a collage of five seasons of tree paintings:
 *     java -cp bin TreeApplication seasons  
 *     	
 * @author Ioanna Deni
 * @version 9/30/2017
 **/

public class BinarySearch {
	
	/** 
	 * We initiate the program and call the method oddTester.
	 * The goal of this program is to test whether the searchValues or the array created in oddTester as tester
	 * search for them in an array of the  first 100 numbers and return -1 if not found or the index found on the array of odd numbers if found.
	 **/
	
	public static void main( String[] args )
	{
		oddTester();
	}
	
	/** 
	 * Searches the sorted array for the test int. 
	 * Assumes the array is sorted in increasing order (smallest at index 0).
	 * If test is found, returns its index; otherwise, returns -1.
	 **/
	public static int binarySearch( int[] sorted, int test )
	{
		// start the recursion between first and last indices
		return binarySearch( sorted, test, 0, sorted.length -1 );
	}
	
	/** 
	 * Searches the sorted array for the test number between loIndex and hiIndex, inclusive. 
	 * Assumes the array is sorted in increasing order (smallest at index 0).
	 * If test is found, returns its index; otherwise, returns -1.
	 **/
	private static int binarySearch( int[] sorted, int test, int loIndex, int hiIndex ){
		
		//This is the base case where the searchVlue is not found so the program returns -1 
		if (hiIndex < loIndex) {
			return -1;}
		// If the searchValue is inside our range we calculate the midpoint
		//If the search value is the midpoint we return its index which is the midpoint
		//Else if the searchValue is higher than the end point we recall the method by giving it the value of the lowIndex as the one of the mid value plus 1
		//or else we call the method by giving it the value of the highIndex as the one of the mid value minus 1 
		else{
			int mid = (hiIndex + loIndex)/2;
			
			if (sorted[mid] == test){
				return mid;
			}
			else if (test > sorted[mid]){
				
				return binarySearch(sorted, test, mid+1, hiIndex);}
			else {
				
				return binarySearch(sorted, test, loIndex, mid -1);}
		}
	}
	
	/** 
	 * This method will allow the formation of an array of the first 100 odd numbers.
	 * We fill this array with odd numbers by finding the multiples of twos and adding one
	 * The as instructed we have the searchValues in another array and we call the method binarySearch for all it's values 
	 * passing the method our array of odd numbers and each of our searchValues number.
	 * Then we print the results. 
	 **/
	
	public static void oddTester(){
		
		int [] array = new int[100];
		
		for(int i=0; i<array.length ;i++){
			array[i] = (i*2) +1;}
		
		int [] testerValues = {26, 78 ,100, 186, 13, 99, 101, 177}; 
		
		for (int i=0; i<testerValues.length; i++){
			
			int result = binarySearch(array,testerValues[i]);
			
			System.out.println("searching for " + testerValues[i] + ": " + result);}
		}
}


