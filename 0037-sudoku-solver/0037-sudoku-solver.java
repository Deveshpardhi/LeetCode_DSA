class Solution {
    public void solveSudoku(char[][] board) {
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = board[i][j] == '.' ? 0 : board[i][j] - '0';
            }
        }
        sudoku_solver(sudoku, 0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sudoku[i][j] == 0 ? '.' : (char) (sudoku[i][j] + '0');
            }
        }
    }
    
    private int[][] sudoku_solver(int[][] sudoku, int row, int col) {
        if (row == 9) {
            return sudoku;
        }
        
        int nextRow = row;
        int nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow += 1;
            nextCol = 0;
        }
        
        if (sudoku[row][col] != 0) {
            return sudoku_solver(sudoku, nextRow, nextCol);
        }
        
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                int[][] result = sudoku_solver(sudoku, nextRow, nextCol);
                if (result != null) {
                    return result;
                }
                sudoku[row][col] = 0;
            }
        }
        
        return null;
    }
    
    private boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }
        
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        
        return true;
    }
}