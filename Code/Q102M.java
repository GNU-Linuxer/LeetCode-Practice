// 102. Binary Tree Level Order Traversal (Medium)
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.*;

public class Q102M {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        while(!queue1.isEmpty()) {
            List<Integer> levelOrder = new ArrayList<Integer>();
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            while(!queue1.isEmpty()) {
                TreeNode select = queue1.remove();
                levelOrder.add(select.val);
                if(select.left != null) {
                    queue2.add(select.left);
                }
                if(select.right != null) {
                    queue2.add(select.right);
                }
            }
            result.add(levelOrder);
            queue1 = queue2;
        }
        return result;
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
