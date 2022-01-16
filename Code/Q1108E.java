// 1108. Defanging an IP Address (Easy)
// https://leetcode.com/problems/defanging-an-ip-address/

public class Q1108E {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
