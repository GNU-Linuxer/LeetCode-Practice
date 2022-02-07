// 15. 3Sum (Medium)
// https://leetcode.com/problems/3sum/

// Previous attempt (Using HashMap), a better one (2-pointer) solution is in the ../Code directory
// Which was in wrong direction because we only need the value, not the nums[] indices
import java.util.*;
public class Q15M_Attempt_1 {
    public List<List<Integer>> threeSum(int[] nums) {


        // value -> all index in original array
        Map<Integer, List<Integer>> positiveNum = new TreeMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> nevativeNum = new TreeMap<Integer, List<Integer>>();
        Set<Integer> zeroIndex = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i ++) {
            int n = nums[i];
            if(n > 0) {
                if(!positiveNum.containsKey(n)) {
                    positiveNum.put(n, new ArrayList<Integer>());
                }
                positiveNum.get(n).add(i);
            } else if (n < 0) {
                if(!nevativeNum.containsKey(n)) {
                    nevativeNum.put(n, new ArrayList<Integer>());
                }
                nevativeNum.get(n).add(i);
            } else {
                zeroIndex.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(Map.Entry<Integer, List<Integer>> positives : positiveNum.entrySet()) {
            int key = positives.getKey();
            List<Integer> value = positives.getValue();

        }
        return result;
    }

    private static class Tuple {
        public int index;
        public int value;
        public Tuple(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    // Struct
    private static class Triplet {
        public int a;
        public int b;
        public int c;

        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public boolean equals(Triplet b) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(this.a);
            set.add(this.b);
            set.add(this.c);
            Set<Integer> set2 = new HashSet<Integer>();
            set2.add(b.a);
            set2.add(b.b);
            set2.add(b.c);
            return set.equals(set2);
        }
    }
}
