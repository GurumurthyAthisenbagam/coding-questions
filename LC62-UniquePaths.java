/**
Approach 1: DP with 2D Array
Create a dp 2D array of size m x n.
Initialize:
First row = 1 (only move right).
First column = 1 (only move down).
Fill the rest using:
dp[i][j] = dp[i-1][j] + dp[i][j-1];
Return dp[m-1][n-1].
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // initialize first row and first column to 1: we cannot move left or up. So, to reach each cell in that 
        for (int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i<dp[0].length; i++) {
            dp[0][i] = 1;
        }

        // nested for loop starts with 1 for row and column because we already computed values for row =0, col = 0
        for (int i =1; i<dp.length; i++) { 
            for (int j =1; j<dp[0].length; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j]; // add the left and top 
            }

        }

        return dp[m-1][n-1];
    }
}
