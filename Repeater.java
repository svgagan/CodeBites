
import java.util.*;
/* find First Non-Repeated and Repeated Character from String */
class Repeater{  
	
	 public static char firstNonRepeatingCharWithRegex(String word) {
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (!word.matches("(.*)" + letter + "(.*)" + letter + "(.*)")) {
				return letter;//Not Repeating
			}
		}
		return ' ';
	}
	
	public static char firstRepeatingCharWithRegex(String word) {
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (word.matches("(.*)" + letter + "(.*)" + letter + "(.*)")) {
				return letter;//Repeating
			}
		}
		return ' ';
	}
	
	static char firstRepeating(char str[]){
		// Creates an empty hashset
		HashSet<Character> h = new HashSet<>();
		// Traverse the input array from left to right
		for (int i=0; i<=str.length-1; i++){
			char c = str[i];
			if (h.contains(c))
				return c;
			else 
				h.add(c);
		}
		return ' ';
	}
	
	public static void main(String args[]){  
	 Scanner scan = new Scanner(System.in);
	 System.out.println("Enter a String");
	 String value = scan.next();
	 char notRepeat = firstNonRepeatingCharWithRegex(value);
	 char Repeat = firstRepeatingCharWithRegex(value);
	 char Repeater = firstRepeating(value.toCharArray());
	 System.out.println("Input String -> "+value);  
	 System.out.println("First Character Repeated -> "+Repeat);
	 System.out.println("First Character Not Repeated -> "+notRepeat);	 
	 System.out.println("First Character Repeated whose index of first occurrence is smallest -> "+Repeater);
	}  
}