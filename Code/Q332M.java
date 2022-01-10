// 322. Coin Change (Medium)
// https://leetcode.com/problems/coin-change/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q332M {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        } else if (coins.length == 1 && (double)amount%coins[0] == 0) {
            return amount / coins[0];
        }

        int[] amountToCoin = new int[amount+1];
        Arrays.fill(amountToCoin, -1);

        int minCoin = Integer.MAX_VALUE;
        for(int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        // 1 coin can go to this amount; 2 coins can go to this amount
        Set<Integer> prevCoinNumAmount = new HashSet<Integer>();
        prevCoinNumAmount.add(0);
        for(int i = 1; i <= amount / minCoin; i ++) {
            Set<Integer> currCoinNumAmount = new HashSet<Integer>();
            for(int prevAmt : prevCoinNumAmount) {
                for (int coin : coins) {
                    if(coin <= amount - prevAmt) { // account for amount > Integer's max value 2^31 - 1; original statement: prevAmt + coin <= amount (which will result in integer overflow)
                        int newAmt = prevAmt + coin;
                        if(amountToCoin[newAmt] == -1) {
                            amountToCoin[newAmt] = i;
                            currCoinNumAmount.add(newAmt);
                        }
                    }
                }
            }
            if(amountToCoin[amount] != -1) {
                return i;
            }
            prevCoinNumAmount = currCoinNumAmount;
        }

        return amountToCoin[amount];
    }

    public static void main(String[] args) {
        Q332M test1 = new Q332M();
        int[] arr1 = {1, 2147483647};
        System.out.println(test1.coinChange(arr1, 2));
    }
}
