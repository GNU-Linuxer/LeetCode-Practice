// 71. Simplify Path (Medium)
// https://leetcode.com/problems/simplify-path/

import java.util.Stack;

public class Q71M {
    public String simplifyPath(String path) {
        if(path.length() == 1) {
            return "/";
        }

        String[] parts = path.split("/"); // / is not a regex syntax character and no need to be escaped

        // We're always removing the most inner directory if we encounter .. , no other ADT operation, so use Stack
        Stack<String> paths = new Stack<String>();

        for(String str : parts) {
            // ignoring // and . case
            if(str == null || str.length() == 0 || str.equals(".")) {
                continue;
            }
            else if(str.equals("..")) {
                if(!paths.isEmpty()) {
                    paths.pop();
                }
            }
            else{
                paths.push(str);
            }
        }

        // Account for /../ special case
        if(paths.isEmpty()) {
            return "/";
        }

        String result = "";
        for(String str : paths) {
            result = result + "/" + str;
        }

        return result;
    }
}
