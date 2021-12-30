// 234. Palindrome Linked List (Easy)
// https://leetcode.com/problems/palindrome-linked-list/

import java.util.Deque;
import java.util.LinkedList;

public class Q234E {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> nodes = new LinkedList<ListNode>();

        ListNode headPtr = head;
        while (headPtr != null) {
            nodes.addLast(headPtr);
            headPtr = headPtr.next;
        }

        while (nodes.size() > 1) {
            if (nodes.removeFirst().val != nodes.removeLast().val) {
                return false;
            }
        }

        return true;
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
