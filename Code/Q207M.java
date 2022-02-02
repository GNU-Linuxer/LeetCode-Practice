// 207. Course Schedule (Medium)
// https://leetcode.com/problems/course-schedule/

import java.util.*;

public class Q207M {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < numCourses; i ++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for(int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> visiting = new HashSet<Integer>();

        boolean containCycle = dfs(graph, visited, visiting) != 0;

        if(containCycle || visited.isEmpty()) {
            return false;
        }

        return true;
    }

    private int dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> visiting) {
        for(int i : graph.keySet()) {
            if(!visited.contains(i)) {
                if(dfsHelper(i, graph, visited, visiting) != 0) {
                    return 1;
                }
            }
        }
        return 0;
    }
    private int dfsHelper(int start, Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> visiting) {
        if(visited.contains(start)) {
            return 0;
        }
        if(visiting.contains(start)) {
            return 1; // cycle is here
        }
        visiting.add(start);
        for(int i : graph.get(start)) {
            if(!visited.contains(i)) {
                if(dfsHelper(i, graph, visited, visiting) != 0) {
                    return 1;
                }
            }
        }
        visiting.remove(start);
        visited.add(start);
        return 0;
    }
    public static void main(String[] args) {
        Q207M test1 = new Q207M();
        // int[][] preReq = {{1, 0}};
         int[][] preReq = {{1,0},{2,0},{3,1},{3,2}};
         System.out.println(test1.canFinish(preReq.length, preReq));
    }
}
