/*
The question is all about checking what is not already present and moving on.
we check row,col and the matrix before placing a number in a blank space. we backtrack if we fail onwards.
we store numbers in boolean array for faster checking of duplicates for each loop
we end the loop when we reach the end without failing (for a valid sudoku it doesn't fail)
 */

import java.util.Arrays;

public class Backtracking_Leetcode_37_SudokuSolver {
    public static void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    public static boolean dfs(char[][] board, int d) {
        if (d == 81) return true;  //reached the end point
        int i = d / 9, j = d % 9;  //faster way of choosing row and col
        if (board[i][j] != '.') return dfs(board, d + 1); // number already there, move on

        boolean[] flag = new boolean[10];  //boolean array for checking
        validate(board, i, j, flag);  //constructing the boolean array for the particular i and j
        for (int k = 1; k <= 9; k++) {  //checking for all numbers 1-9
            if (flag[k]) {  //checking whether present or not
                board[i][j] = (char) ('0' + k);  //placing the num
                if (dfs(board, d + 1)) return true; //moving on
            }
        }
        board[i][j] = '.'; //we on wrong path and failed,backtracking to remove all iterations
        return false;
    }

    public static void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag, true);
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') flag[board[i][k] - '0'] = false;   //filling row wise
            if (board[k][j] != '.') flag[board[k][j] - '0'] = false;   //filling col wise
            int r = i / 3 * 3 + k / 3;
            int c = j / 3 * 3 + k % 3;
            if (board[r][c] != '.') flag[board[r][c] - '0'] = false;  //filling matrix wise
        }
    }

    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);
        for(int i =0;i<board.length;i++){
            for (int j=0;j< board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
