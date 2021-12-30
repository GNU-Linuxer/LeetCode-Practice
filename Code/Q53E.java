// 53. Maximum Subarray (Easy)
// https://leetcode.com/problems/maximum-subarray/

import java.util.Arrays;

public class Q53E {
    public int maxSubArray(int[] nums) {
        int[] maxSumSoFar = new int[nums.length];
        int maxSum = Integer.MIN_VALUE;
        Arrays.fill(maxSumSoFar, Integer.MIN_VALUE);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[0] > maxSumSoFar[0]) {
                maxSumSoFar[0] = nums[0];
            } else if (nums[i] > nums[i] + maxSumSoFar[i - 1]) {
                maxSumSoFar[i] = nums[i];
            } else {
                maxSumSoFar[i] = nums[i] + maxSumSoFar[i - 1];
            }

            if (maxSumSoFar[i] > maxSum) {
                maxSum = maxSumSoFar[i];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Q53E test1 = new Q53E();
        int[] arr1 = {5, 4, -1, 7, 8};
        System.out.println(test1.maxSubArray(arr1));
    }
}
