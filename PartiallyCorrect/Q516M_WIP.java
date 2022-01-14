// 516. Longest Palindromic Subsequence
// https://leetcode.com/problems/longest-palindromic-subsequence/

import java.util.Arrays;

public class Q516M_WIP {
    public int longestPalindromeSub(String s) {
        if(s == null && s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        int[] maxSeq = new int[s.length()];
        Arrays.fill(maxSeq, 1);
        int longestSeq = 0;

        for(int i = 1; i < s.length(); i ++) {
            int[] longestSeqSoFarMarker = {0,0};
            for(int j = 0; j < i; j ++) {
                // state change (only knows that when I proceed 1 index to the right, the left arrow proceed 1 index to the left to see whether we can find palindrome)


            }
            maxSeq[i] = maxSeq[i] + longestSeqSoFarMarker[1];
            if(maxSeq[i] > longestSeq) {
                longestSeq = maxSeq[i];
            }
        }

        return longestSeq;
    }
}
