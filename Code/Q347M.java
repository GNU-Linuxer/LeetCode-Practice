// 347. Top K Frequent Elements (Medium)
// https://leetcode.com/problems/top-k-frequent-elements/
import java.util.*;

public class Q347M {
    public int[] topKFrequent(int[] nums, int k) {
        // Num to Freq
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for(int i: nums) {
            if(!frequency.containsKey(i)) {
                frequency.put(i, 0);
            }
            frequency.put(i, frequency.get(i) + 1); // Different from x = change(x);
        }

        // Freq to num (decreasing order);
        Map<Integer, List<Integer>> revFreq = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -a.compareTo(b); // reverse sort
            }
        });

        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if(!revFreq.containsKey(freq)) {
                revFreq.put(freq, new ArrayList<Integer>());
            }
            revFreq.get(freq).add(num);
        }

        List<Integer> resultList = new ArrayList<Integer>();

        int i = 0;
        for(List<Integer> value : revFreq.values()) { // Reverse ordered TreeMap
            for(int val : value) {
                if(i < k) {
                    resultList.add(val);
                    i ++;
                } else {
                    break;
                }
            }
            if(i == k) {
                break;
            }
        }
        return resultList.stream().mapToInt(j->j).toArray();
    }
}