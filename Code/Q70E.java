public class Q70E {
    public int climbStairs(int n) {
        if(n <= 3) {
            return n;
        }

        // numWay[i] = j -> there are j ways to climb stairs up to the i-th position
        int[] numWay = new int[n];
        for(int i = 0; i < n; i ++) {
            if(i < 3) {
                numWay[i] = i + 1;
            } else {
                numWay[i] = numWay[i-1] + numWay[i-2]; // Climb 1 stair and climb 2 stair
            }
        }

        return numWay[n-1];
    }
}
