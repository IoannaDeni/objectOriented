import org.w3c.dom.Node;

import datastructures.ArrayList;

/**
 * This class contains method for adding elements of type Founder to ArrayList and returning them as strings
 * 
 * @author Ioanna Deni
 * @version 11/28/2027
 *
 */
public class CollegeFounders {
	
	//the list holding all founders
	private ArrayList<Founder> all_founders = new ArrayList<Founder>();
	
	/**
	 * when called will add a Founder to the ArrayList variable
	 * 
	 * @param f
	 */
	public void addFounder( Founder f ){
		
		all_founders.add(all_founders.size(), f);
	}
	
	
	/**
	 * /when called will call toString on the ArrayList variable
	 */
	public String toString(){
		
		String stringList ="";
		
		//we look at all the items
		for (int i = 0; i < all_founders.size(); i++){
			
			//and adding them as strings to the string array
			stringList = stringList + all_founders.get(i).toString();
		}
		
		return stringList;
	
	}

}
