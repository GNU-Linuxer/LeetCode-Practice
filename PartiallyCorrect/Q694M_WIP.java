// 694. Number of Distinct Islands (Medium)
// https://leetcode.com/problems/number-of-distinct-islands/

import java.util.HashSet;
import java.util.Set;

public class Q694M_WIP {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<Integer> islandSizes = new HashSet<Integer>();
        islandSizes.add(0);

        for(int r = 0; r < grid.length; r ++) {
            for(int c = 0; c < grid[0].length; c ++) {
                if(!visited[r][c]) {
                    if(grid[r][c] == 1) {
                        int[] currIslandSize = {0};
                        islandSize(grid, visited, r, c, currIslandSize);
                        islandSizes.add(currIslandSize[0]);
                    } else {
                        visited[r][c] = true;
                    }
                }
            }
        }

        if(islandSizes.size() == 1) {
            return 0;
        } else {
            return islandSizes.size() - 1;
        }
    }

    private void islandSize(int[][] gridsPtr, boolean[][] visitedPtr, int r, int c, int[] currIslandSizePtr) {
        if(r < 0 || c < 0 || r >= gridsPtr.length || c >= gridsPtr[0].length) {
            return;
        }

        if(!visitedPtr[r][c] && gridsPtr[r][c] == 1) {
            visitedPtr[r][c] = true;
            currIslandSizePtr[0] = currIslandSizePtr[0] + 1;
            islandSize(gridsPtr, visitedPtr, r - 1, c, currIslandSizePtr);
            islandSize(gridsPtr, visitedPtr, r + 1, c, currIslandSizePtr);
            islandSize(gridsPtr, visitedPtr, r, c + 1, currIslandSizePtr);
            islandSize(gridsPtr, visitedPtr, r, c - 1, currIslandSizePtr);
            return;
        }

        if (!visitedPtr[r][c] && gridsPtr[r][c] == 0){
            visitedPtr[r][c] = true;
            return;
        }
    }

    public static void main(String[] args) {
        Q694M_WIP test1 = new Q694M_WIP();
        int[][] arr = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}};
        System.out.println(test1.numDistinctIslands(arr));

    }
}