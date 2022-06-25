package easy;

/**
 *
 * 1480. Running Sum of 1d Array
 *
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 * Return the running sum of nums.
 *
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
 *
 * */
public class RunningSum {

    public int[] runningSum(int[] nums) {
        int sum = 0;
        int[] output = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            sum = sum+nums[i];
            output[i] = sum;
        }
        return output;
    }

    public static void main(String[] args){
        RunningSum runningSum = new RunningSum();
        int[] nums = {3,1,2,10,1};
        for (int item: runningSum.runningSum(nums)) {
            System.out.println(item);
        }
    }
}
