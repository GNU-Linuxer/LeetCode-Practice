// 199. Binary Tree Right Side View (Medium)
// https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199M {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new LinkedList<Integer>();
        }

        //Map<Integer, Integer> rightValue = new TreeMap<Integer, Integer>();
        List<Integer> result = new LinkedList<Integer>();
        int rightHandValue = 0;
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            while(!queue1.isEmpty()) {
                TreeNode top = queue1.remove();
                if(top.left != null) {
                    queue2.add(top.left);
                }
                if(top.right != null) {
                    queue2.add(top.right);
                }
                rightHandValue = top.val;
            }
            result.add(rightHandValue);
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