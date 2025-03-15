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
 In-order traversal, will sorted list
 send the kth element by index
 O(n)
  */

class Solution {
    List<TreeNode> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
    dfs(root);
    if (list.size()>=k) {
        return list.get(k-1).val;
    }
    return -1;
        
    }


    public void dfs (TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }
}
