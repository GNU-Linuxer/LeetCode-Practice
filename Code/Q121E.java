// 121. Best Time to Buy and Sell Stock (Easy)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Q121E {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) {
            return 0;
        }


        // profitSoFar[i][j] = profit so far on whether I'm holding (j=1) or not (j=0) stock on the i-th day
        int[][] profitSoFar = new int[prices.length][2];
        profitSoFar[0][0] = 0;
        profitSoFar[0][1] = 0-prices[0];
        for(int i = 1; i < prices.length; i ++) {
            // If I posess this stock at day i, it means I'm either buying it today or holding this stock.
            profitSoFar[i][1] = Math.max(profitSoFar[i-1][1], 0 - prices[i]); // Note that I can only buy the stock once (so start from profit=0 anyways)
            // If I did not posess this stock at day i, it means I'm either selling it today or continue not holding this stock.
            profitSoFar[i][0] = Math.max(profitSoFar[i-1][0], profitSoFar[i-1][1] + prices[i]);
        }

        return Math.max(Math.max(profitSoFar[prices.length - 1][0], profitSoFar[prices.length - 1][1]), 0);
    }

    public static void main(String[] args) {
        Q121E test1 = new Q121E();
        int[] arr1 = {7,1,5,3,6,4};
        System.out.println(test1.maxProfit(arr1));
    }
}
