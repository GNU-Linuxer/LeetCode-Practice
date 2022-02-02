// 210. Course Schedule II (Medium)
// https://leetcode.com/problems/course-schedule-ii/#/description

import java.util.*;
import java.util.stream.IntStream;


public class Q210M {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            int[] ret = new int[0]; // int[] ret = new int[1]; not create an empty array
            return ret;
        }
        // Did not initially consider the no-prerequisite case: can take course in any order
        if (prerequisites == null || prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray(); // [0, 1, 2, 3, ... , numCourses - 1];
        }
        if (numCourses == 1) { // implies prerequisites.length > 0
            return prerequisites[0];
        }

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>(); // Directed Graph, using adjacency list
        // For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1

        // Construct a graph
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        // Connect points course's prerequisite -> course
        for (int[] arr : prerequisites) {
            graph.get(arr[1]).add(arr[0]);
        }

        // each course has unique number
        Deque<Integer> result = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> visiting = new HashSet<Integer>();
        boolean containCycle = dfs(graph, result, visited, visiting) != 0; // human readability: dfs() will return 0 for success and anything other than 0 is failure, similar to program exit code

        if (containCycle || result.isEmpty()) {
            int[] ret = new int[0];
            return ret;
        }

        int[] resArr = new int[result.size()];
        for (int i = 0; i < numCourses; i++) {
            resArr[i] = result.removeFirst();
        }
        return resArr;
    }

    private int dfs(Map<Integer, List<Integer>> graph, Deque<Integer> result, Set<Integer> visited, Set<Integer> visiting) {
        // Graph can have more than 1 connected components, so traverse on all connected components
        for (int val : graph.keySet()) {
            if (!visited.contains(val)) {
                if (dfsHelper(val, graph, result, visited, visiting) != 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private int dfsHelper(int start, Map<Integer, List<Integer>> graph, Deque<Integer> result, Set<Integer> visited, Set<Integer> visiting) {
        if (visited.contains(start)) {
            return 0; // EXIT_SUCCESS
        }
        if (visiting.contains(start)) {
            return 1; // EXTI_FAILURE
        }
        visiting.add(start);
        for (int val : graph.get(start)) {
            if (!visited.contains(val)) {
                if (dfsHelper(val, graph, result, visited, visiting) != 0) {
                    return 1;
                }
            }
        }
        visiting.remove(start);
        visited.add(start);
        result.addFirst(start);
        return 0; // EXIT_SUCCESS
    }

    public static void main(String[] args) {
        Q210M test1 = new Q210M();
        // int[][] preReq = {{1, 0}};
        // int[][] preReq = {{1,0},{2,0},{3,1},{3,2}};

        // I am prone to fail in this case
        // 2
        // [[0,1],[1,0]]
        int[][] testForGlitch = {{0, 1}, {1, 0}};
        System.out.println(Arrays.toString(test1.findOrder(testForGlitch.length, testForGlitch)));
    }
}
