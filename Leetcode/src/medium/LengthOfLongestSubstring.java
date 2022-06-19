package medium;

import java.util.HashSet;

/**
 *
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        int max=0;

        HashSet<Character> hset = new HashSet<>();
        //Using sliding window technique by removing characters from set.
        while(end < s.length()){
            if(!hset.contains(s.charAt(end))){
                hset.add(s.charAt(end));
                end++;
                max = Math.max(hset.size(), max);
            } else {
                hset.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args){
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcababcd"));
    }
}
