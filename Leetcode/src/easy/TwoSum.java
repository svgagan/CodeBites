package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 * */
public class TwoSum {

    public int[] indexesOfTwoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> indexMap = new HashMap<>();
        int[] arr = new int[2];
        for(int i=0; i<numbers.length; i++){
            int res = target - numbers[i];
            if(indexMap.containsKey(res)){
                arr[0] = indexMap.get(res);
                arr[1] = i;
            }
            indexMap.put(numbers[i], i);
        }
        return arr;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum.indexesOfTwoSum(arr, 9)));
    }
}
