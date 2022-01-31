// 215. Kth Largest Element in an Array (Medium)
// https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

public class Q215M {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) {
            return nums[0];
        }

        PriorityQueue<Integer> largeNums = new PriorityQueue<Integer>();

        for(int i : nums) {
            largeNums.add(i);
            if(largeNums.size() > k) {
                largeNums.remove();
            }
        }

        return largeNums.remove();
    }
}
