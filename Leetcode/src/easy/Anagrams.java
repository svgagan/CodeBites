package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 * */
public class Anagrams {
    public boolean isAnagram(String s, String t) {

        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1,t1);
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> smap = new HashMap<Character,Integer>();
        Map<Character, Integer> tmap = new HashMap<Character,Integer>();

        for(int i=0; i<s.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i),0)+1);
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> local: smap.entrySet()){
            if(smap.get(local.getKey()) != tmap.getOrDefault(local.getKey(), 0))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        Anagrams anagrams = new Anagrams();
        String input1 = "anagram";
        String input2 = "nagaram";
        boolean isAnagram =  anagrams.isAnagram(input1, input2);
        boolean isAnagram2 =  anagrams.isAnagram2(input1, "nagaramas");
        System.out.println("IsAnagram: "+ isAnagram);
        System.out.println("IsAnagram2: "+ isAnagram2);
    }
}
