// 242. Valid Anagram (Easy)
// https://leetcode.com/problems/valid-anagram/

import java.util.Arrays;

public class Q242E {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}
