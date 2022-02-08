// 253. Meeting Rooms II (Medium)
// https://leetcode.com/problems/meeting-rooms-ii/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q253M {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }
        PriorityQueue<int[]> sortedIntervals = new PriorityQueue<int[]>(intervals.length, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });

        for (int[] interval : intervals) {
            sortedIntervals.add(interval);
        }

        int start = sortedIntervals.peek()[0];
        int end = sortedIntervals.peek()[1];
        sortedIntervals.remove();
        List<Integer> rooms = new ArrayList<Integer>(); // Record the END time of all used meeting room
        rooms.add(end);
        while (!sortedIntervals.isEmpty()) {
            int[] selected = sortedIntervals.remove();
            int earliestAvailable = Integer.MAX_VALUE;
            int earlyIndex = -1;
            for (int i = 0; i < rooms.size(); i++) {
                int room = rooms.get(i);
                // Greedy algorithm
                if (selected[0] >= room && room < earliestAvailable) {
                    earlyIndex = i;
                    earliestAvailable = room;
                }
            }
            if (earlyIndex >= 0) {
                rooms.set(earlyIndex, selected[1]);
            } else {
                rooms.add(selected[1]); // We don't de-allocate a room in future (we just need to know most rooms we need at any point)
            }
        }
        return rooms.size();
    }

    public static void main(String[] args) {
        Q253M test1 = new Q253M();
        int[][] arr1 = {{1, 5}, {8, 9}, {8, 9}};
        System.out.println(test1.minMeetingRooms(arr1));
    }
}
