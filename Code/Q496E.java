// 496. Next Greater Element I (Easy)
// https://leetcode.com/problems/next-greater-element-i/

import java.util.*;

public class Q496E {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums2.length == 1) {
            return nums2;
        }
        Stack<Integer> largeNum = new Stack<Integer>();
        Map<Integer, Integer> nextGreatEl = new HashMap<Integer, Integer>();
        for(int i = nums2.length - 1; i >= 0; i --) {
            int n = nums2[i];
            while(!largeNum.isEmpty() && nums2[i] > largeNum.peek()) { // Continuously pop off stack if the number in original array is smaller
                largeNum.pop();
            }
            nextGreatEl.put(n, largeNum.isEmpty() ? -1 : largeNum.peek());
            largeNum.push(n);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i ++) {
            result[i] = nextGreatEl.get(nums1[i]);
        }
        return result;
    }
}
