// 366. Find Leaves of Binary Tree (Medium)
// https://leetcode.com/problems/find-leaves-of-binary-tree/

import java.util.*;

class Q366M {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>(1);
        }
        if(root.left == null && root.right == null) {
            List<Integer> single = new ArrayList<Integer>(1);
            single.add(root.val);
            List<List<Integer>> ret = new ArrayList<List<Integer>>(1);
            ret.add(single);
            return ret;
        }

        //int depth = depthOfTree(root, 0);
        Map<Integer, List<Integer>> levelAndList = new TreeMap<Integer, List<Integer>>();

        leafNodeRemoval(root, 0, levelAndList);
        //levelAndList.put(lastDepth, Arrays.asList(root.val));

        List<List<Integer>> result = new LinkedList<>();
        for(int key : levelAndList.keySet()) {
            result.add(levelAndList.get(key));
        }
        return result;
    }

    //private int depthOfTree(TreeNode root, int depth) {
    //    if(root == null) {
    //        return depth;
    //    }
    //    return Math.max(depthOfTree(root.left, depth + 1), depthOfTree(root.right, depth + 1));
    //}

    // We only add 1 more level when we're back tracking
    private int leafNodeRemoval(TreeNode root, int level, Map<Integer, List<Integer>> levelAndList) {
        if(root.left == null && root.right == null) {
            if(!levelAndList.containsKey(level)) {
                List<Integer> temp = new ArrayList<Integer>();
                levelAndList.put(level, temp);
            }

            levelAndList.get(level).add(root.val);

            //root = null;
            return level + 1;
        }
        int currLevelLeft = Integer.MIN_VALUE;
        if(root.left != null) {
            currLevelLeft = leafNodeRemoval(root.left, level, levelAndList);
            //levelAndList.get(currLevelLeft).add(root.val);
        }
        int currLevelRight = Integer.MIN_VALUE;
        if(root.right != null) {
            currLevelRight = leafNodeRemoval(root.right, level, levelAndList);
            //levelAndList.get(currLevelRight).add(root.val);
        }

        int selectedLevel = Math.max(currLevelLeft, currLevelRight);
        if(!levelAndList.containsKey(selectedLevel)) {
            List<Integer> temp = new ArrayList<Integer>();
            levelAndList.put(selectedLevel, temp);
        }
        levelAndList.get(selectedLevel).add(root.val);

        return selectedLevel + 1;
    }

    public static void main(String[] args) {
        
    }

    public TreeNode constructTree(String tree) {
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
        TreeNode(int x) { val = x; }
    }
}