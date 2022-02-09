// 73. Set Matrix Zeroes (Medium)
// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.HashSet;
import java.util.Set;

public class Q73M {
    public void setZeroes(int[][] matrix) {
        // Using a HashMap is a useful hint
        // O(2*mn) time and O(m+n) space

        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();

        for(int r = 0; r < matrix.length; r ++) {
            for(int c = 0; c < matrix[0].length; c ++) {
                if(matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }
        for(int r = 0; r < matrix.length; r ++) {
            for(int c = 0; c < matrix[0].length; c ++) {
                if(rows.contains(r) || cols.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
