/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /**
 Approach:
Use BFS traversal with a queue and a map of column → list of nodes.

Steps:
Create a queue to hold pairs: (node, columnIndex)
Use a TreeMap<Integer, List<Integer>> to store results sorted by column

Do BFS:
Add left child at col - 1
Add right child at col + 1

At the end, return the map values as a list of lists.

*/

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        class NodeColumn {
            TreeNode node;
            int colIndex;

            NodeColumn(TreeNode node, int colIndex) {
                this.node = node;
                this.colIndex = colIndex;

            }
        }

        Queue<NodeColumn> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        queue.add(new NodeColumn(root, 0)); // intitalize root's column index  to 0

        while(!queue.isEmpty()) { // no need to go level by level BFS
            NodeColumn curr = queue.poll();
            TreeNode currNode = curr.node;
            int colIndex = curr.colIndex;


            if (!map.containsKey(colIndex)) {
                map.put(colIndex, new ArrayList<Integer>());
            }
            map.get(colIndex).add(currNode.val);
        

            if(currNode.left!=null) {
                queue.offer(new NodeColumn(currNode.left, colIndex-1));
            }
            if(currNode.right!=null) {
                queue.offer(new NodeColumn(currNode.right, colIndex+1));
            }
        }

        for (List<Integer> subList: map.values()) {
            res.add(subList);
        }
        
        return res;
    }
}
