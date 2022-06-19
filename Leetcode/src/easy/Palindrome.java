package easy;

/**
 *
 * 125. Valid easy.Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 * */
public class Palindrome {
    public boolean isPalindrome(String s) {

        int l=0, r=s.length()-1;
        s=s.toLowerCase();
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l)))
                l++;

            while(r>l && !Character.isLetterOrDigit(s.charAt(r)))
                r--;

            if (s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args){
        Palindrome palindrome = new Palindrome();
        String input = "A man, a plan, a canal: Panama";
        boolean isPalindrome =  palindrome.isPalindrome(input);
        System.out.println(input + ": "+ isPalindrome);
    }
}
