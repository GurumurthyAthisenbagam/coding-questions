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
Compare left and right subtrees.
They must be mirror images:
left.val == right.val
left.left should mirror right.right
left.right should mirror right.left

✅ Recursive check!
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return false;
        return isMirror(root.left, root.right);
        
    }
    boolean isMirror(TreeNode node1, TreeNode node2) {

    if (node1 == null && node2 == null) {
        return true;
    }
    if (node1 == null || node2 == null) {
        return false;
    }
    if (node1.val != node2.val) {
        return false;
    }


    return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
}

}



