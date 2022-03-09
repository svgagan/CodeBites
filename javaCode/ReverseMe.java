package javaCode;

import java.util.*;
/* Reverse a string without using build-in libraries */
class ReverseMe{  
	
	 static public String reverseMe(String s){	 
		if(s.length() == 0){
			return "";
		}else{
			return s.charAt(s.length()-1) + reverseMe(s.substring(0,s.length()-1));
		}
	} 
	public static void main(String args[]){  
	 Scanner scan = new Scanner(System.in);
	 System.out.println("Enter a String: ");
	 String value = scan.next();
	 String reversed = reverseMe(value);
	 System.out.println("Input String -> "+value);  
	 System.out.println("Reversed String -> "+reversed);
	}  
}