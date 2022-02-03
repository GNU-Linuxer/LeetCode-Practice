// 476. Number Complement (Easy)
// https://leetcode.com/problems/number-complement/

public class Q476E {
    public int findComplement(int num) {
        int binLength = Integer.toBinaryString(num).replaceFirst("^0", "").length();
        int mask = ~0 << binLength;
        return ~num ^ mask;
    }

    public static void main(String[] args) {
        Q476E test1 = new Q476E();
        System.out.println(test1.findComplement(5));
    }
}
