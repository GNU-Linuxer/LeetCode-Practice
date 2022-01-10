// 513. Find Bottom Left Tree Value (Medium)
// https://leetcode.com/problems/find-bottom-left-tree-value/

import java.util.LinkedList;
import java.util.Queue;

public class Q513M {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            result = queue1.peek().val;
            while(!queue1.isEmpty()) {
                TreeNode top = queue1.remove();
                if(top.left != null) {
                    queue2.add(top.left);
                }
                if(top.right != null) {
                    queue2.add(top.right);
                }
            }
            queue1 = queue2;
        }

        return result;
    }

    public class TreeNode {
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