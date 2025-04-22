class Solution {
    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row+1][col+1];
        int maxSide = 0;

        for ( int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+ 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        
        return maxSide * maxSide;
    }
}
