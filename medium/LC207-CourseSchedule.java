/**
Create Adj list (graph)
Use an array for updaing indegree for all nodes in graph
- for each node default indegree is 0
- iterate over each node and increment the indegree if -> is pointing to it

iterate over the indegree array and add the leaf nodes to queue
i.e. nodes with indegree 0 

iterate over the queue and populate the topo-order list
- deque and add the leaf node to the topo-order list
- reduce the neighbours indegree by one
- if neighbours indegree is zero add it to the queue

if topo-order list not equal to all nodes in graph, cycle is detected

 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Set<Integer>> adjList = new ArrayList<>();

        for(int i=0; i<numCourses;i++) {
            adjList.add(new HashSet<>());
        }

        for (int[] preReq: prerequisites) {
            adjList.get(preReq[0]).add(preReq[1]);
        }

        int[] indegree = new int[numCourses];

        // create indegree
        for(int i=0; i<numCourses ; i++) {
            indegree[i] = 0;
        }

        // update indegree based on adjList
        for(int i=0; i<numCourses; i++) {
            for(int neighbour: adjList.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoList = new ArrayList<>();
        while(!queue.isEmpty()) {
            int node = queue.poll();
            topoList.add(node);

            for(int neighbour: adjList.get(node)) {

                indegree[neighbour]--;

                if(indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
                
            }

        }

        if (topoList.size() != numCourses){
            return false;
        }

        return true;
    }
}
