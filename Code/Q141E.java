// 141. Linked List Cycle (Easy)
// https://leetcode.com/problems/linked-list-cycle/

import java.util.*;

public class Q141E {
    public boolean hasCycle(ListNode head) {
        // Empty LinkedList does not have any cycle
        if(head == null) {
            return false;
        }
        // If I did not override .equals() implementation, Java will only consider two objects equal if they're same object, regardless of the value equality
        Set<ListNode> record = new HashSet<ListNode>();
        ListNode pointer = head;
        while(pointer != null) {
            if(record.contains(pointer)) {
                return true;
            }
            record.add(pointer);
            pointer = pointer.next;
        }
        return false;
    }
    private class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
