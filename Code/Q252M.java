// 252. Meeting Rooms (Easy)
// https://leetcode.com/problems/meeting-rooms/

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q252M {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals.length == 1) {
            return true;
        }

        PriorityQueue<int[]> sortedIntervals = new PriorityQueue<int[]>(intervals.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });

        for(int[] interval : intervals) {
            sortedIntervals.add(interval);
        }

        int start = sortedIntervals.peek()[0];
        int end = sortedIntervals.peek()[1];
        sortedIntervals.remove();
        while(!sortedIntervals.isEmpty()) {
            int[] selected = sortedIntervals.remove();
            if(selected[0] < end) {
                return false;
            }
            start = selected[0];
            end = selected[1];
        }

        return true;
    }
}
