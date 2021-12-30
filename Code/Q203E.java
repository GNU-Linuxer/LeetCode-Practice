// 203. Remove Linked List Elements (Easy)
// https://leetcode.com/problems/remove-linked-list-elements/

public class Q203E {
    public ListNode removeElements(ListNode head, int val) {
        ListNode headPtr = head;

        // If the value appears in the beginning of list
        while (headPtr != null && headPtr.val == val) {
            headPtr = headPtr.next;
        }

        // head is empty or only contains val
        if (headPtr == null) {
            return null;
        }

        ListNode result = new ListNode(headPtr.val);
        ListNode resultPtr = result;

        while (headPtr.next != null) {
            if (headPtr.next.val != val) {
                resultPtr.next = new ListNode(headPtr.next.val);
                resultPtr = resultPtr.next;
            }
            headPtr.next = headPtr.next.next;
        }

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
