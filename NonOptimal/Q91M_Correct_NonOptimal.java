// 91. Decode Ways (Medium)
// https://leetcode.com/problems/decode-ways/


// Solution is correct (tested against the DP solution but exceeds time limit (it will pass s = "111111111111111111111111111111111111111" case but exceeds time limit if we have more digits (such as s = "111111111111111111111111111111111111111111111"))
public class Q91M_Correct_NonOptimal {
    public int numDecodings(String s) {
        if(s.charAt(0) == 0) {
            return 0;
        }
        int[] num = {0};
        dfs(s, 0, num);
        return num[0];
    }

    private boolean dfs(String s, int idx, int[] num) {
        if(idx == s.length()) {
            num[0] = num[0] + 1;
            return true;
        }
        // Out of String bound
        if(idx > s.length()) {
            return false;
        }
        if(s.charAt(idx) == '0') {
            return false; // "0*" can't be mapped to any character ("*0" will not go here)
        }
        boolean twoNum = false;
        boolean oneNum = false;
        // Two number case
        if(idx < s.length() - 1) {
            if(((s.charAt(idx) - '0')*10 + (s.charAt(idx+1) - '0')) <= 26) {
                twoNum = dfs(s, idx + 2, num);
            }
        }
        // one number case
        oneNum = dfs(s, idx + 1, num);
        return oneNum || twoNum;
    }

    public static void main(String[] args) {
        Q91M_Correct_NonOptimal test1 = new Q91M_Correct_NonOptimal();
        String str1 = "12";
        String str2 = "111111111111111111111111111111111111111111111";
        System.out.println(test1.numDecodings(str2));
    }
}
