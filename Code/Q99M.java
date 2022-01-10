// 99. Recover Binary Search Tree
// https://leetcode.com/problems/recover-binary-search-tree/submissions/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q99M {
    public void recoverTree(TreeNode root) {
        // The number of nodes in the tree is in the range [2, 1000], so there's no need to account for a tree with only 1 node (the overall root)
        List<TreeNode> inOrder = new LinkedList<TreeNode>();
        inOrderTraversal(root, inOrder);
        // Should not use List<TreeNode> as it's pass by reference where using List<Integer> results in pass by value
        List<Integer> swapping = new ArrayList<Integer>(2);
        for(int i = 0; i < inOrder.size()-1; i ++) {
            if(inOrder.get(i).val > inOrder.get(i + 1).val) {
                // Find pairs of nodes we need to swap
                if(swapping.size() == 0) {
                    swapping.add(0, inOrder.get(i+1).val);
                } else {
                    swapping.set(0, inOrder.get(i+1).val);
                }

                if(swapping.size() == 1) {
                    swapping.add(1, inOrder.get(i).val);
                } else {
                    break;
                }
            }
        }
        for(int i = 0; i < inOrder.size(); i ++) {
            if(inOrder.get(i).val == swapping.get(0)) {
                inOrder.get(i).val = swapping.get(1);
            }
            else if(inOrder.get(i).val == swapping.get(1)) {
                inOrder.get(i).val = swapping.get(0);
            }
        }
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> inOrderList) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            inOrderTraversal(root.left, inOrderList);
        }
        inOrderList.add(root);
        if(root.right != null) {
            inOrderTraversal(root.right, inOrderList);
        }
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
