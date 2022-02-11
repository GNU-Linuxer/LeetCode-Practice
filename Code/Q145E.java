// 145. Binary Tree Postorder Traversal (Medium)
// https://leetcode.com/problems/binary-tree-postorder-traversal/


import java.util.*;

public class Q145E {
    // The solution that I will "never" forget, traverse the order using modified pre-order: root, right, left; then reverse the traverse order (which yields left, right, root)
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return new LinkedList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode selected = stack.pop();
            result.add(selected.val);
            if(selected.left != null) {
                stack.push(selected.left);
            }
            if(selected.right != null) {
                stack.push(selected.right);
            }
        }
        Collections.reverse(result); // It will return nothing but rather reverse the List<Integer> in-place
        return result;
    }

    public static void main(String[] args){
        Q145E test1 = new Q145E();
        TreeNode tree = test1.constructTree("1,2,3,4");
        TreeNode tree2 = test1.constructTree("1,2,3,null,4,null,5");
        System.out.println(test1.postorderTraversal(tree2));
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
