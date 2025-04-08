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
 Use post-order DFS traversal (left → right → root).

At each node:
Calculate left max and right max
Update a global max (maxSum) with left + node + right (full path through node)
Return node.val + max(left, right) to parent (because path cannot fork upwards)
 
  */
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    int dfs(TreeNode node) {

        if(node == null) return 0;
        
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));

        int currentSum = node.val + leftMax + rightMax;

        maxSum = Math.max(maxSum, currentSum);

        return node.val + Math.max(leftMax, rightMax);

    }
}
