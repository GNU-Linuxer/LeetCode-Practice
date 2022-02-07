// 11. Container With Most Water (Medium)
// https://leetcode.com/problems/container-with-most-water/

public class Q11M {
    public int maxArea(int[] height) {
        int maxCap = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        while(start < end) {
            int left = height[start];
            int right = height[end];
            int cap = Math.min(left, right) * (end - start);
            maxCap = Math.max(cap, maxCap);
            if(left <= right) {
                start ++;
            } else {
                end --;
            }
        }
        return maxCap;
    }
}
