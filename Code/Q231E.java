// 231. Power of Two (Medium)
// https://leetcode.com/problems/power-of-two/

import java.util.regex.*;

public class Q231E {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        else if(n == 1) {
            return true;
        }
        String binaryString = Integer.toBinaryString(n);
        Pattern p = Pattern.compile("0*1{1}0+"); // Check whether we have exactly one 1 in this String
        Matcher m = p.matcher(binaryString);
        return m.matches();
    }

    public static void main(String[] args) {
        Q231E test1 = new Q231E();
        System.out.println(test1.isPowerOfTwo(- 3));
    }
}
