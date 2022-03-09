package javaCode;

import java.util.*;
/* 
f(n) => {	n / 2		if n is even}
		{   3 * n + 1	if n is odd }
		{   1 	 return stoppingTime}

Example: 
finding stoppingTime(3) as per above expression
f(3) => 10
f(10) => 5
f(5) => 16
f(16) => 8
f(8) => 4
f(4) => 2
f(2) => 1 

return stoppingTime of 3 as 7

*/
class StoppingTime{
	private static int count = 0;
	
	public int stopTime(int key){
		if(key == 1){
			return count;
		}else{
			if(key % 2 == 0){
				key = key/2;
			}else{
				key = 3*key+1;
			}
			count++;
			stopTime(key);
		}
		return count;	
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number to find stoppingTime: ");
		int n = scan.nextInt();	
		StoppingTime stpTime = new StoppingTime();	
		int stpTimeValue = stpTime.stopTime(n);
		System.out.println("Stopping Time value of "+ n +" is: "+stpTimeValue);
	}
}