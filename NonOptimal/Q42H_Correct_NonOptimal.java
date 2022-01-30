// 42. Trapping Rain Water (Hard)
// https://leetcode.com/problems/trapping-rain-water/

// Solution is correct but exceeds time limit
public class Q42H_Correct_NonOptimal {
    public int trap(int[] height) {
        // Can't trap any rain water using 2 adjacent walls
        if(height.length == 1 || height.length == 2) {
            return 0;
        }
        int maxHeight = 0;
        for(int h : height) {
            maxHeight = Math.max(maxHeight, h);
        }

        int rainWater = 0;
        int startIndex = -1; // Need to use -1 instead of 0 to account for wall on height[0]
        // y-axis
        for(int h = 1; h <= maxHeight; h ++) {
            startIndex = -1;
            // x-axis
            for(int i = 0; i < height.length; i ++) {
                if(height[i] >= h) {
                    if(startIndex == -1) {
                        startIndex = i;
                    }
                    // We find two walls, add water in the middle.
                    else {
                        rainWater = rainWater + (i - startIndex - 1);
                        startIndex = i;
                    }
                }
            }
        }

        return rainWater;
    }
}
