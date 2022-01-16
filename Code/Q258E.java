// 258. Add Digits (Easy)
// https://leetcode.com/problems/add-digits/

public class Q258E {
    public int addDigits(int num) {
        if(num < 10) {
            return num;
        }

        String str = Integer.toString(num);
        int sum = Integer.MAX_VALUE;
        while(sum >= 10) {
            sum = 0;
            for (int i = 0; i < str.length(); i ++) {
                int num1 = Character.getNumericValue(str.charAt(i));
                sum += num1;
            }
            str = Integer.toString(sum);
        }
        return sum;
    }
}
