import java.util.*;

class MergeSort{

	public void combineTech(int[] arraySort, int head, int mid, int rear){
		int sizeOne = mid - head + 1;
		int sizeTwo = rear - mid;
		int[] left = new int[sizeOne];
		int[] right = new int[sizeTwo];
		
		for(int i=0; i<sizeOne; i++){
			left[i] = arraySort[head+i];
		}
		
		for(int j=0; j<sizeTwo; j++){
			right[j] = arraySort[mid+1+j];
		}
		
		int i=0,j=0,k=head;
		while (i < sizeOne && j < sizeTwo){ 
			if (left[i] <= right[j]) { 
				arraySort[k] = left[i]; 
				i++; 
			} else{ 
				arraySort[k] = right[j]; 
				j++; 
			} 
			k++; 
        }
		
		/* Copy remaining elements of left[] if any */
		while(i < sizeOne){
			arraySort[k] = left[i]; 
            i++; 
            k++;
		}
		
		/* Copy remaining elements of right[] if any */
		while(j < sizeTwo){
			arraySort[k] = right[i]; 
            j++; 
            k++;
		}
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