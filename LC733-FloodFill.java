/**

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.


Approach: Depth-First Search (DFS)
We use DFS (Recursion) to traverse the image 4-directionally and update connected pixels.

Algorithm:
Get oldColor = image[sr][sc].
If oldColor == newColor, return (to prevent infinite recursion).
Recursively update all 4 neighbors (up, down, left, right) if they match oldColor.

Complexity Analysis
Time Complexity: O(m * n) → Worst case, we visit every pixel.
Space Complexity: O(m * n) → In the worst case, recursion stack depth is O(m * n)

/**

Approach: Depth-First Search (DFS)
We use DFS (Recursion) to traverse the image 4-directionally and update connected pixels.

Algorithm:
Get oldColor = image[sr][sc].
If oldColor == newColor, return (to prevent infinite recursion).
Recursively update all 4 neighbors (up, down, left, right) if they match oldColor.

**/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int oldColor = image[sr][sc];
        int newColor = color;
        if (oldColor != color) {
           dfs(image,sr,sc,newColor, oldColor);
        }
        return image;
        
    }

    public void dfs(int[][] image, int row, int col, int newColor, int oldColor) {
       

       if(row < 0 || row > image.length-1 || col<0 ||col > image[0].length-1) {
        return;
       }

       if(image[r][c] != oldColor) 
        {
             return;
        }

      image[row][col] = newColor;
        
           

       dfs(image,row,col-1, newColor, oldColor);
       dfs(image,row,col+1, newColor, oldColor);
       dfs(image,row-1,col, newColor, oldColor);
       dfs(image,row+1,col, newColor, oldColor);

    }


}
