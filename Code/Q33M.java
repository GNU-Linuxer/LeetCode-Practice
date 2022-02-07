// 33. Search in Rotated Sorted Array (Medium)
// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Q33M {
    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int head = nums[0];
        if(target == head) {
            return 0;
        }

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    // if nums[half] > target AND
    // if target < head -> search right half
    // if target > head -> search left half
    // if nums[half] < target -> search left half
    public int binarySearch(int[] nums, int low, int high, int target) {
        if(low > high) {
            return -1;
        }
        int half = low + (high - low) / 2; // Equal to (low + high) / 2; recommend use the former approach to prevent integer overflow in the addition process
        int halfVal = nums[half];

        if(halfVal == target) {
            return half;
        }

        int lowVal = nums[low];
        int highVal = nums[high];
        // Array = [7,8,1,2,3,4,5,6]
        if(halfVal < lowVal) {
            // If the target is within halfVal and highVal, search in the right part
            if(halfVal < target && highVal >= target) {
                return binarySearch(nums, half + 1, high, target);
            } else {
                return binarySearch(nums, low, half - 1, target);
            }
        }
        // Array = [3,4,5,6,7,8,1,2]
        else {
            // If the target is within lowVal and halfVal, search in the left part
            if(halfVal > target && lowVal <= target) {
                return binarySearch(nums, low, half - 1, target);
            } else {
                return binarySearch(nums, half + 1, high, target);
            }
        }
    }

    public static void main(String[] args) {
        Q33M test1 = new Q33M();
        int[] arr1 = {4,5,6,7,0,1,2};
        int[] glitch = {4,5,6,7,8,1,2,3};
        int[] glitch2 = {3,4,5,6,1,2};
        System.out.println(test1.search(glitch2, 2));
    }
}
