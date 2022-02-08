// 55. Jump Game (Medium)
// https://leetcode.com/problems/jump-game/

public class Q55M {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) { // [0] should be true
            return true;
        }

        if(nums.length > 1 && nums[0] == 0) {
            return false; // unreachable
        }

        boolean[] canReach = new boolean[nums.length]; // default to false
        canReach[0] = true;

        for(int i = 0; i < nums.length; i ++) {
            if(!canReach[i] && nums[i] == 0) {
                continue;
            }
            int step = nums[i];
            // We can only jump forward from here if here is reachable
            if(canReach[i]) {
                for(int j = i; j < Math.min(nums.length, i + step + 1); j ++) {
                    canReach[j] = true;
                }
            }
        }

        return canReach[nums.length - 1];
    }

    public static void main(String[] args) {
        Q55M test1 = new Q55M();
        int[] arr1 = {2,3,1,1,4};
        System.out.println(test1.canJump(arr1));
    }
}
