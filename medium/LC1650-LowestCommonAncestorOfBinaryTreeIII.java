/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

/**
This is similar to intersection to two linkedlist. Since we have two nodes and finding common ancestor = intersection. 

When we walk upward from two nodes p and q toward the root:
If their depths (distance to root) are different,
one pointer will reach the root earlier than the other.

👉 Switching to the other starting node after reaching null ensures that:
Both pointers traverse the same total distance.

It "equalizes" their journeys.
Thus they meet exactly at the lowest common ancestor.
 */
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node A = p;
        Node B = q;

        while (A!=B) {
            A = (A==null) ? q: A.parent;
            B = (B==null) ? p: B.parent;
        }

        return A;
    }
}
