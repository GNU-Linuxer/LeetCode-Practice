// 114. Flatten Binary Tree to Linked List (Medium)
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

import java.util.LinkedList;
import java.util.Queue;

public class Q114M {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> resultQueue = new LinkedList<TreeNode>();
        preOrder(root, resultQueue);

        TreeNode rootPtr = root;
        root.left = null;
        resultQueue.remove();
        while (!resultQueue.isEmpty()) {
            resultQueue.peek().left = null;
            rootPtr.right = resultQueue.remove();
            rootPtr = rootPtr.right;
        }
    }

    public void preOrder(TreeNode root, Queue<TreeNode> resultPtr) {
        if (root == null) {
            return;
        }
        resultPtr.add(root);
        preOrder(root.left, resultPtr);
        preOrder(root.right, resultPtr);
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
