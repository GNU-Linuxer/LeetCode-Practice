// 9. Palindrome Number (Easy)
// https://leetcode.com/problems/palindrome-number/

import java.util.Deque;
import java.util.LinkedList;

public class Q9E {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x > -10 && x < 10) {
            return true; // one digit is always Palindrome Number
        }
        Deque<Integer> num = new LinkedList<Integer>();
        while(x >= 10) {
            num.addLast(x % 10);
            x = x / 10;
        }
        num.addLast(x);

        while(num.size() > 1) {
            if(num.removeFirst() != num.removeLast()) {
                return false;
            }
        }

        return true;
    }
}
