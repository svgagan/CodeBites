import java.util.*;

class MergeSort{

	public void combineTech(int[] arraySort, int head, int mid, int rear){
		int sizeOne
	}
	
	public void divideTech(int[] arraySort, int head, int rear){
		if(head < rear){
			int mid = (head+rear)/2;
			divideTech(arraySort, head, mid);
			divideTech(arraySort, mid+1, rear);
			combineTech(arraySort, head, mid, rear);
		}
	}
	
	public void printElements(int[] arraySort){
		for(int value : arraySort){
			System.out.print(value+",");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Size of Array to be Sorted: ");
		int arraySize = scan.nextInt();
		System.out.println("Enter Array Elements to be Sorted: ");
		int[] arraySort = new int[arraySize];
		for(int i=0; i<arraySize; i++){
			arraySort[i] = scan.nextInt();
		}
		MergeSort merger = new MergeSort();
		System.out.println("\n\nUn-Sorted Elements are: ");
		merger.printElements(arraySort);
		merger.divideTech(arraySort, 0, arraySort.length-1);
		System.out.println("\n\nSorted Elements are: ");
		merger.printElements(arraySort);
	}
}