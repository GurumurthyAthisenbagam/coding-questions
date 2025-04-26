class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // No need to start for loop from i=0 , j=0 and avoid the following check 
        // if ((i-1)>=0 && (j-1) >=0) 
        for (int i=1; i<rows; i++) {
            for (int j=1; j<cols; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) return false;
            }
        }

        return true;
        
    }
}


/**
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if ((i-1)>=0 && (j-1) >=0) {
                    if (matrix[i][j] != matrix[i-1][j-1]) return false;
                }
            }
        }

        return true;
        
    }
}

 */
