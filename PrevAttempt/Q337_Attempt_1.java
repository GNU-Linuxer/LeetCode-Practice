// 337. House Robber III
// https://leetcode.com/problems/house-robber-iii/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q337_Attempt_1 {
    public int rob(TreeNode root) {
        // Special case for only 1 node in a tree
        if(root.left == null && root.right == null) {
            return root.val;
        }

        // Note: if I do not override equals implementation, Java will treat 2 object pointers equal if they both reference to same object instance, false otherwise even though they have a same value.
        Map<TreeNode, int[]> cashGain = new HashMap<TreeNode, int[]>();
        Set<TreeNode> leafNode = new HashSet<TreeNode>();

        // Special case for root node
        int[] rootMoney = {0, root.val};
        cashGain.put(root, rootMoney);

        BFS(root, cashGain, leafNode);

        int maxMoney = 0;
        for(TreeNode leaf : leafNode) {
            maxMoney = -1;
        }

        return maxMoney;
    }

    private void BFS(TreeNode root, Map<TreeNode, int[]> cashGain, Set<TreeNode> leafNode) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafNode.add(root);
        }
        int[] moneySoFar = new int[2];
        if(root.left != null) {
            int[] money = {Math.max(cashGain.get(root)[0], cashGain.get(root)[1]), cashGain.get(root)[0] + root.left.val};
            cashGain.put(root.left, money);

            moneySoFar[0] = Math.max(money[0], money[1]);
            BFS(root.left, cashGain, leafNode);
        }
        if(root.right != null) {
            int[] money = {Math.max(cashGain.get(root)[0], cashGain.get(root)[1]), cashGain.get(root)[0] + root.right.val};
            cashGain.put(root.right, money);

            moneySoFar[1] = Math.max(money[0], money[1]);
            BFS(root.right, cashGain, leafNode);
        }
    }

    public static void main(String[] args) {

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
