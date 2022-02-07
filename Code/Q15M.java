// 15. 3Sum (Medium)
// https://leetcode.com/problems/3sum/

import java.util.*;

public class Q15M {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3) { // Need at least 3 numbers to produce a valid result
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            // result.add(new LinkedList<List<Integer>>()); [[]] is not equal to []
            return result;
        }

        // O(n^2) time complexity (can't improve further). Brute force is O(n^3)

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // Reason that 2-Pointer approach on a sorted array would work: when I intentionally sort the original array,
        // if three number in different indices (with respect to the processed array) add up to zero,
        // it will fulfill the i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0 requirement (with respect to original array).
        // This is similar to (within a deck of 52 poker cards), if we remove any 1 card from the deck, you can guarantee that this card
        // will not get picked-up again to you if you remove another card.
        Arrays.sort(nums); // [-,-,-,-,0,0,0,0,0,+,+,+,+,+]
        for(int i = 0; i < nums.length; i ++) {
            int a = nums[i];
            if(a > 0) {
                break;
            }

            // The deduplication process is here (can't use while loop after the while loop below since the if(a>0) {break} can't be used, will fail on [-1,0,1,2,-1,-4] case)
            if (i > 0 && nums[i-1] == a && i < nums.length) { // use nums[i] == a; will fail at [0,0,0] case
                continue;
            }

            int low = i + 1;
            int high = nums.length - 1;
            while(low < high) {
                int b = nums[low];
                int c = nums[high];
                int sum = a + b + c;
                if(sum == 0) {
                    List<Integer> list = new ArrayList<Integer>(3);
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    result.add(list);
                    while(low <= high && nums[low] == b) {
                        low ++;
                    }
                } else if (sum < 0) {
                    while(low <= high && nums[low] == b) {
                        low ++;
                    }
                } else {
                    while(low <= high && nums[high] == c) {
                        high --;
                    }
                }
            }

            // The incorrect deduplication process is here
            // while(i > 0 && nums[i-1] == a && i < nums.length) { // use nums[i] == a; will fail at [0,0,0] case
            // i ++;
            // }
        }

        return result;
    }
}
