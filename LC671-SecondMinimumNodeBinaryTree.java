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

 /***
 Approach 1: DFS (Recursive)

Intuition
The root node has the smallest value.
The second smallest value must be somewhere in the tree but greater than the root.
Use Depth-First Search (DFS) to traverse the tree and find the smallest value greater than root.val.

Algorithm
If a node is null, return.
If the node’s value is greater than the root’s value, update secondMin.
Recursively check both left and right subtrees.

Time Complexity
O(n), where n is the number of nodes in the tree.

Space Complexity
O(h), where h is the height of the tree (O(log n) for balanced trees, O(n) for skewed trees).
 
  */
class Solution {
    long secondMin = Long.MAX_VALUE; // use Long class
    int min;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return (secondMin == Long.MAX_VALUE)? -1: (int)secondMin;
    }

    void dfs(TreeNode node) {
        if(node == null) return;
        if (node.val > min) { // make sure current node val is less than the root
                    secondMin = Math.min(secondMin, node.val);
        }
        dfs(node.left);
        dfs(node.right);
        return;
    }
}
