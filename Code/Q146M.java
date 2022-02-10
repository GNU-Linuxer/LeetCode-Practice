// 146. LRU Cache (Medium)
// https://leetcode.com/problems/lru-cache/

import java.util.HashMap;
import java.util.Map;

public class Q146M {
    private ListNode root;
    private ListNode end;
    private final int capacity;
    private final Map<Integer, ListNode> map;

    public Q146M(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, ListNode>();
        this.root = new ListNode(0, 0);
        this.end = new ListNode(0, 0);
        root.next = end;
        end.previous = root;
    }

    public int get(int key) {
        if (!map.containsKey(key) && map.get(key) == null) {
            // Key does not exist
            return -1;
        }

        // Remove the ListNode from current position and store it to a temporary pointer variable
        ListNode node = map.get(key);

        // Connect the previous node and subsequent node together
        ListNode prevNode = node.previous;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.previous = prevNode;

        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        // Assume if key is already present, set the value and move to front. Otherwise, Insert Node.
        if (map.containsKey(key)) {
            update(key, value);
            return;
        }
        // Drop the last element from the LinkedList (note that we have a dummy ListNode on head and dummy ListNode on tail)
        if (map.size() > capacity - 1) {
            dropLastNode();
        }

        ListNode insert = new ListNode(key, value);
        moveToFront(insert);

        // Add this new node to the map
        map.put(key, insert);
    }

    // Move a given node to the front of list
    private void moveToFront(ListNode node) {
        // Doubly-linked list, so we need to link twice
        ListNode currFirst = root.next;
        root.next = node;
        node.previous = root;
        node.next = currFirst;
        currFirst.previous = node;
    }


    private void update(int key, int value) {
        map.get(key).value = value;
        get(key);
    }

    private void dropLastNode() {
        // Re-arrange nodes
        ListNode nodeToDrop = end.previous;
        nodeToDrop.previous.next = end;
        end.previous = nodeToDrop.previous;

        // Drop the node
        int keyToDrop = nodeToDrop.key;
        nodeToDrop = null;
        map.remove(keyToDrop);
    }

    private class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode previous;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Q146M obj = new Q146M(2);
        obj.put(2, 1);
        obj.put(1, 1);
        System.out.println(obj.get(2));
        obj.put(4, 1);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
    }
}
