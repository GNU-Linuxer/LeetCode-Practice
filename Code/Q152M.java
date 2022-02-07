// 152. Maximum Product Subarray (Medium)
// https://leetcode.com/problems/maximum-product-subarray/

public class Q152M {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        }

        // Similar to Q238M, we need to default the product to 1 not 0 nor first number of original list
        int min = 1;
        int max = 1;

        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i ++) {
            int n = nums[i];
            if(n < 0 ) { // swap min and max (if we encounter n < 0, max should=(min * nums[i], nums[i]))
                int temp = max;
                max = min;
                min = temp;
            }
            min = Math.min(min * n, n); // Similar to the state change function in Q53E
            max = Math.max(max * n, n);
            maxProduct = Math.max(maxProduct, max);
        }
        return maxProduct;
    }
}
