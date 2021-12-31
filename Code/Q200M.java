// 200. Number of Islands (Medium)
// https://leetcode.com/problems/number-of-islands/

import java.util.Arrays;

public class Q200M {
    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        int numIsland = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (!visited[r][c] && grid[r][c] == '1') {
                    exploreThisIsland(grid, visited, r, c);
                    numIsland++;
                } else if (!visited[r][c] && grid[r][c] == '0') {
                    visited[r][c] = true;
                }
            }
        }

        return numIsland;
    }

    private void exploreThisIsland(char[][] gridPtr, boolean[][] visitedPtr, int r, int c) {
        if (r < 0 || c < 0 || r >= gridPtr.length || c >= gridPtr[0].length) {
            return;
        }

        if (!visitedPtr[r][c] && gridPtr[r][c] == '1') {
            visitedPtr[r][c] = true;
            exploreThisIsland(gridPtr, visitedPtr, r - 1, c);
            exploreThisIsland(gridPtr, visitedPtr, r + 1, c);
            exploreThisIsland(gridPtr, visitedPtr, r, c + 1);
            exploreThisIsland(gridPtr, visitedPtr, r, c - 1);
        }
    }

    public static void main(String[] args) {
        Q200M test1 = new Q200M();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        System.out.println(test1.numIslands(grid));
    }
}
