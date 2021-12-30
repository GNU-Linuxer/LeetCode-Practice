// 695. Max Area of Island (Medium)
// https://leetcode.com/problems/max-area-of-island/

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q695M {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            Arrays.fill(visited[r], false);
        }

        int largestIslandArea = 0;
        //List<Integer> islandAreas = new LinkedList<Integer>();
        // Need to re-think why adding the following line is necessary (the no island case)
        //islandAreas.add(0);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (!visited[r][c]) {
                    if (grid[r][c] == 1) {
                        int[] currIslandArea = new int[1];
                        countOnes(grid, r, c, visited, currIslandArea);
                        if(currIslandArea[0] > largestIslandArea) {
                            largestIslandArea = currIslandArea[0];
                        }
//                        islandAreas.add(currIslandArea[0]);
                    } else {
                        visited[r][c] = true;
                    }
                }
            }
        }
        return largestIslandArea;
    }

    private void countOnes(int[][] grid, int r, int c, boolean[][] visitedPtr, int[] currIslandAreaPtr) {
        // We're out of bounds
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            return;
        }

        if (grid[r][c] == 1 && !visitedPtr[r][c]) {
            visitedPtr[r][c] = true;
            currIslandAreaPtr[0] = currIslandAreaPtr[0] + grid[r][c];
            countOnes(grid, r - 1, c, visitedPtr, currIslandAreaPtr);
            countOnes(grid, r + 1, c, visitedPtr, currIslandAreaPtr);
            countOnes(grid, r, c + 1, visitedPtr, currIslandAreaPtr);
            // Need to re-think why adding the following line is necessary (see the grid3 test case)
            countOnes(grid, r, c - 1, visitedPtr, currIslandAreaPtr);
        }
    }

    public static void main(String[] args) {
        Q695M test1 = new Q695M();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int[][] grid2 = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 0, 0}};

        int[][] grid3 = {
                {0, 1},
                {1, 1}};

        System.out.println(test1.maxAreaOfIsland(grid3));
    }
}
