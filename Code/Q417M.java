// 417. Pacific Atlantic Water Flow (Medium)
// https://leetcode.com/problems/pacific-atlantic-water-flow/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q417M {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // It's a BFS/DFS and unlikely to be a DP problem (so try search without optimization first)
        // But it's actually better to determine which cell can reach to Pacific Ocean and which cell can reach to Atlantic Ocean (DP bottom-up approach)

        boolean[][] canPacific = new boolean[heights.length][heights[0].length];
        boolean[][] canAtlantic = new boolean[heights.length][heights[0].length];

        for(int r = 0; r < heights.length; r ++) {
            DFS(canPacific, r, 0, Integer.MIN_VALUE, heights); // Left pacific ocean
            DFS(canAtlantic, r, heights[0].length - 1, Integer.MIN_VALUE, heights); // Right atlantic ocean
        }

        for(int c = 0; c < heights[0].length; c ++) {
            DFS(canPacific, 0, c, Integer.MIN_VALUE, heights); // top pacific ocean
            DFS(canAtlantic, heights.length - 1, c, Integer.MIN_VALUE, heights); // bottom atlantic ocean
        }


        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for(int r = 0; r < heights.length; r ++) {
            for (int c = 0; c < heights[0].length; c ++) {
                if(canPacific[r][c] && canAtlantic[r][c]) {
                    List<Integer> temp = new ArrayList<Integer>(2);
                    temp.add(r);
                    temp.add(c);
                    result.add(temp);
                }
            }

        }

        return result;
    }

    private void DFS(boolean[][] canOcean, int r, int c, int prev, int[][] heights) {
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) {
            return;
        }

        if(heights[r][c] < prev || canOcean[r][c]) {
            return;
        }
        canOcean[r][c] = true;
        DFS(canOcean, r + 1, c, heights[r][c], heights);
        DFS(canOcean, r - 1, c, heights[r][c], heights);
        DFS(canOcean, r, c + 1, heights[r][c], heights);
        DFS(canOcean, r, c - 1, heights[r][c], heights);
    }

    public static void main(String[] args) {
        Q417M test1 = new Q417M();
        int[][] arr1 = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] arr2 = {{1,2,3},{8,9,4},{7,6,5}};

        System.out.println(test1.pacificAtlantic(arr2));
    }
}