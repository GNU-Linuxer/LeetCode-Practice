// 334. Increasing Triplet Subsequence (Medium)
// https://leetcode.com/problems/increasing-triplet-subsequence/

import java.util.Stack;

// Prone to fail in [20,100,10,12,5,13], [2,1,5,0,4,6] and [6,7,1,2] test cases
public class Q334M_Attempt_1 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        Stack<Integer> increasing = new Stack<Integer>();
        int increasingCount = 0;
        for(int i : nums) {
            if(increasingCount >= 2) {
                return true;
            }
            else if(!increasing.isEmpty() && i > increasing.peek()) {
                increasingCount ++;
            }
            while(!increasing.isEmpty() && i <= increasing.peek()) {
                increasing.pop();
            }
            increasing.push(i);
        }
        return increasingCount >= 2;
    }
}
