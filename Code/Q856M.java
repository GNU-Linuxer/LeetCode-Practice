// 856. Score of Parentheses (Medium)
// https://leetcode.com/problems/score-of-parentheses/

public class Q856M {
    public int scoreOfParentheses(String s) {
        if(s.length() == 2) {
            return 1;
        }

        return dfs(s, 0, s.length() - 1);
    }

    // This is similar to add the sum of n-ary tree
    private int dfs(String s, int left, int right) {
        if(right - left ==1) {// () , base case
            return 1;
        }

        int diff = 0; // how many open perenthesis
        // Can't use i <= right, as this will mis-capture 2*A case
        for(int i = left; i < right ; i ++) {
            if(s.charAt(i) == '(') {
                diff ++;
            } else if(s.charAt(i) == ')') {
                diff --;
            }
            if(diff == 0) { // left and right is balanced (*****) + (*******), falls in A+B case
                return dfs(s, left, i) + dfs(s, i + 1, right);
            }
        }

        // The entire string is balanced (**********) with nothing on the left and right, falls in 2*A case
        return 2*dfs(s, left+1, right-1);
    }

    public static void main(String[] args) {
        Q856M test1 = new Q856M();
        String s1 = "(())";
        String s2 = "(())()";
        System.out.println(test1.scoreOfParentheses(s2));
    }
}
