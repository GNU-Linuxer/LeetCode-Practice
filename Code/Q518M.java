// 518. Coin Change 2 (Medium)
// https://leetcode.com/problems/coin-change-2/

// Used the same DP approach of Q332, but the state transfer function is referred from this video (https://www.bilibili.com/video/BV1kX4y1P7M3)
// 直接从题目中的示例找法出发，DP就是在给你一个新的硬币的时候，通过从之前凑好的面值+当前新给的硬币看能不能凑出amount

public class Q518M {
    public int change(int amount, int[] coins) {
        int[] numOfWays = new int[amount + 1];
        numOfWays[0] = 1;
        for(int coin : coins) {
            for (int i = coin; i <= amount; i ++) {
                numOfWays[i] += numOfWays[i - coin];
            }
        }
        return numOfWays[amount];
    }

    public static void main(String[] args) {
        Q518M test1 = new Q518M();
        int[] arr = {1, 2, 5};
        System.out.println(test1.change(5, arr));
    }
}