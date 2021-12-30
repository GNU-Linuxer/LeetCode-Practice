// 98. Validate Binary Search Tree (Medium)
// https://leetcode.com/problems/validate-binary-search-tree/

public class Q98M {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }

        if (root.val > low && root.val < high) {
            return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
        } else {
            return false;
        }
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
