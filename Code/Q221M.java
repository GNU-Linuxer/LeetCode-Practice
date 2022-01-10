// 221. Maximal Square (Medium)
// https://leetcode.com/problems/maximal-square/

public class Q221M {
    public int maximalSquare(char[][] matrix) {
        int maxTableSideLength = Integer.MIN_VALUE;
        int[][] area = new int[matrix.length][matrix[0].length];

        for(int r = 0; r < matrix.length; r ++) {
            for (int c = 0; c < matrix[0].length; c ++) {
                if(matrix[r][c] == '0') {
                    area[r][c] = 0;
                }
                // First row and first column special case: verbatimly copy content
                else if(r == 0 || c == 0) {
                    area[r][c] = Character.getNumericValue(matrix[r][c]);
                }
                else {
                    // If we reach to here, matrix[r][c] must = '1', not first row nor column
                    area[r][c] = Math.min(Math.min(area[r-1][c], area[r][c-1]), area[r-1][c-1]) + 1;
                }
                maxTableSideLength = Math.max(maxTableSideLength, area[r][c]);
            }
        }

        return maxTableSideLength*maxTableSideLength;
    }

    public static void main(String[] args) {
        Q221M test1 = new Q221M();
        char[][] CSE417 = {
                {'0','0','0','1','1','0','0'},
                {'1','1','1','1','1','1','0'},
                {'1','1','0','1','1','1','0'},
                {'0','1','1','1','1','1','0'},
                {'0','0','1','1','1','1','0'},
                {'0','0','1','0','0','0','0'}
        };

        char[][] arr1 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        //System.out.println(test1.maximalSquare(CSE417));
        System.out.println(test1.maximalSquare(arr1));
    }
}