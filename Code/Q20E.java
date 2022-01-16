// 20. Valid Parentheses (Easy)
// https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class Q20E {
    public boolean isValid(String s) {
        if(s.length() % 2.0 != 0) {
            return false;
        }
        Stack<Character> paren = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char sChar = s.charAt(i);
            if(sChar == '(' || sChar == '[' || sChar == '{') {
                paren.push(sChar);
            }
            if(sChar == ')') {
                if(paren.isEmpty()) {
                    return false;
                }
                if(paren.pop() != '(') {
                    return false;
                }
            }
            if(sChar == ']') {
                if(paren.isEmpty()) {
                    return false;
                }
                if(paren.pop() != '[') {
                    return false;
                }
            }
            if(sChar == '}') {
                if(paren.isEmpty()) {
                    return false;
                }
                if(paren.pop() != '{') {
                    return false;
                }
            }
        }
        return paren.isEmpty();
    }
}