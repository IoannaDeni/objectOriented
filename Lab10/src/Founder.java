/**
 * This class contains method for returning them grouped and as strings separated by lines
 * 
 * @author Ioanna Deni
 * @version 11/28/2027
 *
 */
public class Founder {
	
	//the variables holding all information
	private String ID_num, name, year, college;
	
	/**
	 * the constructor to fill the private variables
	 * 
	 * @param ID
	 * @param name
	 * @param year
	 * @param college
	 */
	public Founder(String ID, String name, String year, String college){
		
		ID_num = ID;
		this.name = name;
		this.year=year;
		this.college = college;	
	}
	
	/**
	 * when called will return a string containing the contents of Founder, 
	 * with new lines separating each variable.
	 */
	public String toString(){
		
		String line = "\nid: " + ID_num + "\nname: " + name + "\nyear: " + year + "\ncollege: " + college;
		
		return line;
	}

}
