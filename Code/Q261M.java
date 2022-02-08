// 261. Graph Valid Tree (Medium)
// https://leetcode.com/problems/graph-valid-tree/
import java.util.*;
public class Q261M {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) {
            return true;
        }

        // For a valid tree, its edges = number of vertices - 1
        if(n-1 != edges.length) {
            return false;
        }

        // Build adjacency list
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if(!graph.containsKey(a)) {
                graph.put(a, new HashSet<Integer>());
            }
            graph.get(a).add(b);
            if(!graph.containsKey(b)) {
                graph.put(b, new HashSet<Integer>());
            }
            graph.get(b).add(a);
        }

        // BFS
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        // A node with number 0 is always there, let's visit it first
        queue.add(0);

        // Note: we don't need to add cycle detection logic, it will be either covered in line 8 or the return statement.
        while(!queue.isEmpty()) {
            int selected = queue.remove();
            visited.add(selected);
            if(graph.containsKey(selected)) {
                for(int i : graph.get(selected)) {
                    if(!visited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }

        return visited.size() == n; // If not, we have more than 1 connected component, which is not a valid tree
    }

    public static void main(String[] args) {
        Q261M test1 = new Q261M();
        int[][] glitch1 = {{0,1},{0,2},{0,3},{0,4}};
        System.out.println(test1.validTree(5, glitch1));
    }
}
