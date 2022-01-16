// 93. Restore IP Addresses
// https://leetcode.com/problems/restore-ip-addresses/

import java.util.*;

public class Q93M {
    public List<String> restoreIpAddresses(String s) {
        // This check will slow things down and consumes more memory
//        if(s.length() < 4 || s.length() > 12) {
//            return new ArrayList<String>();
//        }
        List<String> result = new LinkedList<String>();
        findIP(s, 1, "", result); // Note: when pass String, it will be passed as a copy, the original String stays untouched

        return result;
    }

    private void findIP(String remain, int level, String ipAddr, List<String> result) {
        if(level == 5 && remain.length() == 0) {
            result.add(ipAddr.substring(0, ipAddr.length()-1));
        }

        // We still have number remaning after ip address is filled, stop searching
        if(level >= 5) {
            return;
        }

        for(int i = 1; i <= 3; i ++) {
            if(remain.length() < i) {
                return;
            }
            String selected = remain.substring(0, i);
            int num = Integer.valueOf(selected);
            if(num > 255) {
                continue;
            }
            // IPv4 cannot contain leading zeros
            if(!Integer.toString(num).equals(selected)) {
                continue;
            }

            findIP(remain.substring(i), level + 1, ipAddr + selected + ".", result);
        }
    }
}
