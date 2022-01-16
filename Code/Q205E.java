// 205. Isomorphic Strings (Easy)
// https://leetcode.com/problems/isomorphic-strings/

import java.util.*;

public class Q205E {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> forward = new HashMap<Character, Character>();
        Map<Character, Character> reverse = new HashMap<Character, Character>();
        for(int i = 0 ; i < s.length(); i ++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(!forward.containsKey(sChar)) {
                forward.put(sChar, tChar);
            } else {
                if(forward.get(sChar) != tChar) {
                    return false;
                }
            }
            if(!reverse.containsKey(tChar)) {
                reverse.put(tChar, sChar);
            } else {
                if(reverse.get(tChar) != sChar) {
                    return false;
                }
            }
        }
        return true;
    }
}