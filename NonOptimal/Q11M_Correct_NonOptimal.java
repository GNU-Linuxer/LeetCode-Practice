// 11. Container With Most Water (Medium)
// https://leetcode.com/problems/container-with-most-water/

// Solution is correct but exceeds time limit on large input
public class Q11M_Correct_NonOptimal {
    public int maxArea(int[] height) {
        int maxCap = Integer.MIN_VALUE;
        // Pruning
        for(int start = 0; start < height.length; start ++) {
            while(start < height.length && start > 0 && height[start] <= height[start - 1]) {
                start ++;
            }
            for(int end = height.length - 1; end >= start + 1; end --) {
                int left = height[start];
                int right = height[end];
                int cap = Math.min(left, right) * (end - start);
                maxCap = Math.max(cap, maxCap);
                while(end >= start + 1 && end < height.length - 1 && height[end - 1] <= height[end]) {
                    end --;
                }
            }
        }
        return maxCap;
    }
}
