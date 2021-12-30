// 206. Reverse Linked List (Medium)
// https://leetcode.com/problems/reverse-linked-list/

import java.util.Stack;

public class Q206E {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        Stack<ListNode> temp = new Stack<ListNode>();
        ListNode headPtr = head;
        while (headPtr != null) {
            temp.push(headPtr);
            headPtr = headPtr.next;
        }

        ListNode result = temp.pop();
        ListNode resultPtr = result;
        while (!temp.isEmpty()) {
            resultPtr.next = temp.pop();
            resultPtr = resultPtr.next;
        }
        resultPtr.next = null;

        return result;
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
