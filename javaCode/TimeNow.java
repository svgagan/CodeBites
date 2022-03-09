package javaCode;

import java.util.*;

/* Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
There is no limit on how many times a digit can be reused. */
class TimeNow {
    
    static int[] mins = { 600, 60, 10, 1 };
    public String timer(String time) {
        int colon = time.indexOf(':');
        int cur = Integer.valueOf(time.substring(0, colon)) * 60 + Integer.valueOf(time.substring(colon + 1));
        char[] next = new char[4];
        for (int i = 1, d = 0; i <= 1440 && d < 4; i++) {
            int m = (cur + i) % 1440;
            for (d = 0; d < 4; d++) {
                next[d] = (char)('0' + m / mins[d]); m %= mins[d];
                if (time.indexOf(next[d]) == -1) break;
            }
        }
        return new String(next, 0, 2) + ':' + new String(next, 2, 2);
    }
    
    public static void main(String args[]){
        TimeNow time = new TimeNow();
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter Time in format HH:MM");
        String tym = sc.next();
        String newTym = time.timer(tym);
        System.out.println("Subset time ->"+ newTym);
    }
    
}