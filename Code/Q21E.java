// 21. Merge Two Sorted Lists (Easy)
// https://leetcode.com/problems/merge-two-sorted-lists/
public class Q21E {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode current = null;
        ListNode List1Ptr = list1;
        ListNode List2Ptr = list2;
        while (List1Ptr != null || List2Ptr != null) {
            // Since we have run out of either list, we can assume that unprocessed elements of other list can be appended to the end of result, so we can just link pointer
            if (List1Ptr == null) {
                if (result == null) {
                    result = List2Ptr;
                } else {
                    current.next = List2Ptr;
                }
                break;
            }

            // Regular case
            if (List2Ptr == null) {
                if (result == null) {
                    result = List1Ptr;
                } else {
                    current.next = List1Ptr;
                }
                break;
            }

            if (List1Ptr.val <= List2Ptr.val) {
                if (result == null) {
                    result = new ListNode(List1Ptr.val);
                    current = result;
                } else {
                    current.next = new ListNode(List1Ptr.val);
                    current = current.next;
                }
                List1Ptr = List1Ptr.next;
            } else if (List1Ptr.val > List2Ptr.val) {
                if (result == null) {
                    result = new ListNode(List2Ptr.val);
                    current = result;
                } else {
                    current.next = new ListNode(List2Ptr.val);
                    current = current.next;
                }
                List2Ptr = List2Ptr.next;
            }
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

