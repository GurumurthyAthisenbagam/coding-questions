/**
Approach: Backtracking (DFS)

Intuition
We build valid sequences recursively.
A valid sequence must always have at least as many ( as ) at any point.

Two constraints:
We can add ( if open < n.
We can add ) if close < open.

Algorithm
Start with an empty string.
If open < n, add "(" and recurse.
If close < open, add ")" and recurse.
Base case: When open == close == n, add the combination to the result.

Time Complexity
O(4ⁿ / √n) → Catalan number complexity.
Efficient for small to medium n.

Space Complexity
O(n) → Recursion depth.
**/

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList();

        backtrack("", 0, 0, res, n);
        return res;
    }

    void backtrack(String current, int open, int close, List<String> res, int n) {

        if(current.length() == n * 2) {
            res.add(current);
            return;
        }
        
        if (open<n) {
            backtrack(current + "(", open+1, close, res, n);
        }

        if(close<open){
            backtrack(current + ")", open, close+1, res, n);
        }

        return;

    }
}
