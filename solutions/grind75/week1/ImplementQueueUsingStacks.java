package solutions.grind75.week1;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            tempStack.push(temp);
        }

        int res = tempStack.pop();

        while (!tempStack.isEmpty()) {
            int temp = tempStack.pop();
            stack.push(temp);
        }

        return res;
    }
    
    public int peek() {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            tempStack.push(temp);
        }

        int res = tempStack.pop();
        stack.push(res);

        while (!tempStack.isEmpty()) {
            int temp = tempStack.pop();
            stack.push(temp);
        }

        return res;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}
