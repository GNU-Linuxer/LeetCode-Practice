// 1. Two Sum (Easy)
// https://leetcode.com/problems/two-sum/

import java.util.*;

public class Q1E {
    public int[] twoSum(int[] nums, int target) {
        // Only one valid answer exist: greedy algorithm
        Map<Integer, List<Integer>> valueIndex = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -(a-b); // Reverse key order
            }
        }); // use List<Integer> as the value since multiple slots can hold same number

        for(int i = 0; i < nums.length; i ++) {
            int n = nums[i];
            if(!valueIndex.containsKey(n)) {
                valueIndex.put(n, new ArrayList<Integer>());
            }
            valueIndex.get(n).add(i);
        }

        int[] result = new int[2];

        for(Map.Entry<Integer,List<Integer>> entry : valueIndex.entrySet()) {
            int key = entry.getKey();
            List<Integer> value = entry.getValue();
            int remain = target - key;
            if(remain == key && value.size() >= 2) { // 3 + 3 = 6 case
                result[0] = value.get(0);
                result[1] = value.get(1);
                return result;
            } else if (remain != key && valueIndex.containsKey(remain)) { // 3 + 3 = 6 if we only has one 3, we need to skip this candidate
                result[0] = value.get(0);
                result[1] = valueIndex.get(remain).get(0);
                return result;
            }
        }

        int[] res = {-1};
        return res;
    }
}
