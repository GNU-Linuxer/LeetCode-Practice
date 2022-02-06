// 334. Increasing Triplet Subsequence (Medium)
// https://leetcode.com/problems/increasing-triplet-subsequence/

// Prone to fail in [1,5,0,4,1,3] test cases
public class Q334M {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        int[] small = new int[nums.length];
        int[] large = new int[nums.length];

        small[0] = Integer.MAX_VALUE;

        for(int i = 1; i < nums.length; i ++ ) {
            if(i == 1) {
                small[1] = nums[1] > nums[0] ? nums[0] : Integer.MAX_VALUE;
            } else if (i == 2) {
                small[2] = Math.min(nums[0], nums[1]);
            } else {
                small[i] = Math.min(nums[i-1], small[i-1]);
            }
        }

        large[nums.length - 1] = Integer.MIN_VALUE;
        for(int i = nums.length - 2; i >= 0; i --) {
            if(i == nums.length - 1) {
                large[i] = nums[i] < nums[i+1] ? nums[i] : Integer.MIN_VALUE;
            } else if (i == nums.length - 2) {
                large[i] = Math.max(nums[i], nums[i + 1]);
            } else {
                large[i] = Math.max(nums[i + 1], large[i + 1]);
            }
        }

        for(int i = 1; i < nums.length - 1; i ++) {
            if(nums[i] > small[i] && nums[i] < large[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Q334M test1 = new Q334M();
        int[] arr1 = {1,5,0,4,1,3};
        System.out.println(test1.increasingTriplet(arr1));
    }
}
