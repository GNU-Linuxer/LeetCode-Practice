// 202. Happy Number
// https://leetcode.com/problems/happy-number/

import java.util.*;

public class Q202E {
    public boolean isHappy(int n) {
        if(n == 1) {
            return true;
        }
        int[] square = new int[10]; // 0-9
        Set<Integer> calculated = new HashSet<Integer>();
        String str = Integer.toString(n);
        int sum = 0;
        while(sum != 1) {
            sum = 0;
            for (int i = 0; i < str.length(); i ++) {
                int num = Character.getNumericValue(str.charAt(i));
                if(num != 0 && square[num] == 0) {
                    square[num] = (int)Math.pow(num, 2);
                }
                sum += square[num];
            }
            if(calculated.contains(sum)) {
                return false;
            } else {
                calculated.add(sum);
            }
            str = Integer.toString(sum);
        }
        return true;
    }
}