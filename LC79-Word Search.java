/**
Time complexity: 
O(m ∗4^n)

Space complexity: 
O(n)

Where 

m is the number of cells in the board

n is the length of the word

 */

class Solution {
    public int ROWS;
    public int COLS;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for(int i =0; i<ROWS; i++) {
            for(int j=0; j <COLS; j++){
                if(dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }


public boolean dfs(char[][] board, String word, int r, int c, int index) {

    boolean res = false;

    if(index == word.length()) {
        return true;
    }

    if(r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c]!=word.charAt(index) || visited[r][c] == true) {
        return false;
    }

    visited[r][c] = true;

    res = dfs(board,word,r,c-1,index+1) ||
            dfs(board,word,r,c+1,index+1) ||
            dfs(board,word,r-1,c,index+1) ||
            dfs(board,word,r+1,c,index+1);

    if(res!= true) visited[r][c] = false;

    return res;
    
}

}
