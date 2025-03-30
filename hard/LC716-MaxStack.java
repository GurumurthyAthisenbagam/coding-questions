/**
Data Structures
Doubly Linked List (DLL) to represent the stack
So we can remove any node in O(1)
TreeMap<Integer, List<Node>>
Keys: values in the stack
Values: list of nodes with that value (we use the last one inserted for popMax)

To support:
push, pop, top in O(1)
peekMax, popMax in O(log n)


 */

class MaxStack {

    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    TreeMap<Integer, List<Node>> map;
    Node head;
    Node tail;

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNode(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;

    }

    public MaxStack() {
        head = new Node(0); // dummy node
        tail = new Node(0);
        
        head.next = tail;
        tail.prev = head;

        map = new TreeMap<>();
    }
    
    public void push(int x) {
        Node node = new Node(x);
        addNode(node);

        if(!map.containsKey(x)) {
            map.put(x, new ArrayList<Node>());
        }

        map.get(x).add(node);
        
    }
    
    public int pop() {
        Node node = tail.prev;
        removeNode(node);

        List<Node> list = map.get(node.val);
        list.remove(list.size()-1);

        if(list.isEmpty()) map.remove(node.val);
        return node.val;
    }
    
    public int top() {
        return tail.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        
        int val = map.lastKey();
        List<Node> list = map.get(map.lastKey());
        Node node = list.get(list.size()-1);
        list.remove(list.size()-1);
        if(list.isEmpty()) map.remove(node.val);

        removeNode(node);
        return val;

    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
