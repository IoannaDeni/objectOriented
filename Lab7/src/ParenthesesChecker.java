import java.lang.String;
/**
 * 
 * This class parses arguments from the main method and parses them and evaluates if they are matched returning "Matched" or noot matched
 * 
 * @author Ioanna Deni
 * @version 10/31/2017
 *
 */

public class ParenthesesChecker {
	
	/**
	* Uses a Split String and a Stack to check if parentheses match
	* @param input A string containing parentheses of types () [] {}
	* @return True if each open parentheses is matched by a closing parentheses
	*/
	public static boolean checkParentheses(String input){
		
		//This counts the matches of the parenthesis - if the matches are equal with the size of the parenthesis divided by two then all of them are matched 
		double count = 0;
		
		//Here we create the stack of type String
		StackAL<String> myStack = new StackAL<String>();
		
		//This is necessary parsing of the input so we can take each character separately
		String splitted[] = input.split(" ");
		
		//If the length of the input is smaller than two then the parenthesis are not matched 
		if (splitted.length<2){
			return false;
		}
		
		//if the last character is an open parenthesis then they will not be matched
		else if(splitted[splitted.length-1].equals("(") || splitted[splitted.length-1].equals("{") || splitted[splitted.length-1].equals("[")){
			return false;
		}
		
		//if the last character is an closed parenthesis then they will might be matched
		else if (splitted[splitted.length-1].equals(")") || splitted[splitted.length-1].equals("}") || splitted[splitted.length-1].equals("]")){
			
			//we go through the array of characters
			for (int i = 0; i < splitted.length; i++){
				
				//if the character is an open parenthesis we push it in the stack
				if (splitted[i].equals("(") || splitted[i].equals("{") || splitted[i].equals("[")){
					
					myStack.push(splitted[i]);	
				}
				
				//if it is a closed parenthesis and matches the top open parenthesis then we pop the open parenthesis and increase the count by 1
				if (splitted[i].equals(")") && myStack.peek().equals("(")){
						myStack.pop();
						count = count + 1;
				}
				else if (splitted[i].equals("}") && myStack.peek().equals("{")){
					myStack.pop();
					count = count + 1;
				}
				else if (splitted[i].equals("]") && myStack.peek().equals("[")){
					myStack.pop();
					count = count + 1;
				}
			}
			
			//if they are matched the count should be equal with the lenght divided by 2 
			if (count == (double)splitted.length/2){
				return true;
			}
		}
			return false;
	}
	 
	/**
	* Calls "checkParentheses" for each argument in "args" and prints out if they match or not
	*/
	public static void main(String args[]){
		
		//If we have arguments
		if (args.length > 0) {
			
			//for all the arguments
			for (int i = 0; i< args.length; i++){
				
				//the arguments are printed
				System.out.println(args);
				
				//If they are matched then we output "Matched"
				if (checkParentheses(args[i])){
					System.out.println("Matched");
				}
				
				//If they are not matched then we output "Not Matched"
				else if (!checkParentheses(args[i])){
					System.out.println("Not Matched");
				}
			}
		}
	}

}
