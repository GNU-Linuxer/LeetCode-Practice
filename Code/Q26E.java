// 26. Remove Duplicates from Sorted Array (Easy)
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class Q26E {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int size = nums.length;
        // Elements are sorted
        for(int i = 1; i < size; i ++) {
            int prev = nums[i-1]; // we start from i=1, so no out of bound
            int numDuplicate = 0;
            int j = i;
            // [1,2,2,2,2,3,4]
            while(j < size && nums[j] == prev) {
                numDuplicate ++;
                j ++;
            }
            if(numDuplicate > 0) {
                int l = i;
                for(int k = i + numDuplicate; k < size; k ++) {
                    nums[l] = nums[k];
                    l ++;
                }
                size = size - numDuplicate;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Q26E test1 = new Q26E();
        int[] arr1 = {1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 8};
        System.out.println(test1.removeDuplicates(arr1));
    }
}
