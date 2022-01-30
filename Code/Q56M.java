// 56. Merge Intervals (Medium)
// https://leetcode.com/problems/merge-intervals/

import java.util.*;

public class Q56M {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) {
            return intervals;
        }

        PriorityQueue<int[]> sortedInt = new PriorityQueue<int[]>(intervals.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int[] arr: intervals) {
            sortedInt.add(arr);
        }

        List<int[]> res = new ArrayList<int[]>();

        int start = sortedInt.peek()[0];
        int end = sortedInt.peek()[1];
        sortedInt.remove();
        while(!sortedInt.isEmpty()) {
            int[] curr = sortedInt.remove();
            if(curr[0] > end) {
                int[] tmp = {start, end};
                res.add(tmp);
                start = curr[0];
                end = curr[1];
            } else if (curr[1] > end) {
                end = curr[1];
            }
        }
        int[] tmp = {start, end};
        res.add(tmp);

        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i ++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
