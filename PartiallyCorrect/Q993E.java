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
        boolean[] foundCousin = new boolean[2]; // [0]=found x; [1]=found y
        int layerCount = 0; // we're excluding direct children of the overall root
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            while(!queue1.isEmpty()) {
                TreeNode top = queue1.remove();
                foundCousin[0] = (foundCousin[0] || top.val == x); // assuming x != y
                foundCousin[1] = (foundCousin[1] || top.val == y); // assuming x != y
                if(top.left != null){
                    queue2.add(top.left);
                }
                if(top.right != null) {
                    queue2.add(top.right);
                }
            }
            if(layerCount>=2 && foundCousin[0] && foundCousin[1]) {
                return true;
            }
            Arrays.fill(foundCousin, false);
            layerCount++;
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

    // Scanner will accept following:
    // BFS order of tree
    // int x
    // int y

    // Such as:
    // [1,2,3,4]
    // 4
    // 3
    public static void main(String[] args){
        Q993E test1 = new Q993E();
        Scanner in = new Scanner(System.in);
        boolean res;

        String tree = in.nextLine().trim();
        TreeNode _root = test1.constructTree(tree.substring(1, tree.length() - 1));

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        int _y;
        _y = Integer.parseInt(in.nextLine().trim());

        res = test1.isCousins(_root, _x, _y);
        System.out.println(res ? "true" : "false");
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
