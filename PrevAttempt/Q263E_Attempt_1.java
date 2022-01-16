// 263. Ugly Number (Easy)
// https://leetcode.com/problems/ugly-number/

public class Q263E_Attempt_1 {
    public boolean isUgly(int n) {
        if(n >= -1 && n <= 1) {
            return true;
        }

        int m = n; // copy n
        while(!(n >= -1 && n <= 1)) {
            if(m > 2 && m % 2 != 0) {
                return false;
            }
            else if(m > 3 && m % 3 != 0) {
                return false;
            }
            else if(m > 5 && m % 5 != 0) {
                return false;
            }
            if(m % 2 == 0) {
                m = m / 2;
            }
            if(m % 3 == 0) {
                m = m / 3;
            }
            if(m % 5 == 0) {
                m = m / 5;
            }
        }
        return true;
    }
}
