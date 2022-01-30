// 57. Insert Interval (Medium)
// https://leetcode.com/problems/insert-interval/

import java.util.*;

public class Q57M {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Although the intervals can be null/empty, the newInterval is guaranteed to be valid and not empty
        if(intervals == null || intervals.length == 0) {
            int[][] res = {newInterval};
            return res;
        }

        // Java allows int[] as ADT type

        PriorityQueue<int[]> sortedInterval = new PriorityQueue<int[]>(intervals.length + 1, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        sortedInterval.add(newInterval);
        for(int[] arr : intervals) {
            sortedInterval.add(arr);
        }

        List<int[]> result = new ArrayList<int[]>();

        int start = sortedInterval.peek()[0];
        int end = sortedInterval.peek()[1];
        sortedInterval.remove();
        while(!sortedInterval.isEmpty()) {
            // you can safely assume that this selected interval does not start before the previously selected interval
            int[] selected = sortedInterval.remove();
            // the next interval does not connect with previous interval, add the previous interval to the result
            if(selected[0] > end) {
                int[] temp = {start, end};
                result.add(temp);
                start = selected[0];
                end = selected[1];
            }
            else if(selected[1] > end) {
                end = selected[1];
            }
        }
        int[] temp = {start, end};
        result.add(temp);

        int[][] resArr = new int[result.size()][2];
        for(int i = 0; i < result.size(); i ++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}
