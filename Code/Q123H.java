// 123. Best Time to Buy and Sell Stock III (Hard)
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

public class Q123H {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }

        // profitSoFar[i][j][k] = profit so far on whether I'm holding (j=1) or not (j=0) stock on the i-th day, performing k transactions
        int[][][] profitSoFar = new int[prices.length][2][3];
        profitSoFar[0][0][0] = 0; // do not hold stock at day 1
        profitSoFar[0][1][0] = 0-prices[0]; // hold stock at day 1
        for (int j = 0; j <= 1; j ++) {
            for (int k = 1; k < 3; k ++) {
                profitSoFar[0][j][k] = Integer.MIN_VALUE / 2; // These states can't exist (but a clever trick to prevent integer overflow)
            }
        }
        for(int i = 1; i < prices.length; i ++) {
            // k=0 is covered in array initialization above
            for(int k = 0; k < 3; k ++) {
                if(k != 0) {
                    // If I did not posess this stock at day i, it means I'm either selling it today or continue not holding this stock.
                    profitSoFar[i][0][k] = Math.max(profitSoFar[i - 1][0][k], profitSoFar[i - 1][1][k - 1] + prices[i]);
                }
                if(k == 2) {
                    profitSoFar[i][1][k] = Integer.MIN_VALUE / 2; // exceeds the limit of number of transaction
                } else {
                    // If I posess this stock at day i, it means I'm either buying it today or holding this stock.
                    profitSoFar[i][1][k] = Math.max(profitSoFar[i-1][1][k], profitSoFar[i-1][0][k] - prices[i]);
                }
            }
        }
        int profit = 0;
        for(int k = 0; k < 3; k ++) {
            profit = Math.max(profit, profitSoFar[prices.length - 1][0][k]);
            profit = Math.max(profit, profitSoFar[prices.length - 1][1][k]);
        }

        return profit;
    }

    public static void main(String[] args) {
        Q123H test1 = new Q123H();
        int[] arr1 = {3,3,5,0,0,3,1,4};
        int[] arr2 = {1,2,3,4,5};
        System.out.println(test1.maxProfit(arr2));
    }
}
