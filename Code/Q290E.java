// 290. Word Pattern (Easy)
// https://leetcode.com/problems/word-pattern/

import java.util.HashMap;
import java.util.Map;

public class Q290E {
    public boolean wordPattern(String pattern, String s) {
        char[] ptnChar = pattern.toCharArray();
        String[] strArr = s.split(" ");

        if(ptnChar.length != strArr.length) {
            return false;
        }

        Map<Character, String> forward = new HashMap<Character, String>();
        Map<String, Character> reverse = new HashMap<String, Character>();

        for(int i = 0; i < ptnChar.length; i ++) {
            if(!forward.containsKey(ptnChar[i])) {
                forward.put(ptnChar[i], strArr[i]);
            }
            else if(forward.containsKey(ptnChar[i]) && !strArr[i].equals(forward.get(ptnChar[i]))) {
                return false;
            }
            if(!reverse.containsKey(strArr[i])) {
                reverse.put(strArr[i], ptnChar[i]);
            }
            else if(reverse.containsKey(strArr[i]) && reverse.get(strArr[i]) != ptnChar[i]) {
                return false;
            }
        }
        return true;
    }
}