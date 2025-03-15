/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
Algorithm
Base Case:

If the current node is null, return null.
If the current node is either p or q, return the current node.
Recursive Traversal:

Recursively find LCA in the left subtree.
Recursively find LCA in the right subtree.
Decision Making:

If both left and right recursive calls return a non-null value, the current node is the Lowest Common Ancestor.
If only one side returns a non-null value, return that side.
If both are null, return null.

 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left!=null && right!=null) {
            return root;
        }

        return left!=null? left: right; 
    }
}
