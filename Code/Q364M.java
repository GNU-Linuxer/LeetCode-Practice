// 364. Nested List Weight Sum II (Medium)
// https://leetcode.com/problems/nested-list-weight-sum-ii/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q364M {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = depth(nestedList, 1);
        int[] sum = new int[1];
        calcSum(nestedList, maxDepth, sum);
        return sum[0];
    }

    private int depth(List<NestedInteger> nestedList, int currentDepth) {
        List<Integer> currentDepths = new LinkedList<Integer>(); // We only need to add to the last and traverse the entire list once, so use LinkedList
        currentDepths.add(currentDepth);
        for (NestedInteger i : nestedList) {
            if (!i.isInteger()) {
                currentDepths.add(depth(i.getList(), currentDepth + 1));
            }
        }
        // Similar to Math.max(root.left, root.right); but in this case, we don't know number of branches.
        // Can't use currentDepths.max(); even though currentDepths is a Collection
        return Collections.max(currentDepths);
    }

    private void calcSum(List<NestedInteger> nestedList, int weight, int[] sumPtr) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                // Forgot to add sumPtr[0] + in the right-hand side; otherwise my first attempt would be 100% correct
                sumPtr[0] = sumPtr[0] + i.getInteger() * weight;
            } else {
                calcSum(i.getList(), weight - 1, sumPtr);
            }
        }
    }

    public static void main(String[] args) {
        // [1,[4,[6]]]
        List<NestedInteger> testList = new LinkedList<NestedInteger>();
        testList.add(new NestedInteger(1));
        NestedInteger level1 = new NestedInteger();
        NestedInteger level2 = new NestedInteger();
        testList.add(level1);
        testList.get(1).isinteger = false;
        testList.get(1).list = new LinkedList<NestedInteger>();
        testList.get(1).list.add(new NestedInteger(4));
        testList.get(1).list.add(new NestedInteger());
        testList.get(1).list.get(1).isinteger = false;
        testList.get(1).list.get(1).list = new LinkedList<NestedInteger>();
        testList.get(1).list.get(1).list.add(new NestedInteger(6));

        Q364M test1 = new Q364M();
        System.out.println(test1.depthSumInverse(testList));
    }


    static class NestedInteger {
        public List<NestedInteger> list;
        public Integer num;
        public boolean isinteger;

        public NestedInteger() {
            list = null;
            isinteger = true;
        }

        public NestedInteger(int value) {
            num = value;
            isinteger = true;
        }

        // return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return isinteger;
        }

        // return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            if (isinteger)
                return num;
            else
                return null;
        }

        public void setIntger(int value) {
            if (isinteger)
                num = value;
        }

        public void add(NestedInteger ni) {
            isinteger = false;
            if (list == null)
                list = new ArrayList<NestedInteger>();
            list.add(ni);
        }

        // return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            if (isinteger)
                return null;
            else
                return this.list;
        }
    }
}
