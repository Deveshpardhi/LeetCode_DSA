class Solution {
    public boolean isSafe(char[][] arr, int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (i != row && arr[i][col] == digit) return false;  // check column
            if (i != col && arr[row][i] == digit) return false;  // check row
        }

        int si = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = si; i < si + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if ((i != row || j != col) && arr[i][j] == digit) return false;  // check 3x3 box
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isSafe(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
