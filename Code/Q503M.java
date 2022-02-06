// 503. Next Greater Element II (Medium)
// https://leetcode.com/problems/next-greater-element-ii/

import java.util.Stack;

public class Q503M {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 1) {
            int[] res = {-1}; // There would be no number greater than itself if we have only 1 number
            return res;
        }

        Stack<Integer> largeNum = new Stack<Integer>();
        int[] result = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i --) {
            int n = nums[i];
            while(!largeNum.isEmpty() && n >= largeNum.peek()) {
                largeNum.pop();
            }
            largeNum.push(n);
        }
        for(int i = nums.length - 1; i >= 0; i --) {
            int n = nums[i];
            while(!largeNum.isEmpty() && n >= largeNum.peek()) { // 2 in [1,2,1] can't be 2, since we need to find the next strictly increasing number
                largeNum.pop();
            }
            result[i] = largeNum.isEmpty() ? -1 : largeNum.peek();
            largeNum.push(n);
        }
        return result;
    }
}
