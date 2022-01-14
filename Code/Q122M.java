// 122. Best Time to Buy and Sell Stock II (Medium)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class Q122M {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }

        // profitSoFar[i][j] = profit so far on whether I'm holding (j=1) or not (j=0) stock on the i-th day
        int[][] profitSoFar = new int[prices.length][2];
        profitSoFar[0][0] = 0;
        profitSoFar[0][1] = 0-prices[0];
        for(int i = 1; i < prices.length; i ++) {
            // If I did not posess this stock at day i, it means I'm either selling it today or continue not holding this stock.
            profitSoFar[i][0] = Math.max(profitSoFar[i-1][0], profitSoFar[i-1][1] + prices[i]);
            // If I posess this stock at day i, it means I'm either buying it today or holding this stock.
            profitSoFar[i][1] = Math.max(profitSoFar[i-1][1], profitSoFar[i-1][0] - prices[i]);

        }

        return Math.max(Math.max(profitSoFar[prices.length - 1][0], profitSoFar[prices.length - 1][1]), 0);
    }
}
