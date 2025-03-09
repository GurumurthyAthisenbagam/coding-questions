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
    public TreeNode invertTree(TreeNode root) {

        TreeNode start = root;
        if(root == null) return null;

        return invert(start);
        
    }

    public TreeNode invert(TreeNode root) {

        if(root.left == null && root.right == null) {
            return root;
        }
        else if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
            invert(root.left);
            return root;
        } 
        else if(root.right == null && root.left != null) {
            root.right = root.left;
            root.left = null;
            invert(root.right);
            return root;
        } 
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invert(root.left);
            invert(root.right);
            return root;
        }


    }
}

/**
class Solution {
    public TreeNode invertTree(TreeNode root) {


        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}


 */
