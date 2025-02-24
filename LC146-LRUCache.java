/**
LRU cache with O(1) 
use hashmap for cache
doubly linked list for LRU logic
LRU will be in end of DLL
**/

class LRUCache {

    int cacheCapacity;
    Map<Integer,Node> cache = new HashMap<>();

    // Doubly linked list, LRU will be in the end of DLL. 
    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(){
            key =0;
            val=0;
            prev = null;
            next = null;
        }

        public Node(int k, int v) {
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        cacheCapacity = capacity; 
        head.next = tail;
        tail.prev = head;
    }

   
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addNode(Node node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
        
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        } 
        else {
            Node node = cache.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
       
    }
    
    public void put(int key, int val) {

        if(!cache.containsKey(key)) {
            Node node = new Node(key, val);
            cache.put(key,node);
            addNode(node);


            if (cache.size() > cacheCapacity) {
                Node lru = tail.prev;
                removeNode(lru); // remove the LRU node from DLL
                cache.remove(lru.key); // remove the related key from cache as well
            }
        } 
        else {
            Node node = cache.get(key);
            removeNode(node);
            node.val = val; // sometimes val can change for same key
            addNode(node);
        }
        
    } 
}





/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
