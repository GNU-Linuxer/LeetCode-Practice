// 678. Valid Parenthesis String (Medium)
// https://leetcode.com/problems/valid-parenthesis-string/

import java.util.Stack;

public class Q678M {
    public boolean checkValidString(String s) {
        Stack<Character> paren = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char sChar = s.charAt(i);
            if(sChar == '(' || sChar == '*') {
                paren.push(sChar);
            }
            else if(sChar == ')') {
                if(paren.isEmpty()) {
                    return false;
                } else {
                    // For any ), prioritize removing the right-most ( on the stack before removing a *
                    boolean seenLeftParen = false;
                    for(int j = paren.size() - 1; j >= 0; j -- ) {
                        if(paren.get(j) == '(') {
                            paren.remove(j);
                            seenLeftParen = true;
                            break;
                        }
                    }
                    if(!seenLeftParen) {
                        paren.pop();
                    }
                }
            }
        }
        int numberStar = 0;

        // Stack only has ( and *, check whether they match, such as (**( should return false.
        while(!paren.isEmpty()) {
            if(paren.peek() == '(') {
                if(numberStar <= 0) {
                    return false;
                } else {
                    // When we found (, we reduce the number of available * by 1
                    numberStar --;
                    paren.pop();
                }
            } else if(paren.peek() == '*') {
                numberStar ++;
                paren.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q678M test1 = new Q678M();
        String s = "(*)";
        // Did not consider the edge case when we only has ( and * , such as (**( should return false.
        String str = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        System.out.println(test1.checkValidString(s));
    }
}