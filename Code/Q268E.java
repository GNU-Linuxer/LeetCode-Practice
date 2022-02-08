// 268. Missing Number (Easy)
// https://leetcode.com/problems/missing-number/

import java.util.HashSet;
import java.util.Set;

public class Q268E {
    public int missingNumber(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for(int i : nums) { // Cue: numbers in nums are guaranteed to be unique
            numsSet.add(i);
        }
        for(int i = 0; i <= nums.length; i ++) { // use i < nums.length; will fail [0,1] case
            if(!numsSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
