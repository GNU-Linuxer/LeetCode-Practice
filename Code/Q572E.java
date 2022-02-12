// 572. Subtree of Another Tree (Easy)
// https://leetcode.com/problems/subtree-of-another-tree/

import java.util.*;

public class Q572E {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return DFS(root, subRoot);
    }

    private boolean DFS(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }

        if(isSameTree(root, subRoot)) {
            return true;
        }
        return DFS(root.left, subRoot) || DFS(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {
        Q572E test1 = new Q572E();
        TreeNode tree1 = test1.constructTree("29,28,30,27,29,29,31,26,26,28,28,28,28,30,32,25,25,25,25,27,29,null,29,29,29,null,29,29,29,31,null,26,24,26,26,26,null,24,null,null,26,28,null,28,28,30,28,30,30,null,null,30,30,30,30,null,32,27,27,null,25,25,null,null,25,27,27,null,null,null,null,27,27,27,29,null,null,null,31,29,null,31,null,29,29,null,null,29,31,null,29,29,31,null,31,null,null,null,28,24,24,24,26,24,24,null,28,26,28,26,null,null,null,28,28,null,28,null,null,28,30,32,null,30,28,28,28,null,null,null,null,28,30,28,28,null,null,null,null,27,null,null,null,23,25,null,null,null,null,null,null,null,null,27,27,null,null,null,29,null,null,null,null,27,29,null,27,27,null,null,null,null,31,29,29,27,29,null,29,27,29,null,null,null,null,27,null,null,29,null,null,22,22,null,26,null,null,26,28,28,28,null,28,null,28,null,28,null,null,null,null,null,null,null,28,null,28,28,null,30,null,null,null,null,null,26,null,28,30,21,23,null,null,null,25,null,27,null,null,null,null,27,29,27,29,27,27,null,null,null,null,29,null,27,null,null,null,25,27,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,28,null,null,null,null,null,null,null,null,26,null,null,24,null,28,null,null,null,null,null,23");
        TreeNode tree2 = test1.constructTree("29");
        System.out.println(test1.isSubtree(tree1, tree2));
    }

    // Construct a binary tree given BFS traversal order from String tree argument, return the tree's overall root, such as
    // [1,2,3,4]
    // [1,2,3,null,4,null,5]
    private TreeNode constructTree(String tree) {
        String[] nodes = tree.split(",");
        TreeNode root = null;
        if (nodes[0].equals("")) {
            return root;
        }
        root = new TreeNode(Integer.parseInt(nodes[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (index < nodes.length) {
            TreeNode tmp = queue.poll();
            if (!nodes[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index]));
                tmp.left = leftNode;
                queue.offer(leftNode);
            }
            index++;
            if (index >= nodes.length)
                break;
            if (!nodes[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[index]));
                tmp.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }
        return root;
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
