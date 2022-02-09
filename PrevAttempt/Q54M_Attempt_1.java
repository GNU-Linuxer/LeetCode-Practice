// 54. Spiral Matrix (Medium)
// https://leetcode.com/problems/spiral-matrix/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This will fail on 5x5 case, so I proceed to different approach
public class Q54M_Attempt_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>(matrix.length * matrix[0].length);
        // Boundaries
        // This approach uses O(m+n) space, rather than O(m*n) space when storing all visited cells' coordinates
        Set<Integer> visitedRows = new HashSet<Integer>();
        Set<Integer> visitedCols = new HashSet<Integer>();

        int r = 0;
        int c = 0;
        // Need to handle 1 x n grid case
        String dir = matrix[0].length == 1 ? "Down" : "Right";
        while(!dir.equals("Exit")) {
            int num = matrix[r][c];
            result.add(num);
            if(dir.equals("Right")) {
                int nextCol = c + 1;
                // Trapped (3 x 3 grid)
                if(visitedCols.contains(nextCol) && visitedRows.contains(r + 1)) {
                    dir = "Exit";
                }
                // Trapped (n x 1 grid)
                else if (matrix.length == 1 && nextCol >= matrix[0].length) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visitedCols.contains(nextCol) || nextCol >= matrix[0].length) {
                    visitedRows.add(r);
                    dir = "Down";
                    r = r + 1;
                } else {
                    c = c + 1;
                }
            }
            else if(dir.equals("Down")) {
                int nextRow = r + 1;
                // Trapped (3 x 4 grid)
                if(visitedRows.contains(nextRow) && visitedCols.contains(c - 1)) {
                    dir = "Exit";
                }
                // Trapped (1 x n grid)
                else if (matrix[0].length == 1 && nextRow >= matrix.length) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visitedRows.contains(nextRow) || nextRow >= matrix.length) {
                    visitedCols.add(c);
                    dir = "Left";
                    c = c - 1;
                } else {
                    r = r + 1;
                }
            }
            else if(dir.equals("Left")) {
                int nextCol = c - 1;
                int nextRow = r - 1;
                // Trapped (4 x 4 grid)
                if(visitedCols.contains(nextCol) && visitedRows.contains(r - 1)) {
                    dir = "Exit";
                }
                // Trapped (2 x n grid)
                else if (visitedRows.contains(nextRow) && nextCol < 0) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visitedCols.contains(nextCol) || nextCol < 0) {
                    visitedRows.add(r);
                    dir = "Up";
                    r = r - 1;
                } else {
                    c = c - 1;
                }
            }
            else if (dir.equals("Up")) {
                int nextCol = c + 1;
                int nextRow = r - 1;
                // Trapped (4 x 5 grid)
                if(visitedRows.contains(nextRow) && visitedCols.contains(c - 1)) {
                    dir = "Exit";
                }
                // Trapped (n x 2 grid)
                else if (visitedRows.contains(nextRow) && visitedCols.contains(nextCol)) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visitedRows.contains(nextRow) || nextRow < 0) {
                    visitedCols.add(c);
                    dir = "Right";
                    c = c + 1;
                } else {
                    r = r - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q54M_Attempt_1 test1 = new Q54M_Attempt_1();
        int[][] matrix1 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(test1.spiralOrder(matrix1));
    }
}
