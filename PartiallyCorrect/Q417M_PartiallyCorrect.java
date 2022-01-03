// 417. Pacific Atlantic Water Flow (Medium)
// https://leetcode.com/problems/pacific-atlantic-water-flow/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q417M_PartiallyCorrect {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // It's a BFS/DFS and unlikely to be a DP problem (so try search without optimization first)
        // But it's actually better to determine which cell can reach to Pacific Ocean and which cell can reach to Atlantic Ocean (DP bottom-up approach)

        boolean[][] canPacific = new boolean[heights.length][heights[0].length];

        for(int r = 0; r < heights.length; r ++) {
            for (int c = 0; c < heights[0].length; c ++) {
                // First row and first column can dump to Pacific Ocean
                if(r == 0 || c == 0) {
                    canPacific[r][c] = true;
                }
                else if(heights[r-1][c] <= heights[r][c] || heights[r][c-1] <= heights[r][c]) {
                    canPacific[r][c] = canPacific[r-1][c] || canPacific[r][c-1];
                }
            }
            for (int c = heights[0].length - 2; c >= 1 ; c --) {
                if(r > 0)  {
                    // if(heights[r-1][c] <= heights[r][c] || heights[r][c-1] <= heights[r][c]) {
                    if(heights[r][c+1] <= heights[r][c] && canPacific[r][c+1]) { // Water can flow to the Atlantic direction (right) first and then flow back to Pacific (up)
                        canPacific[r][c] = true;
                    }
                }
            }
        }

        boolean[][] canAtlantic = new boolean[heights.length][heights[0].length];

        for(int r = heights.length - 1; r >= 0 ; r --) {
            for (int c = heights[0].length - 1; c >= 0 ; c --) {
                // Last row and last column can dump to Pacific Ocean
                if(r == heights.length - 1 || c == heights[0].length - 1) {
                    canAtlantic[r][c] = true;
                }
                else if(heights[r+1][c] <= heights[r][c] || heights[r][c+1] <= heights[r][c]) {
                    canAtlantic[r][c] = canAtlantic[r+1][c] || canAtlantic[r][c+1];
                }
            }
            for (int c = 1; c <= heights[0].length - 2; c ++) {
                if(r < heights.length - 1) {
                    if(heights[r][c-1] <= heights[r][c] && canAtlantic[r][c-1]) { // Water can flow to the Pacific direction (left) first and then flow back to Atlantic (down)
                        canAtlantic[r][c] = true;
                    }
                }
            }
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

    public static void main(String[] args) {
        Q417M_PartiallyCorrect test1 = new Q417M_PartiallyCorrect();
        int[][] arr1 = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        int[][] arr2 = {{1,2,3},{8,9,4},{7,6,5}};

        System.out.println(test1.pacificAtlantic(arr2));
    }
}