import java.util.*;

class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Push to back
    public void push(int x) {
        inStack.push(x);
    }

    // Remove from front
    public int pop() {
        peek(); // ensure outStack has elements
        return outStack.pop();
    }

    // Get front
    public int peek() {

        // Move only if needed
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    // Check empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
