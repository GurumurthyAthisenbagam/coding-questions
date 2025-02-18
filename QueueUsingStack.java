/**
Approach:
We use two stacks:

inputStack: Used to push elements.
outputStack: Used for dequeuing (pop/peek operations).
Algorithm:
Push operation (push(x)):

Simply push x onto inputStack.
Pop operation (pop()):

If outputStack is empty, transfer all elements from inputStack to outputStack (this reverses the order to maintain FIFO).
Pop the top element from outputStack.
Peek operation (peek()):

If outputStack is empty, transfer all elements from inputStack to outputStack.
Return the top element of outputStack.
Empty operation (empty()):

The queue is empty if both inputStack and outputStack are empty.

Complexity Analysis:
Push (push(x)) → O(1) (Constant time push to stack)
Pop (pop()) → Amortized O(1), worst O(N) (Transfers elements from inputStack to outputStack only when needed)
Peek (peek()) → Amortized O(1), worst O(N) (Similar to pop)
Empty (empty()) → O(1) (Simple stack check)


**/

class MyQueue {
    
    Stack<Integer> inputStack = new Stack<>();
    Stack<Integer> outputStack = new Stack<>();

    public MyQueue() {        

    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        if(outputStack.isEmpty()) {
            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }
    
    public int peek() {

        if(outputStack.isEmpty()) {
            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

            int x = outputStack.pop();
            outputStack.push(x);
            return x;
        
    }
    
    public boolean empty() {
        if(inputStack.isEmpty() && outputStack.isEmpty()) {
            return true;
        } 
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
