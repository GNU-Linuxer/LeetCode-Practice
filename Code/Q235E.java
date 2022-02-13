// 235. Lowest Common Ancestor of a Binary Search Tree (Easy)
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q235E {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        TreeNode[] ancestor = new TreeNode[1];
        // All Node.val are unique.
        if(p.val < q.val) {
            DFS(root, p, q, ancestor);
        } else {
            DFS(root, q, p, ancestor);
        }
        return ancestor[0];
    }

    private void DFS(TreeNode root, TreeNode p, TreeNode q, TreeNode[] ancestor) {
        if(root == null) {
            return;
        }
        if((p.val < root.val && q.val > root.val) || (root.val == p.val || root.val == q.val)) {
            ancestor[0] = root;
            return;
        }
        else if (p.val < root.val && q.val < root.val) {
            DFS(root.left, p, q, ancestor);
        }
        else if (p.val > root.val && q.val > root.val) {
            DFS(root.right, p, q, ancestor);
        }
    }


        public static void main(String[] args) {
        Q235E test1 = new Q235E();
        TreeNode tree1 = test1.constructTree("6,2,8,0,4,7,9,null,null,3,5");
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        System.out.println(test1.lowestCommonAncestor(tree1, p, q));
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
