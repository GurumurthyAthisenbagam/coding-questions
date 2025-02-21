/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/


/**
Approach: BFS (Breadth-First Search)
To clone a graph using BFS, follow these steps:

Use a HashMap (Map<Node, Node> visited) to store original nodes as keys and their clones as values.
Initialize BFS with the first node, clone it, and add it to the queue.
Process each node in the queue:
Copy its neighbors.
If a neighbor is not cloned, create and map it in visited, then enqueue it.
Return the cloned starting node.
 */
 
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node newRoot = new Node(node.val);

        visited.put(node, newRoot);

        while(!queue.isEmpty()) {
            // place only visited nodes in queue
            // visited means you have already cloned it
            // add the neighbours to the queue
            
            Node currentNode = queue.poll();
            List<Node> neighbors = currentNode.neighbors;
    
            for(Node neighbor: neighbors){
                if(!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    // we create the neighbor clones first
                    visited.put(neighbor, new Node(neighbor.val)); 
                }
                // get current node's clone and add the cloned neighbour as neighbour.
                visited.get(currentNode).neighbors.add(visited.get(neighbor));
            }
        }
        return newRoot;
    }
}
            
