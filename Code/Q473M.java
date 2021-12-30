// 473. Matchsticks to Square (Medium)
// https://leetcode.com/problems/matchsticks-to-square/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Q473M {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();

        // If sum can't be divided by 4, then there's no way to arrange matchstick to square
        if (sum % 4.0 != 0) {
            return false;
        }

        int sideLength = sum / 4;

        List<Integer> availableMathSticks = new ArrayList<Integer>(matchsticks.length);
        for (int i : matchsticks) {
            availableMathSticks.add(i);
        }

        // Sort array in reverse order
        Collections.sort(availableMathSticks);
        Collections.reverse(availableMathSticks);

        // The longest stick is greater than the sideLength, impossible to form a square
        if (availableMathSticks.get(0) > sideLength) {
            return false;
        }

        // Length of unclaimed space for each side
        int[] spaceRemaining = new int[4];
        Arrays.fill(spaceRemaining, sideLength);

        return helper(availableMathSticks, 0, sideLength, spaceRemaining);
    }

    private boolean helper(List<Integer> availableMathSticks, int index, int sideLength, int[] spaceRemainingPtr) {
        // We've used all matches, which is great
        if (index >= availableMathSticks.size()) {
            return true;
        }

        // Traverse all 4 sides
        for (int i = 0; i < 4; i++) {
            // This stick is too long to use on this side anymore
            if (availableMathSticks.get(index) > spaceRemainingPtr[i]) {
                continue;
            }
            spaceRemainingPtr[i] -= availableMathSticks.get(index);
            // Grab a next stick to fill this side, and if it can be put in
            if (helper(availableMathSticks, index + 1, sideLength, spaceRemainingPtr)) {
                return true;
            }
            // This stick can't be used, so un-choose
            else {
                spaceRemainingPtr[i] += availableMathSticks.get(index);
            }
        }

        return false; // We can't form squares using these sets of matches;
    }

    public static void main(String[] args) {
        Q473M test1 = new Q473M();
        System.out.println(test1.makesquare(new int[]{1, 1, 2, 2, 2}));
    }
}