class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        int[][] neighbours= { {0,-1}, {0,1}, {1, 0}, {-1, 0} };

        for (int r=0; r<grid.length ;  r++) {
            for (int c=0; c<grid[0].length; c++) {
                int curr = grid[r][c];
                if (curr == 1) {
                    for (int[] neighbour : neighbours) {
                        int newR = r + neighbour[0];
                        int newC = c + neighbour[1];
                        if ((newR <0 || newR >=grid.length) || 
                            (newC <0 || newC >= grid[0].length) || grid[newR][newC] == 0)            {
                            perimeter++;
                        }

                    }
                }
            }
        }

    return perimeter;
        
    }
}
