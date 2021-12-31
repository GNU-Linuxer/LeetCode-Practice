// 674. Longest Continuous Increasing Subsequence (Easy)
// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

import java.util.Arrays;

public class Q674E {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        // Need to think why we can't use int longest = Integer.MIN_VALUE; that I typically use in other similar questions using DP to solve
        // It will fail if we have an array with 1 number
        int longest = 1;
        int[] numIncreasing = new int[nums.length];
        Arrays.fill(numIncreasing, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                numIncreasing[i] = numIncreasing[i - 1] + 1;
                longest = Math.max(longest, numIncreasing[i]);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Q674E test1 = new Q674E();
        int[] array = {1, 2, 3, 4, 3, 4, 3, 4, 5, 6, 7, 8};

        System.out.println(test1.findLengthOfLCIS(array));
    }
}
