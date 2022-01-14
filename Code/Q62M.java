// 62. Unique Paths
// https://leetcode.com/problems/unique-paths/

import java.util.Arrays;

public class Q62M {
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1) {
            return 1;
        }

        int[][] pathNum = new int[m][n];
        Arrays.fill(pathNum[0], 1);

        for(int r = 1; r < m; r ++) {
            for(int c = 0; c < n; c ++) {
                if(c == 0) {
                    pathNum[r][c] = 1;
                } else {
                    pathNum[r][c] = pathNum[r-1][c] + pathNum[r][c-1];
                }
            }
        }

        return pathNum[m-1][n-1];
    }
}