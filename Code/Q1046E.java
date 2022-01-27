// 1046. Last Stone Weight (Easy)
// https://leetcode.com/problems/last-stone-weight/

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1046E {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> sortedStone = new PriorityQueue<Integer>(stones.length, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -a.compareTo(b);
            }
        });

        for(int i : stones) {
            sortedStone.add(i);
        }

        while(sortedStone.size() >= 2) {
            int a = sortedStone.remove();
            int b = sortedStone.remove();
            if(a != b) {
                sortedStone.add(Math.abs(a - b));
            }
        }

        return sortedStone.isEmpty() ? 0 : sortedStone.remove();
    }
}
