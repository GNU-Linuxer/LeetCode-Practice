// 339. Nested List Weight Sum (Medium)
// https://leetcode.com/problems/nested-list-weight-sum/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q339M {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }

        int[] sum = {0};
        calcSum(nestedList, 1, sum);

        return sum[0];
    }

    private void calcSum(List<NestedInteger> nestedListPtr, int level, int[] sumPtr) {
        for (NestedInteger i : nestedListPtr) {
            if (!i.isInteger()) {
                calcSum(i.getList(), level + 1, sumPtr);
            } else {
                sumPtr[0] = sumPtr[0] + i.getInteger() * level;
            }
        }
    }

    public static void main(String[] args) {
        // [1,[4,[6]]]
        List<Q339M.NestedInteger> testList = new LinkedList<Q339M.NestedInteger>();
        testList.add(new Q339M.NestedInteger(1));
        Q339M.NestedInteger level1 = new Q339M.NestedInteger();
        Q339M.NestedInteger level2 = new Q339M.NestedInteger();
        testList.add(level1);
        testList.get(1).isinteger = false;
        testList.get(1).list = new LinkedList<Q339M.NestedInteger>();
        testList.get(1).list.add(new Q339M.NestedInteger(4));
        testList.get(1).list.add(new Q339M.NestedInteger());
        testList.get(1).list.get(1).isinteger = false;
        testList.get(1).list.get(1).list = new LinkedList<Q339M.NestedInteger>();
        testList.get(1).list.get(1).list.add(new Q339M.NestedInteger(6));

        Q339M test1 = new Q339M();
        System.out.println(test1.depthSum(testList));
    }

    static class NestedInteger {
        public List<Q339M.NestedInteger> list;
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

        public void add(Q339M.NestedInteger ni) {
            isinteger = false;
            if (list == null)
                list = new ArrayList<Q339M.NestedInteger>();
            list.add(ni);
        }

        // return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<Q339M.NestedInteger> getList() {
            if (isinteger)
                return null;
            else
                return this.list;
        }
    }
}
