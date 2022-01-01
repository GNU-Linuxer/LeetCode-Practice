// 673. Number of Longest Increasing Subsequence (Medium)
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

import java.util.*;

public class Q673M_NEW_WIP {

    public int findNumberOfLIS(int[] nums) {
        if(nums == null) {
            return 0;
        }

        if(nums.length == 1) {
            return 1;
        }

        // Still need to store maxSeq that's used in the regular longest increasing subsequence problem
        int[] maxSeq = new int[nums.length];
        // Compare to the regular longest increasing subsequence problem, I need to store another state to store number of unique longest subsequence so far
        int[] count = new int[nums.length];
        Arrays.fill(count, 0);
        count[0] = 1;
        int numSeq = 0;

        for (int i = 0; i < nums.length; i ++) {
            maxSeq[i] = 1;
            int[] longSeqSoFarMarker= {0, 0};
            for (int j = 0; j < i; j ++) {
                if(nums[j] < nums[i] && maxSeq[j] > longSeqSoFarMarker[1]) {
                    longSeqSoFarMarker[1] = maxSeq[j];
                    longSeqSoFarMarker[0] = j;
                }
            }
            maxSeq[i] = maxSeq[i]+longSeqSoFarMarker[1];
            // Try this approach https://www.bilibili.com/video/BV1gT4y1F7y3?from=search&seid=542367467162948739&spm_id_from=333.337.0.0
            if(i >= 1) {
                if(nums[i] > nums[i-1]) {
                    count[i] = count(maxSeq, maxSeq[i-1]);
                } else {
                    count[i] = count[i-1];
                }
            }
            numSeq = Math.max(numSeq, count[i]);
        }
        return numSeq;
    }

    private static int count(int[] arr, int target) {
        int count = 0;
        for(int i : arr) {
            if(i == target) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q673M_NEW_WIP test1 = new Q673M_NEW_WIP();
        int[] arr1 = {1,3,5,4,7};
        // Expected: 3 ; My calculation: 4
        int[] arr2 = {1,2,4,3,5,4,7,2};

        System.out.println(test1.findNumberOfLIS(arr2));
    }
}
