// 152. Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/

// Solution is correct but exceeds memory limit
public class Q152M_Correct_NonOptimal {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        }

        // int[i][j] = product from i to j in the nums[], inclusive （we only need upper-right half of array)
        int[][] products = new int[nums.length][nums.length];
        int maxProduct = Integer.MIN_VALUE;
        for(int r = 0; r < nums.length; r ++) {
            for(int c = r; c < nums.length; c ++) {
                if(c == r) {
                    products[r][c] = nums[c];
                } else {
                    products[r][c] = nums[c] * products[r][c - 1];
                }
                maxProduct = Math.max(maxProduct, products[r][c]);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {

    }
}
