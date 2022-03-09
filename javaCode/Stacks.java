package javaCode;

import java.util.*;

/* java.Stacks Implementation in Java */
class Stacks{

	private int top = -1;
	
	//PUSH operation on stack - O(1) 
	public void push(int key, int[] stackArray){
		if(top >= stackArray.length-1){
			System.out.println("Stack Overflow Occurred");
		}else{
			stackArray[++top] = key;
			System.out.println("Key Element Pushed onto Stack");
		}
	}
	
	//POP operation on stack - O(1)
	public void pop(int[] stackArray){
		if(top < 0){
			System.out.println("Stack Underflow Occurred");
		}else{
			int key = stackArray[top--];
			System.out.println("Key Element "+ key +" Popped from Stack");
		}
	}
	
	//To Check Whether stack is Empty
	public void isEmpty(int[] stackArray){
		int stackLength = (stackArray.length-top)-1;
		if(top < stackArray.length-1){
			System.out.println("Stack Is Empty and still "+stackLength+" spaces available");
		}else{
			System.out.println("Stack Is Not Empty");
		}		
	}
	
	//Print Stack Elements
	public void printStack(int[] stackArray){
		System.out.println("Stack Elements in reversed order are: ");
		for(int i=top; i>=0; i--){
			System.out.print(stackArray[i]+",");
		}	
	}
	
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Stack Size");
		int stackSize = scan.nextInt();
		int stackArray[] = new int[stackSize];
		Stacks stackDS = new Stacks();
		while(true){
			System.out.println("\nSelect Stack Operation: 0.Exit, 1.Push, 2.Pop, 3.IsEmpty, 4.PrintReversedStack");
			int stackOperation = scan.nextInt();
			switch(stackOperation){
				case 1: System.out.println("Enter Key Element to be Pushed");
						stackDS.push(scan.nextInt(),stackArray);
						break;
				case 2: stackDS.pop(stackArray);
						break;
				case 3: stackDS.isEmpty(stackArray);
						break;
				case 4: stackDS.printStack(stackArray);
						break;		
				default: System.out.println("Stack Says Bye"); break;
			}
			if(stackOperation == 0){
				break;
			}
		}
	}
}