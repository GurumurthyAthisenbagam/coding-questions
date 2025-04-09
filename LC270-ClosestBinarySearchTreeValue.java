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
    double minimumDistanceFromTarget = Integer.MAX_VALUE;
    int targetValue = -1;
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        targetValue = root.val;

        return findClosestValue(root, target);
        
    }

    int findClosestValue(TreeNode root, double target) {
        if (root == null) {
            return targetValue;
        }

        //System.out.println("node val: " + root.val);
        
        if (Math.abs((double)root.val-target) < minimumDistanceFromTarget) {
            minimumDistanceFromTarget = Math.abs((double)root.val-target);
            targetValue = root.val;
        }
        else if(Math.abs((double)root.val-target) == minimumDistanceFromTarget) {
            targetValue = Math.min(targetValue, root.val);
        }

        if(root.left !=null && target < root.val) findClosestValue(root.left, target);
        if(root.right !=null && target > root.val) findClosestValue(root.right, target);

        return targetValue;
    }
}
