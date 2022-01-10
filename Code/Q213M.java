// 213. House Robber II (Medium)
// https://leetcode.com/problems/house-robber-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q213M {
    public int rob(int[] nums) {
        if(nums.length == 1)  {
            return nums[0];
        }
        List<Integer> earningTally = new ArrayList<Integer>(2);
        // int[x][y] = amount of money I can earn so far on whether I robbed x house (y=1) or not robbed this house (y=0)
        int[][] earnSoFar = new int[nums.length][2]; // auto initialize array to 0;

        // The easier way to think by hard-coding cases can actually work
        // 1. Rob neither first nor last house and 3. rob last house but not first house
        for(int i = 1; i < nums.length; i ++) {
            earnSoFar[i][0] = Math.max(earnSoFar[i-1][0], earnSoFar[i-1][1]);
            earnSoFar[i][1] = earnSoFar[i-1][0] + nums[i];
        }
        earningTally.add(Math.max(earnSoFar[nums.length-1][0], earnSoFar[nums.length-1][1]));

        // 2. rob first house but not last house
        for(int[] i : earnSoFar) {
            Arrays.fill(i, 0);
        }
        for(int i = 0; i < nums.length; i ++) {
            if(i == 0) {
                earnSoFar[i][1] = nums[i];
            }
            // Can't rob second house if I rob first house
            else if (i == 1) {
                earnSoFar[i][0] = earnSoFar[i-1][1];
                earnSoFar[i][1] = earnSoFar[i-1][1];
            }
            else {
                earnSoFar[i][0] = Math.max(earnSoFar[i-1][0], earnSoFar[i-1][1]);
                earnSoFar[i][1] = earnSoFar[i-1][0] + nums[i];
            }
        }
        earningTally.add(earnSoFar[nums.length-1][0]);

        return Collections.max(earningTally);
    }
    public static void main(String[] args) {
        Q213M test1 = new Q213M();
        int[] arr = {1,2,3,1};
        System.out.println(test1.rob(arr));
    }
}
