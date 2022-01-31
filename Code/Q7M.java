// 7. Reverse Integer (Medium)
// https://leetcode.com/problems/reverse-integer/

import java.util.LinkedList;
import java.util.Queue;

public class Q7M {
    public int reverse(int x) {
        // Reverse a single-digit number remain unchanged
        if(x > -10 && x < 10) {
            return x;
        }
        boolean negativeNum = x < 0;
        Queue<Integer> num = new LinkedList<Integer>();
        if(negativeNum) {
            while(x <= -10) {
                num.add(-x % 10);
                x = x / 10;
            }
        } else {
            while(x >= 10) {
                num.add(x % 10);
                x = x / 10;
            }
        }

        num.add(Math.abs(x));

        int result = num.remove() * (negativeNum ? -1 : 1);
        while(!num.isEmpty()) {
            int next = num.remove();

            if(Math.abs(result) > Integer.MAX_VALUE / 10) {
                return 0; // return 0 instead of min/max possible value for int for integer overflow
            } else if(Math.abs(result) == Integer.MAX_VALUE) {
                if(negativeNum && next >= 8) {
                    return Integer.MIN_VALUE;
                } else if(!negativeNum && next >= 7) {
                    return Integer.MAX_VALUE;
                }
            }

            result = negativeNum ? result * 10 - next : result * 10 + next;
        }
        return result;
    }
}
