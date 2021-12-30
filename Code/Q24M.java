// 24. Swap Nodes in Pairs (Medium)
// https://leetcode.com/problems/swap-nodes-in-pairs/

public class Q24M {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode result = null;
        ListNode curr = null;
        ListNode headPtr = head;
        ListNode third = null;
        while (headPtr != null && headPtr.next != null) {
            if (result == null) {
                result = headPtr.next;
                third = headPtr.next.next;
                result.next = headPtr;
                result.next.next = null;
                curr = headPtr;
                headPtr = third;
            } else {
                curr.next = headPtr.next;
                third = headPtr.next.next;
                curr.next.next = headPtr;
                headPtr.next = null;
                curr = headPtr;
                headPtr = third;
            }
        }
        // This will consider when we only have 1 un-processed node
        if (result == null) {
            result = headPtr;
        } else {
            curr.next = headPtr;
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
