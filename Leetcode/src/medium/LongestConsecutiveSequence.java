package medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> inputSet = Arrays.stream(nums).boxed().collect(Collectors.toSet()); //Created unique set of array.
        int longestConsecutiveSeq = 0;
        //Loop through each integer in array
        for(int i=0; i<nums.length; i++){

            //Identify if the integer at nums[i] is first element in sequence by checking for previous integer in set.
            //If set doesn't contain previous integer then it's a beginning of a sequence or else ignore and move forward in array.
            if(!inputSet.contains(nums[i]-1)){
                int localSeqLen = 1;
                while(inputSet.contains(nums[i]+localSeqLen)){
                    localSeqLen++;
                }
                longestConsecutiveSeq = Math.max(localSeqLen, longestConsecutiveSeq); //Check for previous max sequence.
            }
        }
        return longestConsecutiveSeq;
    }

    public static void main(String[] args){
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }
}
