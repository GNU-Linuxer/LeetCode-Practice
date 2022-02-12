// 226. Invert Binary Tree (Easy)
// https://leetcode.com/problems/invert-binary-tree/

import java.util.*;

public class Q226E {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode invertRoot = new TreeNode(root.val);
        DFS(root, invertRoot);
        return invertRoot;
    }

    private void DFS(TreeNode curr, TreeNode invert) {
        if(curr.left != null) {
            invert.right = new TreeNode(curr.left.val);
            DFS(curr.left, invert.right);
        }
        if(curr.right != null) {
            invert.left = new TreeNode(curr.right.val);
            DFS(curr.right, invert.left);
        }
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
