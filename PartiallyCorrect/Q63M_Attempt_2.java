// 63. Unique Paths II (Medium)
// https://leetcode.com/problems/unique-paths-ii/

public class Q63M_Attempt_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
            return 0;
        }
        int[] numPaths = {1};
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        DFS(obstacleGrid, 0, 0, numPaths, visited);
        return numPaths[0];
    }

    private void DFS(int[][] obstacleGrid, int r, int c, int[] numPaths, boolean[][] visited) {
        if(r < obstacleGrid.length && r < obstacleGrid.length) {
            visited[r][c] = true;
            int uniquePaths = 0;
            if(r+1 < obstacleGrid.length - 1 && obstacleGrid[r+1][c] == 0 && !visited[r+1][c]) {
                uniquePaths ++ ;
                DFS(obstacleGrid, r+1, c, numPaths, visited);
            }
            if(c < obstacleGrid[0].length - 1 && obstacleGrid[r][c+1] == 0 && !visited[r][c+1]) {
                uniquePaths ++ ;
                DFS(obstacleGrid, r, c+1, numPaths, visited);
            }
            if(uniquePaths == 2) {
                numPaths[0] = numPaths[0] + 1;
            }
        }
    }

}
