// 509. Fibonacci Number (Easy)
// https://leetcode.com/problems/fibonacci-number/

public class Q509E {
    public int fib(int n) {
        // Special case: the Fibonacci number of 0 is 0
        if (n == 0) {
            return 0;
        }

        // F(n) = 1 if n=1 OR n=2
        if (n == 1 || n == 2) {
            return 1;
        }

        // F(n) = (F(n-1) + F(n-2)) for other positive integers n
        int result = 1;
        int valueOfNMinusTwo = 1; // the value of F(n-2)
        int valueOfNMinusOne = 1; // the value of F(n-1)
        for (int i = 3; i <= n; i++) {
            // Store F(n-1) and F(n-2) before calculating F(n),
            // which depends on the F(n-1) and F(n-2) values
            valueOfNMinusTwo = valueOfNMinusOne;
            valueOfNMinusOne = result;
            result = valueOfNMinusOne + valueOfNMinusTwo;
        }

        return result;
    }

    public static void main(String[] args) {
        Q509E test1 = new Q509E();
        System.out.println("Fibonacci of " + 10 + " is: " + test1.fib(10));
    }
}
