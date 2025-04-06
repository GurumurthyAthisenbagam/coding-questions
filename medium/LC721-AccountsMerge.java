/**
DFS + Adjacency List

Build the graph:
- For each account, connect all emails together (undirected graph).
- Use Graph - HashMap <Email, Neighbours>
- User EmailToName - HashMap <Email, Name>

DFS:
For each unvisited email, use DFS to collect all connected emails (a full account).
Sort emails and add name.
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        //build the graph
        for (List<String> account : accounts) {
            String name = account.get(0);
            for(int i=1; i<account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new ArrayList<String>());
                // when you haveatleast one entry in graph
                if (i>1) {
                    graph.get(account.get(i)).add(account.get(i-1));
                    graph.get(account.get(i-1)).add(account.get(i));
                }
            }
        }


        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
 
        for (String email: graph.keySet()) {
            if(!visited.contains(email)) {
                List<String> group = new ArrayList();
                dfs(email, graph, visited, group);
                Collections.sort(group);
                group.add(0, emailToName.get(email));
                result.add(group);
            }

        }
        return result;
        
    }

    void dfs(String email, Map<String, List<String>> graph, Set<String> visited, List<String> group) {
        visited.add(email);
        group.add(email);

        for (String neighbour: graph.get(email)) {
            if(!visited.contains(neighbour)) {
                dfs(neighbour, graph, visited, group);
            }
        }
    }
}
