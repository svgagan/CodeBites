import java.util.*;
/* FizzBuzz problem */
class Fizzbuzz{  
	
	/* 
		f(n) = [ (n%3 and n%5) = 0 => FizzBuzz ]
		f(n) = [ (n%3) = 0 => Fizz ]
		f(n) = [ (n%5) = 0 => Buzz ]
		f(n) = [ (n%3 or n%5) != 0 => number ]
		
	*/
	 static public void fizzbuzz(int n){
		for(int i=0; i<=n; i++){
			if(i%3 == 0 && i%5 == 0){
				System.out.println("FizzBuzz");  
			}else if(i%3 == 0){
				System.out.println("Fizz");  
			}else if(i%5 == 0){
				System.out.println("Buzz");  
			}else{
				System.out.println(i);
			}
		}
	}
	
	public static void main(String args[]){  
	 Scanner scan = new Scanner(System.in);
	 System.out.print("Enter an number: ");
	 int value = scan.nextInt();
	 fizzbuzz(value);  
	}  
}