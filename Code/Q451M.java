// 451. Sort Characters By Frequency (Medium)
// https://leetcode.com/problems/sort-characters-by-frequency/
import java.util.*;

public class Q451M {
    public String frequencySort(String s) {
        if(s.length() == 1 || s.length() == 2) {
            return s;
        }
        char[] sChar = s.toCharArray();
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for(char c : sChar) {
            if(!frequency.containsKey(c)) {
                frequency.put(c, 0);
            }
            frequency.put(c, frequency.get(c) + 1);
        }

        Map<Integer, List<Character>> revFreq = new TreeMap<Integer, List<Character>>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -(a-b); // Sort in reverse order
            }
        });

        for(Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            char c = entry.getKey();
            int i = entry.getValue();
            if(!revFreq.containsKey(i)) {
                revFreq.put(i, new ArrayList<Character>());
            }
            revFreq.get(i).add(c);
        }

        String result = "";

        for(Map.Entry<Integer, List<Character>> entry : revFreq.entrySet()) {
            int freq = entry.getKey();
            List<Character> cList = entry.getValue();
            for(Character c : cList) {
                for(int i = 1 ; i <= freq ; i ++) {
                    result = result + c;
                }
            }

        }

        return result;
    }
}
