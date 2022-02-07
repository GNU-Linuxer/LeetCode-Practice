public class Q33M_Attempt_1 {
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
        int head = nums[low];
        if(head == target) {
            return low;
        }
        int half = low + (high - low) / 2;
        int halfVal = nums[half];

        if(halfVal == target) {
            return half;
        }
        // right half
        if ((halfVal > target && target < head) || (halfVal < target && target < head)) {
            return binarySearch(nums, half + 1, high, target);
        }
        // left half
        if((halfVal > target && target > head) || (halfVal < target && target > head)) {
            return binarySearch(nums, low, half, target);
        }

        return -1;
    }

    public static void main(String[] args) {
        Q33M_Attempt_1 test1 = new Q33M_Attempt_1();
        int[] arr1 = {4,5,6,7,0,1,2};
        int[] glitch = {4,5,6,7,8,1,2,3};
        System.out.println(test1.search(glitch, 8));
    }
}
