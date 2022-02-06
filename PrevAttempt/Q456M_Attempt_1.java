// 456. 132 Pattern (Medium)
// https://leetcode.com/problems/132-pattern/

import java.util.Comparator;
import java.util.PriorityQueue;

// Fails at the [1,0,1,-4,-3] case
// Problem: my code can test 1 < 2 and 3 > 2 , but can not test 1 < 3 requirement (the code will return true even 1 > 3 if 1 < 2 and 3 > 2)

// Also fails at [3,5,0,3,4] and [3,1,4,2] case

public class Q456M_Attempt_1 {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        // We only need to find whether int[] nums contain 1 instance of 132 pattern
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -(a-b);
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        boolean found13 = false;
        for(int i : nums) {
            if(!minHeap.isEmpty() && i > minHeap.peek()) {
                maxHeap.add(i);
                found13 = true;
            }
            if(!found13) {
                minHeap.add(i);
            }
            if(found13) {
                if(!maxHeap.isEmpty() && i < maxHeap.peek()) {
                    return true;
                } else {
                    maxHeap.add(i);
                }
            }
        }
        return false;
    }
}
