// 993. Cousins in Binary Tree (Easy)
// https://leetcode.com/problems/cousins-in-binary-tree/

import java.util.*;


public class Q993E {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.add(root);
        // Note: Each node has a unique value, and x != y (this assumption is not present when I do this problem in the OA system,
        // so if I encounter it in interview, take initiative to ask interviewer more "technical specification")
        // We're excluding direct children of root
        int[] parentOfNodeArr = {-1, -2};
        //Map<Integer, Integer> parentOfNode = new HashMap<Integer, Integer>(); // y = parentOfNode.get(x); is the parent node of x
        //parentOfNode.put(x, -1);
        //parentOfNode.put(y, -2);
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            while(!queue1.isEmpty()) {
                TreeNode top = queue1.remove();
                if(top.left != null){
                    queue2.add(top.left);
                    if(top.left.val == x) {
                        parentOfNodeArr[0] = top.val;
                        //parentOfNode.replace(x, top.val);
                    }
                    if(top.left.val == y) {
                        parentOfNodeArr[1] = top.val;
                        //parentOfNode.replace(y, top.val);
                    }
                }
                if(top.right != null) {
                    queue2.add(top.right);
                    if(top.right.val == x) {
                        parentOfNodeArr[0] = top.val;
                        //parentOfNode.replace(x, top.val);
                    }
                    if(top.right.val == y) {
                        parentOfNodeArr[1] = top.val;
                        //parentOfNode.replace(y, top.val);
                    }
                }
            }
            // Take advantage of this constraint: 1 <= Node.val <= 100 so we can save a Map ADT
            //if(parentOfNode.get(x) != parentOfNode.get(y) && parentOfNode.get(x) != -1 && parentOfNode.get(y) != -2) {
            if(parentOfNodeArr[0] != parentOfNodeArr[1] && parentOfNodeArr[0] != -1 && parentOfNodeArr[1] != -2) {
                return true;
            }
            //parentOfNode.replace(x, -1);
            //parentOfNode.replace(y, -2);
            parentOfNodeArr = new int[] {-1, -2};

            queue1 = queue2;
        }
        return false;
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

    public static void main(String[] args){
        Q993E test1 = new Q993E();
        TreeNode tree = test1.constructTree("1,2,3,4");
        TreeNode tree2 = test1.constructTree("1,2,3,null,4,null,5");
//        System.out.println(test1.isCousins(tree, 4, 3));
        System.out.println(test1.isCousins(tree2, 5, 4));
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
