/**
define boundaries top, bottom, left, right
visit elements then shrink the boundaries. i.e.

visit top row then increment top
visit right most column decrement right
visit bottom most row decrement bottom
visit left most column and increment left

repeat

 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

    int m = matrix[0].length; // number of columns
    int n = matrix.length; // number of rows

    // define boundaries
    int top =0;
    int left =0;
    int right = m-1;
    int bottom = n-1;

    List<Integer> numbers = new ArrayList();

    while (top<=bottom && left<=right) {

        // go from left to right and increment the top
        for(int i=left; i<=right; i++) {
            numbers.add(matrix[top][i]);
        }
        top++;

        // go from top to bottom and decrement the right
        for(int i=top; i<=bottom; i++) {
            numbers.add(matrix[i][right]);
        }
        right--;


        // go from right to left and decrement the bottom
        if(top<=bottom) {
            for(int i=right; i>=left; i--) {
                numbers.add(matrix[bottom][i]);
            }
        }
        bottom--;

        // go from bottom to top and increment the left
        if(left<=right) {
            for(int i=bottom; i>=top; i--) {
                numbers.add(matrix[i][left]);
            }
        }
        left++;

    }


    return numbers;     
        
    }
}
