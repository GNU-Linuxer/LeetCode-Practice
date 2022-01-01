// 673. Number of Longest Increasing Subsequence (Medium)
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q673M_PartiallyCorrect {

    public int findNumberOfLIS(int[] nums) {
        if(nums == null) {
            return 0;
        }

        if(nums.length == 1) {
            return 1;
        }

        int[] maxSeq = new int[nums.length];
        Arrays.fill(maxSeq, 1); // Since each number itself can be its own geometric sequence of size 1
        int longestSeq = 0;

        for (int i = 0; i < nums.length; i ++) {
            int[] longSeqSoFarMarker= {0, 0};
            for (int j = 0; j < i; j ++) {
                if(nums[j] < nums[i] && maxSeq[j] > longSeqSoFarMarker[1]) {
                    longSeqSoFarMarker[1] = maxSeq[j];
                    longSeqSoFarMarker[0] = j;
                }
            }
            maxSeq[i] = maxSeq[i]+longSeqSoFarMarker[1];
            longestSeq = Math.max(longestSeq, maxSeq[i]);
        }

        int numSequence = 1;
        boolean findMaximum = false;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        // Find number of distinct increasing subsequence (not working)
        // for nums = [1, 2, 4, 3, 5, 4, 7, 2] maxSeq = [1, 2, 3, 3, 4, 4, 5, 2]
        // I attempted to find index that has same maxSeq but decreasing num, but it's still not working
        for (int j = nums.length - 1; j >= 0; j = j - 1) {
            if(maxSeq[j] == longestSeq) {
                findMaximum = true;
            }
            if(findMaximum) {
                if(!counts.containsKey(maxSeq[j])) {
                    counts.put(maxSeq[j], 1);
                } else if(!(j < nums.length-2 && nums[j] > nums[j+1] && maxSeq[j] == maxSeq[j+1])){
                    counts.put(maxSeq[j], counts.get(maxSeq[j]) + 1);
                }
            }
        }

        for (int key : counts.keySet()) {
            numSequence = numSequence * counts.get(key);
        }

        return numSequence;
    }

    public static void main(String[] args) {
        Q673M_PartiallyCorrect test1 = new Q673M_PartiallyCorrect();
        int[] arr1 = {1,3,5,4,7};
        // Expected: 3 ; My calculation: 4
        int[] arr2 = {1,2,4,3,5,4,7,2};

        System.out.println(test1.findNumberOfLIS(arr2));
    }
}
