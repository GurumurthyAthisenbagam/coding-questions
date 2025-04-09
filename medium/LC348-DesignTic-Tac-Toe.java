/**
Instead of storing the entire board (which would be O(n²)),
just track the counts:

rows[i] → sum of marks on row i
cols[j] → sum of marks on column j
diagonal
antiDiagonal

If a player plays:
Player 1 → add +1
Player 2 → add -1

Then:
If any rows[i] == n → Player 1 wins
If any rows[i] == -n → Player 2 wins
(Same for columns, diagonals)

✅ O(1) per move — very efficient!

 */

class TicTacToe {

    int[] rows, cols;
    int diagonal;
    int antidiagonal;
    int n;


    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int addVal = (player == 1)? 1:-1;

        rows[row] += addVal;
        cols[col] += addVal;

        if (row == col) {
            diagonal += addVal;
        }

        if(row + col == n-1) {
            antidiagonal += addVal;
        }

        if (
            Math.abs(rows[row]) == n ||
            Math.abs(cols[col]) == n ||
            Math.abs(diagonal) == n ||
            Math.abs(antidiagonal) == n
            ) {
                return player;
            }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
