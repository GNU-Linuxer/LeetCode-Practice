// 300. Longest Increasing Subsequence (Medium)
// https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

public class Q300M {
    public int lengthOfLIS(int[] nums) {
        int[] maxSeq = new int[nums.length];
        Arrays.fill(maxSeq, 1); // Since each number itself can be its own geometric sequence of size 1
        int longestSeq = 0;

        for (int i = 0; i < nums.length; i++) {
            // [1] is the number of longest geometrically increasing subsequence, and [0] is the index of the
            // last element (with respect to int[] nums) within this subsequence
            int[] longSeqSoFarMarker = {0, 0};
            for (int j = 0; j < i; j++) { // which is better than nested for-loop in lis(int[] nums)
                // For simplicity, you may assume there are no indices i, j such that 3A[i] = A[j]
                // and that there are no repeated elements.

                // The (3 * nums[j] < nums[i] && maxSeq[j] > longSeqSoFarMarker[1]) comes from the longest geometric
                // increasing subsequence problem from CSE 417, where n needs to be at least 3*(n-1) element
                if (nums[j] < nums[i] && maxSeq[j] > longSeqSoFarMarker[1]) {
                    longSeqSoFarMarker[1] = maxSeq[j];
                    longSeqSoFarMarker[0] = j;
                }
            }
            maxSeq[i] = maxSeq[i] + longSeqSoFarMarker[1];
            if (maxSeq[i] > longestSeq) {
                longestSeq = maxSeq[i];
            }
        }
        return longestSeq;
    }

    public static void main(String[] args) {
        Q300M test1 = new Q300M();
        System.out.println(test1.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
