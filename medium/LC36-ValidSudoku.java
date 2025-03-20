/** 

Approach: HashSet for Rows, Columns, and Boxes


Intuition
Use 3 HashSets:
rowSet[i] → Track numbers in row i.
colSet[j] → Track numbers in column j.
boxSet[i][j] → Track numbers in 3x3 box (i, j).
Algorithm
Iterate through the board:
If a number is already in row, column, or box, return false.
Otherwise, add it to the respective HashSet.
Return true if no duplicates are found.
Box Calculation:
Each (row, col) belongs to a box:

𝑏𝑜𝑥𝐼𝑛𝑑𝑒𝑥 = (𝑟𝑜𝑤/3,𝑐𝑜𝑙/3)
boxIndex=(row/3,col/3)
Time Complexity:
O(9²) = O(81) = O(1) → Constant time for a 9x9 board.
Space Complexity:
O(9) = O(1) → Fixed storage for HashSets.

**/

class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') continue;

                int boxIndex = (i / 3) * 3 + (j / 3); // Compute 3x3 box index

                if (rowSet[i].contains(num) || colSet[j].contains(num) || boxSet[boxIndex].contains(num)) {
                    return false; // Duplicate found!
                }

                rowSet[i].add(num);
                colSet[j].add(num);
                boxSet[boxIndex].add(num);
            }
        }
        return true;

    }
}
