// 317. Shortest Distance from All Buildings (Hard)
// https://leetcode.com/problems/shortest-distance-from-all-buildings/

import java.util.*;

public class Q317H {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 1;
        }

        int numHouse = 0;
        // distanceToHouse[r][c][i] = at point[r][c], it takes distances to get to house[i]
        List<List<List<Integer>>> distanceToHouse = new ArrayList<List<List<Integer>>>();
        for(int r = 0; r < grid.length; r ++) {
            distanceToHouse.add(new ArrayList<List<Integer>>());
            for (int c = 0; c < grid[0].length; c ++) {
                distanceToHouse.get(r).add(new ArrayList<Integer>());
                if(grid[r][c] == 1) {
                    numHouse ++;
                }
            }
        }

        // Need to use another for-loop, otherwise the ArrayList might not be initialized
        for(int r = 0; r < grid.length; r ++) {
            for (int c = 0; c < grid[0].length; c ++) {
                if(grid[r][c] == 1) {
                    BFS(grid, distanceToHouse, r, c);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for(int r = 0; r < grid.length; r ++) {
            for(int c = 0; c < grid[0].length; c ++) {
                if(grid[r][c] == 0) { // we can only build house on an empty land
                    // Need to account for empty land that can't reach to any house (it being blocked by obstacle)
                    // Also need to account for land that can't reach to all houses (I missed this requirement)
                    if(distanceToHouse.get(r).get(c).size() == numHouse) {
                        minDistance = Math.min(minDistance, Sum(distanceToHouse.get(r).get(c)));
                    }
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int Sum(List<Integer> list) {

        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    private void BFS(int[][] grid, List<List<List<Integer>>> distanceToHouse, int r, int c){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue1 = new LinkedList<Pair>();
        queue1.add(new Pair(r,c));
        int level = 0;
        while(!queue1.isEmpty()) {
            Queue<Pair> queue2 = new LinkedList<Pair>();
            while(!queue1.isEmpty()) {
                Pair coord = queue1.remove();
                if(!visited[coord.r][coord.c]) {
                    visited[coord.r][coord.c] = true;
                    distanceToHouse.get(coord.r).get(coord.c).add(level);
                    if(coord.r - 1 >= 0 && grid[coord.r-1][coord.c] == 0) {
                        queue2.add(new Pair(coord.r-1, coord.c));
                    }
                    if(coord.r + 1 < grid.length && grid[coord.r+1][coord.c] == 0) {
                        queue2.add(new Pair(coord.r+1, coord.c));
                    }
                    if(coord.c - 1 >= 0 && grid[coord.r][coord.c-1] == 0) {
                        queue2.add(new Pair(coord.r, coord.c-1));
                    }
                    if(coord.c + 1 < grid[0].length && grid[coord.r][coord.c+1] == 0) {
                        queue2.add(new Pair(coord.r, coord.c+1));
                    }
                }
            }
            level ++;
            queue1 = queue2;
        }
    }

    // Need to conduct 2-D layered BFS (using 2 Queue method), so I need to create an auxiliary data structure
    private class Pair {
        public int r;
        public int c;
        public Pair(int a, int b) {
            r = a;
            c = b;
        }
        public boolean equals(Pair pair2){
            return this.r == pair2.r && this.c == pair2.c;
        }
    }

    public static void main(String[] args){
        Q317H test1 = new Q317H();
        int[][] arr1 = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println(test1.shortestDistance(arr1));

    }
}
