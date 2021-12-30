// 690. Employee Importance (Medium)
// https://leetcode.com/problems/employee-importance/

import java.util.*;

public class Q690M {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> importance = new HashMap<Integer, Integer>();
        Map<Integer, List<Integer>> subordinatesList = new HashMap<Integer, List<Integer>>();
        for (Employee i : employees) {
            importance.put(i.id, i.importance);
            subordinatesList.put(i.id, i.subordinates);
        }
        employees = null;
        int importanceVal = 0;
        Queue<Integer> selectedEmployee = new LinkedList<Integer>();
        selectedEmployee.add(id);
        int ID = -1;
        while (!selectedEmployee.isEmpty()) {
            ID = selectedEmployee.remove();
            if (importance.containsKey(ID)) {
                importanceVal += importance.get(ID);
                selectedEmployee.addAll(subordinatesList.get(ID));
                importance.remove(ID);
                selectedEmployee.remove(ID);
            }
        }
        return importanceVal;
    }

    public static void main(String[] args) {

    }

    private class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

}
