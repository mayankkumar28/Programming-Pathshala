//Idea is a bit complicated but short and novel
//In this idea we proceed col to col and iterate over rows. if we find solution row, do move to next one
//We store the places of queens in an array where array index will be col and value of index will be the row
//Then we use the slope to determine both the diagonals using absolute values
//horizontal will be found as usual

public class Backtracking_Leetcode_52_NQueens2Alter {
    public static int totalNQueens(int n) {
        int[] queens = new int[n];
        return placeQueens(queens,0);
    }

    public static int placeQueens(int[] queens,int col){
        int sum=0;
        if (col>=queens.length) return 1;  //Completed placing queens
        int row=0;

        while (row<queens.length){
            queens[col]=row;  //Array for storing co-ordinates
            if (isSafe(queens,row,col)){  //checking diagonals and horizontal
                sum += placeQueens(queens,col+1);   //row found, recursion to find row for next col
            }
            row++;  //moving to next row
        }
        return sum;
    }

    public static boolean isSafe(int[] queens,int row,int col){
        for (int i =0;i<col;i++){  //Iterating till the col we have found the rows
            int r = queens[i];  //present row
            int c = i; //present col
            if (r == row) return false;  //checking horizontal
            if (Math.abs(r-row) == Math.abs(c-col)) return false;  //checking diagonal
        }
        return true;
    }

    public static void main(String[] args){
        int n=5;
        System.out.println(totalNQueens(n));
    }
}
