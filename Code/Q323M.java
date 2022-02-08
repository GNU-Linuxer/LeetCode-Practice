// 323. Number of Connected Components in an Undirected Graph (Medium)
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

import java.util.*;
public class Q323M {
    public int countComponents(int n, int[][] edges) {
        if(n == 1) {
            return 1; // 1 node -> 1 connected component
        }
        Set<Integer> unvisited = new HashSet<Integer>();
        for(int i = 0; i < n; i ++) {
            unvisited.add(i);
        }

        // Transform edges to Adjacency List representation
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>(); // Node -> neighbors
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


        int result = 0;
        while(!unvisited.isEmpty()) {
            result ++;
            int selected = unvisited.iterator().next(); // grab any value from Set
            unvisited.remove(selected);
            bfs(selected, graph, unvisited);
        }

        return result;
    }

    private void bfs(int start, Map<Integer, Set<Integer>> graph, Set<Integer> unvisited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int selected = queue.remove();
            unvisited.remove(selected);
            if(graph.containsKey(selected)) { // need to handle a component with only 1 node
                Set<Integer> neighbors = graph.get(selected);
                for(int i : neighbors) {
                    if(unvisited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }
    }
}
