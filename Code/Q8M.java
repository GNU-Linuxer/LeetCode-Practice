// 8. String to Integer (atoi) (Medium)
// https://leetcode.com/problems/string-to-integer-atoi/

import java.util.LinkedList;
import java.util.Queue;

public class Q8M {
    public int myAtoi(String s) {
        if(s == null || s.trim().length() == 0) {
            return 0;
        }
        boolean firstNonNumericChar = false;

        // FIFO data, use Queue
        Queue<Character> numericCharacter = new LinkedList<Character>();

        // This removes leading and trailing whitespace
        char[] sArr = s.trim().toCharArray();
        boolean isNegativeNum = sArr[0] == '-';
        int start = (sArr[0] == '-' || sArr[0] == '+') ? 1 : 0;
        for(int i = start; i < sArr.length; i ++) {
            char c = sArr[i];
            if(c >= '0' && c <= '9') {
                numericCharacter.add(c);
            }
            // Stops reading string if we reach to nonNumeric Char. The rest of the string is ignored.
            else { // "-+12" should return 0 not -12
                break;
            }
        }
        if(numericCharacter.isEmpty()) {
            return 0;
        }

        int result = numericCharacter.poll() - '0';
        result = isNegativeNum ? result * -1 : result;

        while(!numericCharacter.isEmpty()) {
            // If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.

            // result*10 < Integer.MIN_VALUE is equal to result < Integer.MIN_VALUE/10
            int b = numericCharacter.poll() - '0'; // the absolute value for b

            if(Math.abs(result) > Integer.MAX_VALUE / 10) {
                if(isNegativeNum) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else if (Math.abs(result) == Integer.MAX_VALUE / 10) {
                if(isNegativeNum && b >= 8) { // -214748364 8
                    return Integer.MIN_VALUE;
                } else if (!isNegativeNum && b >= 7) {
                    return Integer.MAX_VALUE; // 214748364 7
                }
            }

            result = isNegativeNum ? result * 10 - b : result * 10 + b;

            /* Original way:
            if(isNegativeNum && resultTmp > result) {
                return Integer.MIN_VALUE;
            } else if(!isNegativeNum && resultTmp < result) {
                return Integer.MAX_VALUE;
            }*/


        }
        return result;
    }
}
