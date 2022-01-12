// 53. Maximum Subarray (Easy)
// https://leetcode.com/problems/maximum-subarray/

// CSE 417 DP lecture approach
public class Q53E_2 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        }

        int[] include = new int[nums.length]; // max sum from 0 to i, inclusive
        int[] OPT = new int[nums.length]; // max sum from 0 to i, might or might not include i

        include[0] = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            include[i] = Math.max(nums[i], nums[i] + include[i - 1]);
        }

        int maxProduct = Integer.MIN_VALUE;
        OPT[0] = include[0];
        for(int i = 1; i < nums.length; i ++) {
            OPT[i] = Math.max(include[i], OPT[i - 1]);
            maxProduct = Math.max(OPT[i], maxProduct);
        }

        return maxProduct;
    }
    public static void main(String[] args) {
        Q53E_2 test1 = new Q53E_2();
        int[] arr1 = {5, 4, -1, 7, 8};
        System.out.println(test1.maxSubArray(arr1));
    }
}
