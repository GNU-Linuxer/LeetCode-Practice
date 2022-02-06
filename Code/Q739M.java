// 739. Daily Temperatures (Medium)
// https://leetcode.com/problems/daily-temperatures/

import java.util.Stack;

public class Q739M {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1) {
            int[] result = {0};
            return result;
        }

        Stack<Integer> largeTemp = new Stack<Integer>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i ++) {
            int temp = temperatures[i];
            while(!largeTemp.isEmpty() && temp > temperatures[largeTemp.peek()]) {
                int index = largeTemp.pop();
                result[index] = i - index; // I will always be larger than index
            }
            largeTemp.push(i);
        }

        return result;
    }
}
