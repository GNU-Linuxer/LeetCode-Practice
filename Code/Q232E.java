// 232. Implement Queue using Stacks (Easy)
// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class Q232E {
    public static void main(String[] args) {
        int x = 1;
        MyQueue obj = new MyQueue();
        obj.push(x);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }

    static class MyQueue {

        Stack<Integer> stack1; // Main data
        Stack<Integer> stack2; // Temporary data storage when implementing peek and pop operations
        public MyQueue() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            int result = 0;
            // Allow to use stack size method
            while(!stack1.isEmpty()) {
                if(stack1.size() == 1) {
                    result = stack1.pop();
                } else {
                    stack2.push(stack1.pop());
                }
            }
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }

        public int peek() {
            int result = 0;
            // Allow to use stack size method
            while(!stack1.isEmpty()) {
                if(stack1.size() == 1) {
                    result = stack1.peek();
                }
                stack2.push(stack1.pop());

            }
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}
