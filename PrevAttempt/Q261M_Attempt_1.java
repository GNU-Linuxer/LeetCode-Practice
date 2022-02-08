// 261. Graph Valid Tree (Medium)
// https://leetcode.com/problems/graph-valid-tree/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q261M_Attempt_1 {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) {
            return true;
        }

        // Tree contains no cycle: use DFS, visiting, and visited approach
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

        Set<Integer> unvisited = new HashSet<Integer>();
        for(int i = 0; i < n; i ++) {
            unvisited.add(i);
        }

        Set<Integer> visiting = new HashSet<Integer>();
        int start = unvisited.iterator().next();
        boolean containCycle = dfs(start, graph, unvisited, visiting) != 0; // True: this component is tree; false: this component has a cycle

        // Tree can't have more than 1 connected compoment
        if(!unvisited.isEmpty()) {
            return false;
        }
        return containCycle;
    }

    public int dfs(int start, Map<Integer, Set<Integer>> graph, Set<Integer> unvisited, Set<Integer> visiting) {
        if (!unvisited.contains(start)) {
            return 0; // EXIT_SUCCESS
        }
        if (visiting.contains(start)) {
            return 1; // EXTI_FAILURE
        }
        visiting.add(start);
        if(graph.containsKey(start)) {
            for (int val : graph.get(start)) {
                if (unvisited.contains(val)) {
                    if (dfs(val, graph, unvisited, visiting) != 0) {
                        return 1;
                    }
                }
            }
        }
        visiting.remove(start);
        unvisited.remove(start);
        return 0; // EXIT_SUCCESS
    }

    public static void main(String[] args) {
        Q261M_Attempt_1 test1 = new Q261M_Attempt_1();
        int[][] glitch1 = {{0,1},{0,2},{0,3},{0,4}};
        System.out.println(test1.validTree(5, glitch1));
    }
}
