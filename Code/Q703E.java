// 703. Kth Largest Element in a Stream (Easy)
// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.PriorityQueue;

public class Q703E {
    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }
    static class KthLargest {

        int k;
        PriorityQueue<Integer> minHeap;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<Integer>();
            for(int i : nums) {
                minHeap.add(i);
                if(minHeap.size() > k) {
                    minHeap.remove();
                }
            }
        }

        public int add(int val) {
            minHeap.add(val);
            // Did not consider that nums can be empty (and constraints states that k >= 1)
            if(minHeap.size() > k) {
                minHeap.remove();
            }
            // It is guaranteed that there will be at least k elements in the array when you search for the kth element.
            return minHeap.peek();
        }
    }
}
