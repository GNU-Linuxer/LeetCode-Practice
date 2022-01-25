// 1021. Remove Outermost Parentheses (Easy)
// https://leetcode.com/problems/remove-outermost-parentheses/

import java.util.HashSet;
import java.util.Set;

public class Q1021E {
    public String removeOuterParentheses(String s) {
        char[] sCharArray = s.toCharArray();
        int leftParen = 0; // No need to check the content
        Set<Integer> excludedIndex = new HashSet<Integer>(); // each value is guaranteed to be unique
        for(int i = 0; i < s.length(); i ++) {
            if(sCharArray[i] == '(') {
                if(leftParen == 0) {
                    excludedIndex.add(i);
                }
                leftParen ++;
            } else if(sCharArray[i] == ')') {
                leftParen --;
                if(leftParen == 0) {
                    excludedIndex.add(i);
                }
            }
        }

        String result = "";
        for(int i = 0; i < s.length(); i ++) {
            if(!excludedIndex.contains(i)) {
                result = result + sCharArray[i];
            }
        }
        return result;
    }
}
