/**

Optimal Approach: Using Two Stacks
Pattern: Stack + Auxiliary Stack for Minimum Tracking

Idea:

Use two stacks:
stack — For normal stack operations (push, pop, top).
minStack — For tracking the minimum element at each level of the stack.
Push the new element to minStack only if it is smaller than or equal to the current minimum.
On pop(), if the element being removed is the current minimum, pop it from minStack too.
Why Two Stacks Work:

Ensures that getMin() always returns the top of minStack in O(1) time.
Both stacks grow and shrink together, maintaining the minimum efficiently.
**/

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        if(minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        stack.pop();

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
