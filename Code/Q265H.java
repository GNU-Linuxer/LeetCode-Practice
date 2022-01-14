// 265. Paint House II (Hard)
// https://leetcode.com/problems/paint-house-ii/

public class Q265H {
    public int minCostII(int[][] costs) {
        int minColor = Integer.MAX_VALUE;
        // minCost[i][j] = the minimum cost so far if we paint i-th house with j-th color
        int[][] minCost = new int[costs.length][costs[0].length];
        for(int color = 0; color < costs[0].length; color ++) {
            minCost[0][color] = costs[0][color];
            if(costs.length == 1) {
                minColor = Math.min(minColor, costs[0][color]);
            }
        }


        for(int i = 1; i < costs.length; i ++) {
            for(int color = 0; color < costs[0].length; color ++) {
                int minPrevColor = Integer.MAX_VALUE;
                for(int prevColor = 0; prevColor < costs[0].length; prevColor ++) {
                    if(color != prevColor) {
                        minPrevColor = Math.min(minPrevColor, minCost[i - 1][prevColor]);
                    }
                }
                minCost[i][color] = minPrevColor + costs[i][color];

                if(i == costs.length - 1) {
                    minColor = Math.min(minColor, minCost[i][color]);
                }
            }
        }

        return minColor;
    }
}
