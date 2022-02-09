// 54. Spiral Matrix (Medium)
// https://leetcode.com/problems/spiral-matrix/

import java.util.*;

public class Q54M {
    private static class Coord {
        public final int r;
        public final int c;
        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Coord)) {
                return false;
            }
            Coord b = (Coord) o;
            return this.r == b.r && this.c == b.c;
        }

        @Override
        public int hashCode() {
            return (this.r + this.c) % 100;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>(matrix.length * matrix[0].length); // O(m*n) space complexity

        // You can't override equals without overriding hashcode, hence need to create custom data structure
        Set<Coord> visited = new HashSet<Coord>(); // O(m*n) space complexity

        int r = 0;
        int c = 0;
        // Need to handle 1 x n grid case
        String dir = matrix[0].length == 1 ? "Down" : "Right";
        while(!dir.equals("Exit")) {
            int num = matrix[r][c];
            result.add(num);
            visited.add(new Coord(r, c));
            if(dir.equals("Right")) {
                int nextCol = c + 1;
                // Trapped (3 x 3 grid)
                if(visited.contains(new Coord(r, nextCol)) && visited.contains(new Coord(r + 1, c))) {
                    dir = "Exit";
                }
                // Trapped (n x 1 grid)
                else if (matrix.length == 1 && nextCol >= matrix[0].length) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visited.contains(new Coord(r, nextCol)) || nextCol >= matrix[0].length) {
                    dir = "Down";
                    r = r + 1;
                } else {
                    c = c + 1;
                }
            }
            else if(dir.equals("Down")) {
                int nextRow = r + 1;
                // Trapped (3 x 4 grid)
                if(visited.contains(new Coord(nextRow, c)) && visited.contains(new Coord(r, c - 1))) {
                    dir = "Exit";
                }
                // Trapped (1 x n grid)
                else if (matrix[0].length == 1 && nextRow >= matrix.length) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visited.contains(new Coord(nextRow, c)) || nextRow >= matrix.length) {
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
                if(visited.contains(new Coord(r, nextCol)) && visited.contains(new Coord(nextRow, c))) {
                    dir = "Exit";
                }
                // Trapped (2 x n grid)
                else if (visited.contains(new Coord(nextRow, c)) && nextCol < 0) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visited.contains(new Coord(r, nextCol)) || nextCol < 0) {
                    dir = "Up";
                    r = r - 1;
                } else {
                    c = c - 1;
                }
            }
            else if (dir.equals("Up")) {
                int nextCol = c + 1;
                int nextRow = r - 1;
                // Trapped (n x 2 grid) and (4 x 5 grid)
                if(visited.contains(new Coord(nextRow, c)) && visited.contains(new Coord(r, nextCol))) {
                    dir = "Exit";
                }
                // Bump to wall
                else if(visited.contains(new Coord(nextRow, c)) || nextRow < 0) {
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
        Set<Coord> visited = new HashSet<Coord>();
        visited.add(new Coord(0, 0));
        boolean contains = visited.contains(new Coord(0, 0)); // Needs to be true;
        System.out.println(contains);

        Q54M test1 = new Q54M();
        int[][] matrix1 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(test1.spiralOrder(matrix1));
    }
}
