/**
Separate Chaining using Buckets (LinkedLists or ArrayLists)
A fixed-size array (say, size = 10,000)
Each index stores a list of (key, value) pairs
We use a simple hash function: key % size


Time Complexity (Average Case)
Operation	Time
put	O(1)
get	O(1)
remove	O(1)
 */
class MyHashMap {

    int SIZE = 10000;
    List<Node>[] buckets;

    class Node {
        int key;
        int val;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    

    public MyHashMap() {
        buckets = new List[SIZE];
    }

    public int hash(int key) {
        return key%SIZE;
    }
    
    public void put(int key, int value) {

        int hashedIndex = hash(key);

        if (buckets[hashedIndex] == null) {
            buckets[hashedIndex] = new LinkedList<Node>();
        }


        for (Node curr: buckets[hashedIndex]) {
            if(curr.key == key) {
                curr.val = value;
                return;
            }
        }

        buckets[hashedIndex].add(new Node(key, value));
    }
    
    public int get(int key) {
        int hashedIndex = hash(key);
         if (buckets[hashedIndex] == null) { 
            return -1;
         }

        for (Node curr: buckets[hashedIndex]) {
            if(curr.key == key) {
                return curr.val;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int hashedIndex = hash(key);
        
        if (buckets[hashedIndex] == null) { 
            return;
        }
        
        List currList = buckets[hashedIndex];

        Iterator<Node> itr = currList.iterator();

        while (itr.hasNext()) {
            if(itr.next().key == key) {
                itr.remove();
                return;
            }
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
