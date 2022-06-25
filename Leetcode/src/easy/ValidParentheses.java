package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 *
 * */
public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('}', '{');
        charMap.put(']', '[');
        charMap.put(')', '(');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(!stack.empty() && charMap.containsKey(s.charAt(i))){
                if(charMap.get(s.charAt(i)) != stack.pop()){
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }

    public static void main(String[] args){
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([{}])"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid(")([]{}"));
    }
}
