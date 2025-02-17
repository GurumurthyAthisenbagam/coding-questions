/** 
Given a binary tree, determine if it is 
height-balanced


**/


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
class Solution {
    public boolean isBalanced(TreeNode root) {

    int height = height(root);
    if(height == -1) 
    return false;
    else
    return true;
        
    }

    int height(TreeNode node) {
        if(node == null){
            return 0;
        }

        int rightHeight = height(node.right);
        if(rightHeight == -1) return -1;
        
        int leftHeight = height(node.left);
        if(leftHeight == -1) return -1;

        int heigthDiff = Math.abs(rightHeight-leftHeight);

        if(heigthDiff > 1){
            return -1;
        }

        return Math.max(rightHeight,leftHeight)+1;

    }

}
