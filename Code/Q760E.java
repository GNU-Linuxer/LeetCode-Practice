// 760. Find Anagram Mappings (Medium)
// https://leetcode.com/problems/find-anagram-mappings/

import java.util.*;

public class Q760E {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        if(nums1.length == 1) {
            int[] arr = {0};
            return arr;
        }

        Map<Integer, List<Integer>> valToIdx2 = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i < nums1.length; i ++) {
            int num2 = nums2[i];
            if(!valToIdx2.containsKey(num2)) {
                valToIdx2.put(num2, new ArrayList<Integer>());
            }
            valToIdx2.get(num2).add(i);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i ++) {
            int num1 = nums1[i];
            result[i] = valToIdx2.get(num1).remove(0);
        }
        return result;
    }
}
