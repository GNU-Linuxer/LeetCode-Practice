// 515. Find Largest Value in Each Tree Row (Medium)
// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q515M {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new LinkedList<Integer>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        int maxVal = Integer.MIN_VALUE;

        queue1.add(root);

        while(!queue1.isEmpty()) {
            maxVal = Integer.MIN_VALUE;
            Queue<TreeNode> queue2 = new LinkedList<>();
            while(!queue1.isEmpty()) {
                TreeNode top = queue1.remove();
                maxVal = Math.max(maxVal, top.val);
                if(top.left != null) {
                    queue2.add(top.left);
                }
                if(top.right != null) {
                    queue2.add(top.right);
                }
            }
            result.add(maxVal);
            queue1 = queue2;
        }
        return result;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}