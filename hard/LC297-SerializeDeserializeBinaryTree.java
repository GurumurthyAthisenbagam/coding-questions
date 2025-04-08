/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
 
 use string buffer
 serialize using DFS preorder traversal
 append "null" for leaf node's left and right

 when deserializing 
 use a queue to create treenodes recursively use DFS preorder traversal again
 return null when you encounter "null" string
 create a new node
 call dfs of left and right, populate the current node's left and right
 
  */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder strB = new StringBuilder();

        dfs(root, strB);
        return strB.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    TreeNode deserializeHelper(Queue<String> queue) {
        // root (1), left(2), lleft(null), lright(null), right(3), rleft(4), rright(5)
        // root, left, right
        // 1 2 3 null null 4 5
        String val = queue.poll();
        if (val.equals("null")) return null;
        
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);

        return node;

    }

    void dfs(TreeNode node, StringBuilder strB) {
        if(node == null) {
            strB.append("null,");
            return;
        }

        strB.append(node.val + ",");
        dfs(node.left, strB);
        dfs(node.right, strB);

        return;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
