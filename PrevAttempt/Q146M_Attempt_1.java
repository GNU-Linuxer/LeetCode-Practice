// 146. LRU Cache (Medium)
// https://leetcode.com/problems/lru-cache/

import java.util.HashMap;
import java.util.Map;

public class Q146M_Attempt_1 {
    private ListNode root;
    private ListNode end;
    private final int capacity;
    private final Map<Integer, ListNode> map;

    public Q146M_Attempt_1(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, ListNode>();
    }

    public int get(int key) {
        if (!map.containsKey(key) && map.get(key) == null) {
            // Key does not exist
            return -1;
        }

        // No need to manipulate the LinkedList if it only has 1 element or we're querying the head value
        if (map.size() == 1 || map.get(key).value == root.value) {
            return map.get(key).value;
        }

        // Remove the ListNode from current position and store it to a temporary pointer variable
        ListNode selected = map.get(key);
        int value = selected.value;
        ListNode next = selected.next;

        // The ListNode we're about to remove is at the end of doubly-linked list
        if (next == null) {
            end = end.previous;
            selected.previous.next = null;
        }
        // The ListNode we're about to remove is not at the head of doubly-linked list
        else {
            selected.previous.next = selected.next;
            selected.next.previous = selected;
        }

        // Append the node to the front of doubly-linked list
        selected.next = root;
        root.previous = selected;
        selected.previous = null;
        root = selected;
        return value;
    }

    public void put(int key, int value) {
        // Assume if key is already present (it's like the get), set the value and move to front. Otherwise, Insert Node.
        if (map.containsKey(key)) {
            update(key, value);
            return;
        }

        // If the capacity is 1, drop the entire list and re-assign a new list
        if(capacity == 1) {
            map.clear();
            root = null;
            end = null;
        }

        // Drop the last element from the LinkedList
        else if (map.size() > capacity - 1) {
            ListNode beforeEnd = end.previous;
            int keyToDrop = end.key;
            end = beforeEnd;
            end.next = null; // Drop the end
            map.remove(keyToDrop);
        }

        ListNode insert = new ListNode(key, value);
        boolean firstTimeInsersion = map.isEmpty();
        map.put(key, insert);
        if (firstTimeInsersion) {
            root = insert;
            end = insert;
        }
        // Insert new element to the end of list, not front of list
        else {
            end.next = insert;
            insert.previous = end;
            end = end.next;
        }
    }

    private void update(int key, int value) {
        map.get(key).value = value;
        get(key);
    }

    private class ListNode {
        public int key;
        public int value;
        ListNode next;
        ListNode previous;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Q146M_Attempt_1 obj = new Q146M_Attempt_1(2);
        obj.put(2, 1);
        obj.put(1, 1);
        System.out.println(obj.get(2));
        obj.put(4, 1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
    }
}
