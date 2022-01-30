// 274. H-Index (Medium)
// https://leetcode.com/problems/h-index/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q274M {
    public int hIndex(int[] citations) {
        // Create a sorted data structure in reverse order
        List<Integer> sortedCitation = new ArrayList<Integer>(citations.length);
        for(int i : citations) {
            sortedCitation.add(i);
        }

        Collections.sort(sortedCitation, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -a.compareTo(b);
            }
        });

        int H = 0;
        for(int i = 0; i < citations.length; i ++) {
            if(sortedCitation.get(i) >= i + 1) {
                H = i + 1;
            }
        }
        return H;
    }
}
