import java.util.*;
/* Reverse a string */
class Simple{  
	
	 static public String reverseMe(String s){	 
		if(s.length() == 0){
			return "";
		}else{
			return s.charAt(s.length()-1) + reverseMe(s.substring(0,s.length()-1));
		}
	} 
	public static void main(String args[]){  
	 Scanner scan = new Scanner(System.in);
	 String value = scan.next();
	 //StringBuffer s1 = new StringBuffer(value);
	 //StringBuffer s2 = s1.reverse();
	 String reversed = reverseMe(value);
	 System.out.println("Input String -> "+value);  
	 System.out.println("Reversed String -> "+reversed);
	 System.out.println(1+"3");
	}  
}