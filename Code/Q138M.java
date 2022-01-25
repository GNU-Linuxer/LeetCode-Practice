// 138. Copy List with Random Pointer (Medium)
// https://leetcode.com/problems/copy-list-with-random-pointer/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q138M {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        // Cue: val in all nodes are not guaranteed to be unique
        // Two map method: index-Node and Node-index for original (use Two Map method if I need to use 1-1 relationship in interview)
        List<Node> indexNode = new ArrayList<Node>();
        Map<Node, Integer> nodeIndex = new HashMap<Node, Integer>();

        List<Node> indexNodeCpy = new ArrayList<Node>();

        Node headPtr = head;
        Node result = new Node(head.val);
        Node resultPtr = result;
        indexNode.add(head);
        nodeIndex.put(head, 0);
        indexNodeCpy.add(result);
        int i = 1;
        while(headPtr.next != null) {
            indexNode.add(headPtr.next);
            nodeIndex.put(headPtr.next, i);
            resultPtr.next = new Node(headPtr.next.val); // can't use resultPtr = new Node(headPtr.val);

            indexNodeCpy.add(resultPtr.next);

            headPtr = headPtr.next;
            resultPtr = resultPtr.next;
            i ++;
        }

        resultPtr = result;
        for(int j = 0; j < indexNode.size(); j ++) {
            Node nodeFromOrigin = indexNode.get(j).random;
            if(nodeFromOrigin != null) {
                int index = nodeIndex.get(nodeFromOrigin);
                resultPtr.random = indexNodeCpy.get(index);
            }
            resultPtr = resultPtr.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Q138M test1 = new Q138M();
        // Create Test Nodes
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        // Bind their .next and .random pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;


        Node head = node1;
        System.out.println(test1.copyRandomList(head));
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
