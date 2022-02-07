// 238. Product of Array Except Self (Medium)
// https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q238M {
    public int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> left = new HashMap<Integer, Integer>(); // index -> the product of all numbers before index
        Map<Integer, Integer> right = new HashMap<Integer, Integer>(); // index -> the product of all numbers after index

        left.put(0, 1); // First element does not have a left portion
        int productSoFar = 1;
        for(int i = 1; i < nums.length; i ++) {
            productSoFar = productSoFar * nums[i-1];
            left.put(i, productSoFar);
        }

        right.put(nums.length - 1, 1);
        productSoFar = 1;
        for(int i = nums.length - 2; i >= 0; i --) {
            productSoFar = productSoFar * nums[i+1];
            right.put(i, productSoFar);
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            result[i] = left.get(i) * right.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Q238M test1 = new Q238M();
        int[] arr1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(test1.productExceptSelf(arr1)));
    }
}
