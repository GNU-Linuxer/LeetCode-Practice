// 63. Unique Paths II (Medium)
// https://leetcode.com/problems/unique-paths-ii/

public class Q63M {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Can't start from source
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        // Unreachable destination
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
            return 0;
        }


        int[][] numPath = new int[obstacleGrid.length][obstacleGrid[0].length];
        numPath[0][0] = 1; // Initialize DP

        for(int r = 0; r < obstacleGrid.length; r ++) {
            for(int c = 0; c < obstacleGrid[0].length; c ++) {
                // First row
                if(r == 0 && c > 0) {
                    // Obstacle on left
                    if(obstacleGrid[r][c-1] == 1) {
                        numPath[r][c] = 0; // can't move right anymore
                    }
                    else {
                        numPath[r][c] = numPath[r][c-1];
                    }
                }
                // First column
                else if(c == 0 && r > 0) {
                    // Obstacle on top
                    if(obstacleGrid[r-1][c] == 1) {
                        numPath[r][c] = 0; // can't move down anymore
                    }
                    else {
                        numPath[r][c] = numPath[r-1][c];
                    }
                }
                // Everything beside upper-left cell
                else if(r > 0 && c > 0) {
                    // Obstacle on left and top
                    if(obstacleGrid[r-1][c] == 1 && obstacleGrid[r][c-1] == 1) {
                        numPath[r][c] = 0; // no possible move
                    }
                    // Obstacle on top
                    else if(obstacleGrid[r-1][c] == 1) {
                        numPath[r][c] = numPath[r][c-1]; // can only move right
                    }
                    // Obstacle on left
                    else if(obstacleGrid[r][c-1] == 1) {
                        numPath[r][c] = numPath[r-1][c]; // can only move down
                    }
                    else {
                        numPath[r][c] = numPath[r][c-1] + numPath[r-1][c];
                    }
                }
            }
        }
        return numPath[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
    public static void main(String[] args) {
        Q63M test1 = new Q63M();
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] arr2 = {{0,0},{0,0}};
        System.out.println(test1.uniquePathsWithObstacles(arr2));
    }
}
