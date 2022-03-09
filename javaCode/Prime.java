package javaCode;

import java.util.*;
/* java.Prime number Checker */
class Prime{  
	
	 static public String primeCheck(int s){
		int flag = 0, m=0;
		m = s/2;
		if(s == 0 || s == 1){
			return "is not java.Prime.";
		}
		for(int i=2; i <= m; i++){
			if(s%i == 0){
				flag = 1;
				break;
			}
		}
		if(flag == 1){
			return "is not java.Prime.";
		}else{
			return "is java.Prime.";
		}
	} 
	
	public static void main(String args[]){  
	 Scanner scan = new Scanner(System.in);
	 System.out.print("Enter a number: ");
	 int value = scan.nextInt();
	 String response = primeCheck(value);
	 System.out.println("\nGiven number "+ value +" "+response);  
	}  
}