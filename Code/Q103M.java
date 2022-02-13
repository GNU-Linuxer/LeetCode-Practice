// 103. Binary Tree Zigzag Level Order Traversal (Medium)
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.*;
public class Q103M {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        int level = 0;
        while(!queue1.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<Integer>();
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            while(!queue1.isEmpty()) {
                TreeNode selected = queue1.remove();
                oneLevel.add(selected.val);
                if(selected.left != null) {
                    queue2.add(selected.left);
                }
                if(selected.right != null) {
                    queue2.add(selected.right);
                }
            }
            if(level % 2 != 0) {
                Collections.reverse(oneLevel);
            }
            level = level + 1;
            result.add(oneLevel);
            queue1 = queue2;
        }

        return result;
    }
    public static void main(String[] args) {
        Q103M test1 = new Q103M();
        TreeNode tree1 = test1.constructTree("3,1,4,null,2");
        System.out.println(test1.zigzagLevelOrder(tree1));
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

    private static class TreeNode {
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
