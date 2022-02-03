// 739. Daily Temperatures (Medium)
// https://leetcode.com/problems/daily-temperatures/

import java.util.*;

public class Q739M_Attempt_1 {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1) {
            int[] result = {0};
            return result;
        }

        Stack<Integer> largeTemp = new Stack<Integer>();
        Map<Integer, Integer> increasingTemp = new HashMap<Integer, Integer>();
        for(int i = temperatures.length - 1; i >= 0; i --) {
            int temp = temperatures[i];
            int count = 1;
            while(!largeTemp.isEmpty() && temp > largeTemp.peek()) {
                largeTemp.pop();
                count ++;
            }
            increasingTemp.put(i, largeTemp.isEmpty() ? 0 : count);
            largeTemp.push(temp);
        }

        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i ++) {
            result[i] = increasingTemp.get(i);
        }

        return result;
    }
}
