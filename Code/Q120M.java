// 120. Triangle (Medium)
// https://leetcode.com/problems/triangle/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q120M {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        List<List<Integer>> minSumSoFar = new ArrayList<List<Integer>>();

        List<Integer> firstRow = new LinkedList<Integer>();
        firstRow.add(triangle.get(0).get(0));
        minSumSoFar.add(firstRow);

        for(int i = 1; i < triangle.size(); i ++) {
            minSumSoFar.add(new ArrayList<Integer>());
            for(int j = 0; j < triangle.get(i).size(); j ++) {
                if(j == 0) {
                    //System.out.println(Math.min(minSumSoFar.get(i-1).get(j), minSumSoFar.get(i-1).get(j+1)));
                    minSumSoFar.get(i).add(j, minSumSoFar.get(i-1).get(j) + triangle.get(i).get(j));
                } else if (j == triangle.get(i).size()-1) {
                    minSumSoFar.get(i).add(j, minSumSoFar.get(i-1).get(j-1) + triangle.get(i).get(j));
                } else {
                    minSumSoFar.get(i).add(j, Math.min(minSumSoFar.get(i-1).get(j-1), minSumSoFar.get(i-1).get(j)) + triangle.get(i).get(j));
                }
            }
        }

        return Collections.min(minSumSoFar.get(minSumSoFar.size()-1));
    }
    
}
