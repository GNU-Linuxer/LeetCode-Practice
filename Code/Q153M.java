// 153. Find Minimum in Rotated Sorted Array (Medium)
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class Q153M {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        // O(log n) -> continuously divide array in half to find the dividing point
        // Find element in an array is sorted in custom order -> binary search
        int head = nums[0];
        int found = binarySearch(nums, 0, nums.length-1, head);
        return Math.min(found, head); // Account for monotonic increasing array
        // if nums[i] > head -> go to right half
        // if nums[i] < head -> go to left half
        // if low >= high, we found minimum

    }

    private int binarySearch(int[] nums, int low, int high, int head) {
        int half = low + (high-low) / 2;
        int halfVal = nums[half];
        // Note: we can assume that all elements are unique
        if(low >= high) {
            return halfVal;
        } else if(halfVal < head) {
            return binarySearch(nums, low, half, head); // Can't use return binarySearch(nums, low, half-1, head); Otherwise will fail [3, 1, 2] case
        } else {
            return binarySearch(nums, half+1, high, head);
        }
    }

    public static void main(String[] args) {
        Q153M test1 = new Q153M();
        int[] arr1 = {3,4,5,1,2};
        int[] arr2 = {2, 3, 4, 1};
        int[] increasing = {1, 2, 3, 4};
        int[] failed1 = {3, 1, 2};
        System.out.println(test1.findMin(failed1));
//        System.out.println(test1.findMin(increasing));
    }
}
