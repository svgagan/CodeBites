package javaCode;

import java.util.*;

/* Circular-Queues Implementation in Java */
class CircularQueue{

	private static int SIZE = 0;
	private int front = -1;
	private int rear = -1;
	
	//To Check Whether circular-queue is Empty
	public Boolean isEmpty(){
		if(front == -1){
			//System.out.println("Circular-Queue Is Empty");
			return true;
		}else{
			//System.out.println("Circular-Queue Is Not Empty");
			return false;
		}
	}
	
	//To Check Whether circular-queue is Full
	public Boolean isFull(){
		if((front == rear+1) || (front == 0 && rear == SIZE-1)){
			return true;
		}else{
			return false;
		}
	}
	
	//ENQUEUE operation on circular-queue
	public void enQueue(int key, int[] queueArray){
		if(isFull()){
			System.out.println("Circular-Queue Overflow Occurred");
		}else{
			if(front == -1){
				front++;
			}
			rear = (rear+1) % SIZE;
			queueArray[rear] = key;
			System.out.println("Key Element is EnQueued");
		}
	}
	
	//DEQUEUE operation on circular-queue
	public void deQueue(int[] queueArray){
		if(isEmpty()){
			System.out.println("Circular-Queue Underflow Occurred");
		}else{
			int key = queueArray[front];
			if(front == rear){
				front = -1;
				rear = -1;
			}else{
				front = (front+1) % SIZE;
			}
			System.out.println("Element "+ key +" DeQueued");
		}
	}
	
	//Print Circular-Queue Elements and Pointers
	public void printQueue(int[] queueArray){
		if(isEmpty()){
			System.out.println("Circular-Queue Is Empty");
		}else{
			System.out.println("	Front Pointer in Circular-Queue Is ->"+front);
			System.out.print("	Circular-Queue Elements are: ");
			int i=0;
			for(i=front; i != rear; i=(i+1)%SIZE){
				System.out.print(queueArray[i]+",");
			}
			System.out.print(queueArray[i]);
			System.out.println("\n	Rear Pointer in Circular-Queue Is ->"+rear);
		}
	}
	
	//To print current size of queue
	public void queueSize(){
		System.out.print("No. Of Elements in Circular-Queue is ->");
		if(front == -1 && rear == -1){
			System.out.print(0);
		}else if(front <= rear){
			System.out.print((rear-front)+1);
		}else{
			System.out.print(rear-front+1+SIZE);
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Circular Queue Size");
		SIZE = scan.nextInt();
		int queueArray[] = new int[SIZE];
		CircularQueue cQueueDS = new CircularQueue();
		while(true){
			System.out.println("\nSelect Queue Operation: 0.Exit, 1.EnQueue, 2.DeQueue, 3.QueueSize, 4.PrintQueue");
			int queueOperation = scan.nextInt();
			switch(queueOperation){
				case 1: System.out.println("Enter Key Element to be EnQueued");
						cQueueDS.enQueue(scan.nextInt(),queueArray);
						break;
				case 2: cQueueDS.deQueue(queueArray);
						break;
				case 3: cQueueDS.queueSize();
						break;
				case 4: cQueueDS.printQueue(queueArray);
						break;		
				default: System.out.println("Queue Says Bye"); break;
			}
			if(queueOperation == 0){
				break;
			}
		}
	}

}