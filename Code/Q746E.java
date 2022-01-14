// 746. Min Cost Climbing Stairs (Easy)
// https://leetcode.com/problems/min-cost-climbing-stairs/

public class Q746E {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length == 0) {
            return 0;
        }
        if(cost.length == 1) {
            return cost[0];
        }

        // minCost[i][j]: minimum cost so far to climb stair as of the i-th stair, whether we spend money (0/1 for j) to climb this i-th stair
        int[][] minCost = new int[cost.length][2];
        minCost[0][0] = 0;
        minCost[0][1] = cost[0];

        for(int i = 1; i < cost.length; i ++) {
            minCost[i][0] = minCost[i-1][1];
            minCost[i][1] = Math.min(minCost[i-1][0], minCost[i-1][1]) + cost[i];
        }

        return Math.min(minCost[cost.length - 1][0], minCost[cost.length - 1][1]);
    }

    public static void main(String[] args) {
        Q746E test1 = new Q746E();
        int[] arr1 = {3, 10, 15, 20};
        System.out.println(test1.minCostClimbingStairs(arr1));
    }
}
