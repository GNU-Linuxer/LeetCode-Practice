// 255. Verify Preorder Sequence in Binary Search Tree (Medium)
// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/

import java.util.Stack;

public class Q255M {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        Stack<Integer> decreasingNumbers = new Stack<Integer>();

        int smallestSoFar = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < smallestSoFar) {
                return false;
            }

            while (!decreasingNumbers.isEmpty() && num > decreasingNumbers.peek()) {
                smallestSoFar = decreasingNumbers.pop();
            }
            decreasingNumbers.push(num);
        }
        return true;
    }

    public static void main(String[] args) {
        Q255M test1 = new Q255M();
        System.out.println(test1.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }
}
