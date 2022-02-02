// 210. Course Schedule II (Medium)
// https://leetcode.com/problems/course-schedule-ii/#/description

import java.util.*;
import java.util.stream.IntStream;

// Solution is correct but exceeds time limit (it will pass numCourses = 1000 case but exceeds time limit on numCourses = 2000 case)
public class Q210M_Correct_NonOptimal {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            int[] ret = {0};
            return ret;
        }
        // Did not consider the no-prerequisite case: can take course in any order
        if(prerequisites == null || prerequisites.length == 0) {
            return IntStream.range(0, numCourses).toArray(); // [0, 1, 2, 3, ... , numCourses - 1];
        }
        if(numCourses == 1) { // implies prerequisites.length > 0
            return prerequisites[0];
        }

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>(); // Directed Graph, using adjacency list
        // For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1

        // Construct a graph
        for(int i = 0 ; i < numCourses; i ++) {
            graph.put(i, new ArrayList<Integer>());
        }

        // Connect points course's prerequisite -> course
        for(int[] arr : prerequisites) {
            graph.get(arr[1]).add(arr[0]);
        }

        List<Integer> result = new ArrayList<Integer>();
        boolean removeEdge = false;
        // Whether I finished taking all courses (except the last one);
        while(result.size() < numCourses - 1) {
            removeEdge = false;
            // Take a course that has no prerequisite remaining (try course 0...numCourses-1)
            for(int i = 0; i < numCourses; i ++) {
                if(!result.contains(i)) {
                    boolean containPoint = false;
                    // Find a vertex with no incoming edges
                    for(List<Integer> val : graph.values()) {
                        // Process it and then remove it from the graph
                        if(val.contains(i)) {
                            containPoint = true;
                            break;
                        }
                    }
                    if(!containPoint) {
                        result.add(i);
                        graph.remove(i);
                        removeEdge = true;
                        break;
                    }
                }
            }
            // Graph contains cycle
            if(!removeEdge) {
                int[] ret = new int[0];
                return ret;
            }
        }

        result.add(graph.entrySet().iterator().next().getKey()); // Get the first Key in graph (in this case, there's only 1 entry left at here if done correctly)

        int[] resArr = new int[result.size()];
        for(int i = 0; i < result.size(); i ++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        Q210M_Correct_NonOptimal test1 = new Q210M_Correct_NonOptimal();
//        int[][] preReq = {{1, 0}};
        int[][] preReq = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(test1.findOrder(preReq.length, preReq)));
    }
}
