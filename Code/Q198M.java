// 198. House Robber (Medium)
// https://leetcode.com/problems/house-robber/
public class Q198M {
    public int rob(int[] nums) {
        // int[x][y] = amount of money I can earn so far on whether I robbed x house (y=1) or not robbed this house (y=0)
        int[][] earnSoFar = new int[nums.length][2]; // auto initialize array to 0;
        for(int i = 0; i < nums.length; i ++) {
            if(i == 0) {
                earnSoFar[i][1] = nums[i];
            } else {
                earnSoFar[i][0] = Math.max(earnSoFar[i-1][0], earnSoFar[i-1][1]);
                earnSoFar[i][1] = earnSoFar[i-1][0] + nums[i];
            }
        }
        return Math.max(earnSoFar[nums.length-1][0], earnSoFar[nums.length-1][1]);
    }

    public static void main(String[] args) {
        Q198M test1 = new Q198M();
        int[] arr = {1,2,3,1};
        System.out.println(test1.rob(arr));
    }
}
