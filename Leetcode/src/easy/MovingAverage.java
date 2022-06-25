package easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 346. Moving Average from Data Streams.
 * Asked in Spotify interview.
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * */
public class MovingAverage {
    int size;
    Queue<Integer> queue = new LinkedList<Integer>();
    public MovingAverage(int size) {
        this.size = size;
    }
    public double next(int val) {
        if(queue.size() > size)
            queue.remove();

        queue.add(val);
        return returnAverage();
    }

    public double returnAverage() {
        Iterator<Integer> itr = queue.iterator();
        double sum = 0;
        while(itr.hasNext()){
            sum = sum+ itr.next();
        }
        return sum/queue.size();
    }

    public static void main(String[] args){
        MovingAverage movingAverage = new MovingAverage(5);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(2));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(4));
        System.out.println(movingAverage.next(5));
    }
}
