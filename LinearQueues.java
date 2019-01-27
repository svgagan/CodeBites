import java.util.*;

/* Queues Implementation in Java */
class LinearQueues{
	private int front = -1;
	private int rear = -1;
	
	//ENQUEUE operation on queue - O(1)
	public void enQueue(int key, int[] queueArray){
		if(front == -1){
			front++;
		}
		if(rear == queueArray.length-1){
			System.out.println("Queue Overflow Occurred");
		}else{
			queueArray[++rear] = key;
			System.out.println("Key Element is EnQueued");
		}
	}
	
	//DEQUEUE operation on queue - O(1)
	public void deQueue(int[] queueArray){
		if(front >= 0 && rear >= 0){
			int key = queueArray[front];
			System.out.println("Key Element "+ key +" DeQueued");
			for(int k=0; k<rear; k++){
				queueArray[k] = queueArray[k+1];
			}
			rear--;
		}else{
			System.out.println("Queue Underflow Occurred");
		}	
	}
	
	//To Check Whether queue is Empty
	public void isEmpty(int[] queueArray){
		if(rear == queueArray.length-1){
			System.out.println("Queue Is Not Empty");
		}else{
			System.out.println("Queue Is Empty");
		}
	}
	
	//Print Queue Elements
	public void printQueue(int[] queueArray){
		System.out.println("Queue Elements in order are: ");
		for(int i=0; i<=rear; i++){
			System.out.print(queueArray[i]+",");
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Queue Size");
		int queueSize = scan.nextInt();
		int queueArray[] = new int[queueSize];
		LinearQueues lQueueDS = new LinearQueues();
		while(true){
			System.out.println("\nSelect Queue Operation: 0.Exit, 1.EnQueue, 2.DeQueue, 3.IsEmpty, 4.PrintQueue");
			int queueOperation = scan.nextInt();
			switch(queueOperation){
				case 1: System.out.println("Enter Key Element to be EnQueued");
						lQueueDS.enQueue(scan.nextInt(),queueArray);
						break;
				case 2: lQueueDS.deQueue(queueArray);
						break;
				case 3: lQueueDS.isEmpty(queueArray);
						break;
				case 4: lQueueDS.printQueue(queueArray);
						break;		
				default: System.out.println("Queue Says Bye"); break;
			}
			if(queueOperation == 0){
				break;
			}
		}
	}

}