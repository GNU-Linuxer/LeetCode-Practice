// 48. Rotate Image (Medium)
// https://leetcode.com/problems/rotate-image/

import java.util.*;
public class Q48M {
    public void rotate(int[][] matrix) {
        // Recursion (number of cascading squares are unknown)
        rotate(matrix, 0, matrix.length);

    }
    private void rotate(int[][] matrix, int start, int numToRotate) {
        // When the side length of original square is an odd number, the inner-most single element (square's center) should not be changed
        if(numToRotate == 0 || numToRotate == 1) {
            return;
        }
        Queue<Integer> queue = new LinkedList<Integer>(); // O(N) space complexity, but less than entire array
        for(int c = start; c < start + numToRotate - 1; c ++) {
            queue.add(matrix[start][c]);
        }
        String dir = "Down";
        while(!dir.equals("exit")) {
            for(int i = 0; i < numToRotate - 1; i ++) {
                if(dir == "Down") {
                    int oldNum = matrix[start+i][start + numToRotate-1];
                    matrix[start+i][start + numToRotate-1] = queue.remove();
                    queue.add(oldNum);
                    if(i == numToRotate -2) {
                        dir = "Left";
                    }
                }
                else if(dir == "Left") {
                    int oldNum = matrix[start+numToRotate-1][start + numToRotate - i -1];
                    matrix[start+numToRotate-1][start + numToRotate - i -1] = queue.remove();
                    queue.add(oldNum);
                    if(i == numToRotate -2) {
                        dir = "Up";
                    }
                }
                else if(dir == "Up") {
                    int oldNum = matrix[start + numToRotate - i -1][start];
                    matrix[start + numToRotate - i -1][start] = queue.remove();
                    queue.add(oldNum);
                    if(i == numToRotate -2) {
                        dir = "Right";
                    }
                }
                else if(dir == "Right") {
                    int oldNum = matrix[start][start + i];
                    matrix[start][start + i] = queue.remove();
                    queue.add(oldNum);
                    if(i == numToRotate -2) {
                        dir = "exit";
                    }
                }
            }
        }
        rotate(matrix, start + 1, numToRotate - 2);
    }

    public static void main(String[] args) {
        Q48M test1 = new Q48M();
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        test1.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }
}
