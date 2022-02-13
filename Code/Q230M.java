// 230. Kth Smallest Element in a BST (Medium)
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

import java.util.LinkedList;
import java.util.Queue;

public class Q230M {
    public int kthSmallest(TreeNode root, int k) {
        // Perform in-order traversal
        int[] numFound = {1};
        int[] result = {-1};
        inOrder(root, k, numFound, result);
        return result[0];
    }

    private void inOrder(TreeNode root, int k, int[] numFound, int[] result) {
        if(root == null) {
            return;
        }
        inOrder(root.left, k, numFound, result);
        if(numFound[0] == k && result[0] == -1) {
            result[0] = root.val;
        }
        numFound[0] = numFound[0] + 1;
        inOrder(root.right, k, numFound, result);
    }

    public static void main(String[] args) {
        Q230M test1 = new Q230M();
        TreeNode tree1 = test1.constructTree("3,1,4,null,2");
        System.out.println(test1.kthSmallest(tree1, 1));
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
