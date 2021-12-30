// 143. Reorder List (Medium)
// https://leetcode.com/problems/reorder-list/

import java.util.Deque;
import java.util.LinkedList;

public class Q143M {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Deque<ListNode> all = new LinkedList<ListNode>();
        ListNode headPtr = head;

        while (headPtr != null) {
            all.addLast(headPtr);
            headPtr = headPtr.next;
            all.getLast().next = null;
        }

        head = null;

        while (all.size() >= 2) {
            if (head == null) {
                head = all.removeFirst();
                headPtr = head;
            } else {
                headPtr.next = all.removeFirst();
                headPtr = headPtr.next;
            }
            headPtr.next = all.removeLast();
            headPtr = headPtr.next;
        }

        if (!all.isEmpty()) {
            headPtr.next = all.removeFirst();
        }

    }

    public static void main(String[] args) {

    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
