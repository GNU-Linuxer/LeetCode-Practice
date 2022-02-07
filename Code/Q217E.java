// 217. Contains Duplicate (Easy)
// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class Q217E {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1) {
            return false;
        }

        Set<Integer> distinctNum = new HashSet<Integer>();
        for (int i : nums) {
            if(distinctNum.contains(i)) {
                return true;
            }
            distinctNum.add(i);
        }
        return false;
    }
}
