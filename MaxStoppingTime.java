import java.util.*;

/* 
maxStoppingTime(4) should return stoppingTime for all values below 4
To get stoppingTime, lookup stoppingTime.java

stoppingTime(1) => 0
stoppingTime(2) => 1
stoppingTime(3) => 7
stoppingTime(4) => 2

*/

class MaxStoppingTime{

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

	public HashMap<Integer,Integer> maxStopTime(HashMap<Integer,Integer> stopMap, int key){
		count = 0;
		if(key == 1){
			stopMap.put(count, key);
			return stopMap;
		}else{
			int stopTimeValue = stopTime(key);
			stopMap.put(stopTimeValue, key);
			maxStopTime(stopMap, key--);
		}
		return stopMap;
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the UpperBound Number: ");
		int n = scan.nextInt();	
		MaxStoppingTime stpTime = new MaxStoppingTime();
		HashMap<Integer,Integer> stopMap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> stopResponseMap = stpTime.maxStopTime(stopMap,n);
		for(HashMap.Entry m : stopResponseMap.entrySet()){
			System.out.println("Stopping Time value of "+ m.getValue() +" is: "+m.getKey());
		}
	}
}