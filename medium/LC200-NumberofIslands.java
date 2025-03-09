/**
Optimal Approach: Depth-First Search (DFS)
Pattern: DFS + In-Place Modification

Steps:

Iterate through each cell in the grid:

If the cell is 1:
Start a DFS to mark all connected 1s as 0.
Increment the island count.
DFS Function:

Recursively visit all connected cells (up, down, left, right).
Change 1 to 0 to mark as visited.
Return the Count of Islands.

Time and Space Complexity:
Time Complexity: O(M * N) — Every cell is visited once.
Space Complexity: O(M * N) — In worst case, recursion stack can go as deep as the total number of cells.

 */

class Solution {
    int islands = 0;
    public int numIslands(char[][] grid) {

        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++){
                if (grid[i][j] == '1') {
                    //grid[i][j] = '0'; dont do this here. 
                    islands++;
                    dfs(grid,i, j);
                }
            }
        }
        return islands;  
    }

    public void dfs(char[][] grid, int r, int c) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(r<0 || r>ROWS-1 || c<0 ||c>COLS-1 || grid[r][c]=='0') { // r>ROWS is incorrect even equal to length is outside the boundry. 
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r, c-1); // watch the parameters order
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);

        return;

    }

}
