// 856. Score of Parentheses (Medium)
// https://leetcode.com/problems/score-of-parentheses/

import java.util.ArrayList;
import java.util.List;

public class Q856M_Attempt_1 {
    public int scoreOfParentheses(String s) {
        if(s.length() == 2) {
            return 1;
        }
        boolean[] visited = new boolean[s.length()]; // default to false for every value

        return dfs(s, 0, visited, 0);
    }

    // This is similar to add the sum of n-ary tree
    private int dfs(String s, int index, boolean[] visited, int level) {
        // s is guaranteed to be a balanced parentheses string, no need to check out of bound case
        if(s.charAt(index) == ')') {
            visited[index] = true;
            return 1;
        }

        List<Integer> sumSoFar =  new ArrayList<Integer>();

        // Start looking for unvisited ( , similar to traverse every children of this root
        // Problem: inner level perenthesis can access to outer layer perenthesis located further right (need to stop early), such as (())()
         for(int i = index; i < s.length(); i ++) {
            if(!visited[i]&&s.charAt(i) == '(') {
                visited[i] = true;
                sumSoFar.add(dfs(s, i + 1, visited, level + 1));
            }
        }


        int sum = 0;
        for(Integer i : sumSoFar) {
            sum += i;
        }

        int expo = (int)Math.pow(2, level);
        return sum*expo;
    }

    public static void main(String[] args) {
        Q856M_Attempt_1 test1 = new Q856M_Attempt_1();
        String s1 = "(())";
        String s2 = "(())()";
        System.out.println(test1.scoreOfParentheses(s2));
    }
}
