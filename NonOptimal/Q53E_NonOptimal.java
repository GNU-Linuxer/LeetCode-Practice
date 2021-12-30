// 53. Maximum Subarray (Easy)
// https://leetcode.com/problems/maximum-subarray/

public class Q53E_NonOptimal {
    public int maxSubArray(int[] nums) {
        if(nums == null) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i ++){
            for (int j = i; j < nums.length; j ++) {
                int sum = arraySum(nums, i, j);
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    private int arraySum(int[] nums, int start, int end) {
        int sum = 0;
        // The for-loop's upper bound needs to be i <= end , as the maxSubArray method already ensures we're not out of the bound
        for (int i = start; i <= end; i ++) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Q53E test1 = new Q53E();
        int[] arr1 = {5,4,-1,7,8};
        System.out.println(test1.maxSubArray(arr1));
    }
}
