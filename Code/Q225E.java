// 225. Implement Stack using Queues (Easy)
// https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;

public class Q225E {
    public static void main(String[] args) {
        int x = 1;
        MyStack obj = new MyStack();
        obj.push(x);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
    }

    static class MyStack {
        Queue<Integer> queue1; // Actual data

        public MyStack() {
            queue1 = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue1.add(x);
        }

        public int pop() {
            // Rotate Queue until we reach to all element, since we're allowed to use size() on a Queue
            int size = queue1.size();
            int result = 0;
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    result = queue1.remove();
                } else {
                    queue1.add(queue1.remove());
                }
            }
            return result;
        }

        public int top() {
            // Rotate Queue until we reach to all element, since we're allowed to use size() on a Queue
            int size = queue1.size();
            int result = 0;
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    result = queue1.peek();
                }
                queue1.add(queue1.remove());
            }
            return result;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
