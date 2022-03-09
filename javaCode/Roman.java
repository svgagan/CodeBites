package javaCode;

import java.util.*;
/* Converting java.Roman to decimal */
class Roman{  
		 
	 public static int romanTointeger(String num){
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		ht.put('I',1);ht.put('X',10);
		ht.put('C',100);ht.put('M',1000);
		ht.put('V',5);ht.put('L',50);ht.put('D',500);
		int intNum=0;
		int prev = 0;
		for(int i = num.length()-1; i>=0 ; i--)
		{
				int temp = ht.get(num.charAt(i));
				if(temp < prev)
					intNum-=temp;
				else
					intNum+=temp;
				prev = temp;
		}
		return intNum;
	}
	
	public static void main(String args[]){ 
	 System.out.println("Enter java.Roman Number");
	 Scanner scan = new Scanner(System.in);
	 String value = scan.next();
	 int response = romanTointeger(value.toUpperCase());
	 System.out.println("java.Roman Value -> "+value);
	 System.out.println("Decimal Value -> "+response);
	}  
}