
public class Factorials {
	/**
	 * Uses recursion to calculate the factorial of n
	 */
	public static int factorial( int n )
	{
	    if ( n == 0 ) // base case
	    {
	        return 1;
	    }
	    else  // recursive case
	    {
	        // Get the factorial of n - 1
	        int nextFactorial = factorial( n - 1 );
	 
	        // factorial of n is n times factorial of n - 1
	        return n * nextFactorial;
	    }
	}
	 
	/**
	 *  Main method for testing recursive methods.
	 */
	public static void main( String[] args )
	{
	    // compute the factorial of 4
	    System.out.println( "The factorial of 4 is " + factorial( 4 ) );
	}
}
