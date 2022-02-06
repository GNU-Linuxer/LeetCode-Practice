// 456. 132 Pattern (Medium)
// https://leetcode.com/problems/132-pattern/

import java.util.Stack;

public class Q456M {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        // Get the minimum value left of nums[i] (not including nums[i])
        int[] mins = new int[nums.length];
        mins[0] = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i ++) {
            if(i == 1) {
                mins[i] = nums[i] > nums[i-1] ? nums[i-1] : Integer.MAX_VALUE;
            } else if (i == 2) {
                mins[i] = Math.min(nums[i-1], nums[i-2]);
            } else {
                mins[i] = Math.min(nums[i-1], mins[i-1]); // Borrow DP concept: we don't need to recalculate mins[i-1] if we can trust mins[i-1] value (the minimum value so far before i)
            }
        }

        Stack<Integer> decreasingNum = new Stack<Integer>();
        for(int i = nums.length - 1; i >= 1; i --) {
            int n = nums[i];
            int rightMax = Integer.MIN_VALUE;
            while(!decreasingNum.isEmpty() && n > decreasingNum.peek()) { // Testing whether nums[j] > nums[k]
                int m = decreasingNum.pop();
                rightMax = Math.max(rightMax, m);
            }
            if(rightMax != mins[i] && rightMax > mins[i]) { // Need to test whether nums[k] > nums[i] (implies nums[j] > nums[i])
                return true;
            }

            decreasingNum.push(n);
        }

        return false;
    }
}
