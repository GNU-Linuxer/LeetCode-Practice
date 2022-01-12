// 63. Unique Paths II (Medium)
// https://leetcode.com/problems/unique-paths-ii/

public class Q63M_Attempt_1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Can't start from source (test case: [[1,0]])
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        // Unreachable destination
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
            return 0;
        }
        int[] numPaths = {1};
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        DFS(obstacleGrid, 0, 0, numPaths, visited);
        return visited[obstacleGrid.length-1][obstacleGrid[0].length-1] ? numPaths[0] : 0;
    }

    private void DFS(int[][] obstacleGrid, int r, int c, int[] numPaths, boolean[][] visited) {
        // Robot reaches to lower-right corner, stop recurse
        if(r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) {
            visited[r][c] = true;
            return;
        }

        if(r < obstacleGrid.length && c < obstacleGrid[0].length) {
            visited[r][c] = true;
            int uniquePaths = 0;
            // Robot can move 1 cell down if there's no obstacle
            if(r < obstacleGrid.length - 1 && obstacleGrid[r+1][c] == 0 && !visited[r+1][c]) {
                uniquePaths ++ ;
                DFS(obstacleGrid, r+1, c, numPaths, visited);
            }
            // Robot can move 1 cell right if there's no obstacle
            if(c < obstacleGrid[0].length - 1 && obstacleGrid[r][c+1] == 0 && !visited[r][c+1]) {
                uniquePaths ++ ;
                DFS(obstacleGrid, r, c+1, numPaths, visited);
            }
            // If robot can both move 1 cell down and 1 cell right, there's 1 more path to explore
            if(uniquePaths == 2) {
                numPaths[0] = numPaths[0] + 1;
            }
        }
    }

    public static void main(String[] args) {
        Q63M_Attempt_1 test1 = new Q63M_Attempt_1();
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] arr2 = {{0,0},{0,0}};
        System.out.println(test1.uniquePathsWithObstacles(arr2));
    }

}
