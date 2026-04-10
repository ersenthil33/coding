 import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();   // to store final result
        boolean[] col = new boolean[n];          // track columns
        boolean[] diag = new boolean[2 * n];     // track diagonals
        boolean[] antidiag = new boolean[2 * n]; // track anti-diagonals

        char[][] board = new char[n][n];  // created a board of n*n

        // fill board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');  // placed . in all rows
        }

        // start backtracking from row 0
        backtrack(0, n, board, result, col, diag, antidiag);

        return result;
    }

    
    void backtrack(int row, int n, char[][] board,
                   List<List<String>> result,
                   boolean[] col,
                   boolean[] diag,
                   boolean[] antidiag) {

        // BASE CASE
        if (row == n) {
            result.add(construct(board)); // found valid solution so add to result
            return;
        }

        // try placing queen in each column
        for (int c = 0; c < n; c++) {

            // checks if safe
            if (col[c] || diag[row + c] || antidiag[row - c + (n - 1)]) {
                continue;
            }

            // PLACE queen
            board[row][c] = 'Q';
            col[c] = true;
            diag[row + c] = true;
            antidiag[row - c + (n - 1)] = true;

            
            backtrack(row + 1, n, board, result, col, diag, antidiag);

            // BACKTRACK (undo)
            board[row][c] = '.';
            col[c] = false;

            diag[row + c] = false;              
            antidiag[row - c + (n - 1)] = false;
        }
    }

    
    List<String> construct(char[][] board) {

        List<String> res = new ArrayList<>();

        for (char[] row : board) {
            res.add(new String(row));   // convert char[] to  String
        }

        return res;
    }
}