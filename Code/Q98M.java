// 98. Validate Binary Search Tree (Medium)
// https://leetcode.com/problems/validate-binary-search-tree/

import java.util.LinkedList;
import java.util.List;

// My original approach that uses the sorted property of in-order traversal on a valid binary search tree
public class Q98M {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        List<Integer> inOrderTrv = new LinkedList<Integer>();

        inOrder(root, inOrderTrv);

        int prevVal = inOrderTrv.remove(0);
        for(int i : inOrderTrv) {
            if(i <= prevVal) {
                return false;
            }
            prevVal = i;
        }
        return true;
    }
    private void inOrder(TreeNode root, List<Integer> inOrderTrv) {
        if(root == null) {
            return;
        }
        inOrder(root.left, inOrderTrv);
        inOrderTrv.add(root.val);
        inOrder(root.right, inOrderTrv);

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
