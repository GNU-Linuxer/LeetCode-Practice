// 113. Path Sum II (Medium)
// https://leetcode.com/problems/path-sum-ii/

import java.util.LinkedList;
import java.util.List;

public class Q113M {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> chosen = new LinkedList<Integer>();
        chosen.add(root.val);
        preOrder(root, targetSum, chosen, result);

        return result;
    }


    // When we have a root-to-leaf path that matches targetSum, COPY the temp List to the result
    public void preOrder(TreeNode root, int sumRemaining, List<Integer> chosen, List<List<Integer>> resultPtr) {
        if (sumRemaining - root.val == 0 && root.left == null && root.right == null) {
            resultPtr.add(new LinkedList<Integer>(chosen)); // copy without reference
            return;
        } else if (sumRemaining - root.val != 0 && root.left == null && root.right == null) {
            return;
        }

        if (root.left != null) {
            chosen.add(root.left.val);
            preOrder(root.left, sumRemaining - root.val, chosen, resultPtr);
            chosen.remove(chosen.size() - 1); // remove last element;
        }

        if (root.right != null) {
            chosen.add(root.right.val);
            preOrder(root.right, sumRemaining - root.val, chosen, resultPtr);
            chosen.remove(chosen.size() - 1); // remove last element;
        }
    }

    public static void main(String[] args) {

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
