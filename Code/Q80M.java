// 80. Remove Duplicates from Sorted Array II (Medium)
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class Q80M {
    public int removeDuplicates(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1 || arr.length == 2) {
            return arr.length;
        }
        int size = arr.length;
        // [0,0,1,1,1,1,2,3,3]

        for (int i = 0; i < size; i ++) {
            int num = arr[i];
            int numToRemove = 0;
            int j = i;
            // Just using while (i < size - 2 && arr[j + 1] == num) will fail the array with same integer case
            while (i < size - 2 && j < size - 1 && arr[j + 1] == num) {
                j++;
                numToRemove++;
            }
            // If we only have 1 duplicated element, we need to ignore it
            if (numToRemove >= 1) {
                numToRemove --;
            }
            if (numToRemove > 0 && i < size - 2) {
                int start = i + 2;
                // int count = 0;
                // int moveCount = size - j - 1;
                for(int count = 0; count < size-j-1; count ++) {
                    arr[start] = arr[start + numToRemove];
                    start++;
                }
                size = size - numToRemove;
                i ++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Q80M test1 = new Q80M();
        int[] arr1 = {0,0,1,1,1,1,2,3,3};
        int[] glitch = {1,1,1};
        System.out.println(test1.removeDuplicates(glitch));
    }
}
