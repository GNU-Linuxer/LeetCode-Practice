// 468. Validate IP Address (Medium)
// https://leetcode.com/problems/validate-ip-address/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Q468M {
    public String validIPAddress(String queryIP) {
        if(queryIP == null && queryIP.length() <= 4) {
            return "Neither";
        }
        // Constraints: queryIP consists only of English letters, digits and the characters '.' and ':'.

        boolean potentialIPv4 = queryIP.indexOf(".") > 0;
        boolean potentialIPv6 = queryIP.indexOf(":") > 0;

        // An ip address can't be both IPv4 and IPv6
        if(potentialIPv4 && potentialIPv6) {
            return "Neither";
        }

        if(potentialIPv4) {
            Pattern p = Pattern.compile("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}");
            Matcher m = p.matcher(queryIP);
            if(!m.matches()) {
                return "Neither";
            }
            String[] possibleIPv4 = queryIP.split("\\.");
            for(String i : possibleIPv4) {
                // Each IPv4 address block can only contain number
                int digit = Integer.parseInt(i);
                if(digit >= 256) {
                    return "Neither";
                }
                // IPv4 cannot contain leading zeros
                if(!i.equals(Integer.toString(digit))) {
                    return "Neither";
                }
            }
            return "IPv4";
        }

        if(potentialIPv6) {
            Pattern p = Pattern.compile("[a-fA-F0-9]{1,4}:[a-fA-F0-9]{1,4}:[a-fA-F0-9]{1,4}:[a-fA-F0-9]{1,4}:[a-fA-F0-9]{1,4}:[a-fA-F0-9]{1,4}:[a-fA-F0-9]{1,4}:[a-fA-F0-9]{1,4}");
            Matcher m = p.matcher(queryIP);
            if(m.matches()) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    public static void main(String[] args) {
        Q468M test1 = new Q468M();
        String IPv4 = "172.16.254.1";
        String IPv6 = "2001:db8:85a3:0:0:8A2E:037j:7334";
        System.out.println(test1.validIPAddress(IPv6));
    }
}