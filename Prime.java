import java.util.*;
/* Prime number */
class Prime{  
	
	 static public String primeCheck(int s){
		int flag = 0, m=0;
		m = s/2;
		if(s == 0 || s == 1){
			return "is not Prime.";
		}
		for(int i=2; i <= m; i++){
			if(s%i == 0){
				flag = 1;
				break;
			}
		}
		if(flag == 1){
			return "is not Prime.";
		}else{
			return "is Prime.";
		}
	} 
	public static void main(String args[]){  
	 Scanner scan = new Scanner(System.in);
	 int value = scan.nextInt();
	 String response = primeCheck(value);
	 System.out.println("Input Value -> "+value);  
	 System.out.println("Given number "+ value +" "+response);  
	}  
}