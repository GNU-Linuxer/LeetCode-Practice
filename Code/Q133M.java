// 133. Clone Graph (Medium)
// https://leetcode.com/problems/clone-graph/

import java.util.*;

public class Q133M {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        else if (node.neighbors == null || node.neighbors.size() == 0) {
            return new Node(node.val);
        }
        Map<Integer, Node> clonedNode = new HashMap<Integer, Node>();// Cue: no node has repeated val

        // BFS: copy node
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(node);
        while(!queue1.isEmpty()) {
            Node top = queue1.remove();
            clonedNode.put(top.val, new Node(top.val));
            List<Node> neighbors = top.neighbors;
            if(neighbors == null || neighbors.size() == 0) {
                continue;
            }
            for(Node neighbor : neighbors) {
                if(!clonedNode.containsKey(neighbor.val)) {
                    queue1.add(neighbor);
                }
            }
        }

        // BFS: connect new nodes together
        Set<Node> visited = new HashSet<Node>();
        queue1 = new LinkedList<Node>();
        queue1.add(node);
        while(!queue1.isEmpty()) {
            Node top = queue1.remove();
            Node topCopy = clonedNode.get(top.val);
            visited.add(top);

            List<Node> neighbors = top.neighbors;
            List<Node> neighborsCopy = topCopy.neighbors;
            if(neighbors == null || neighbors.size() == 0) {
                continue;
            }

            for(Node neighbor : neighbors) {
                if(neighborsCopy == null) {
                    topCopy.neighbors = new ArrayList<Node>();
                }
                if(!neighborsCopy.contains(clonedNode.get(neighbor.val))) {
                    neighborsCopy.add(clonedNode.get(neighbor.val));
                }
                if(!visited.contains(neighbor)) {
                    queue1.add(neighbor);
                }
            }
        }

        return clonedNode.get(node.val);
    }

    public static void main(String[] args) {

    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
