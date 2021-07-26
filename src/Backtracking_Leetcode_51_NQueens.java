import java.util.ArrayList;
import java.util.List;

//Idea is to iterate col-wise to in each row and try to fit the queens and then move to next row
//If we find a place,we recurse from there onwards to try for other queens till we reach the last row
//we then remove all queens during backtrack so that other combinations can be found in subsequent loops
//we use a separate function to check whether a given position is safe or not
//as we going down row-wise, we need to check vertically, and both diagonals of the rows above the present row

public class Backtracking_Leetcode_51_NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        //Initializing matrix
        char[][] arr = new char[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]='.';
            }
        }
        backtrack(ans,arr,0,n);
        return ans;
    }

    public static void backtrack(List<List<String>> ans,char[][] arr,int r ,int n){
        if (r==n) {   //Done with all rows
            ArrayList<String> toAdd = new ArrayList<>();
            for (int i = 0; i < n; i ++) {
                toAdd.add(String.valueOf(arr[i]));   //convert a row of matrix to string and adding to a list
            }
            ans.add(toAdd);  //adding combination to main list of list
            return;
        }

        for (int c =0;c<n;c++){   //Iterating all columns in a row
            if (isSafe(arr,r,c)){  //checking for queens
                arr[r][c]='Q';   //placing the queen
                backtrack(ans,arr,r+1,n);  //recursion
                arr[r][c]='.';  //removing the queen
            }
        }
    }

    public static boolean isSafe(char[][] arr,int i, int j){
        //Checking for the vertical
        int x =i-1;
        while(x>=0){
            if (arr[x][j]=='Q') return false;
            x--;
        }
        //Checking for the diagonal
        x=i-1;
        int y=j-1;
        while(x>=0 && y>=0){
            if (arr[x][y]=='Q') return false;
            x--;y--;
        }
        //Checking reverse diagonal
        x=i-1;y=j+1;
        while(x>=0 && y< arr.length){
            if (arr[x][y]=='Q') return false;
            x--;y++;
        }
        return true;
    }

    public static void main(String[] args){
        int n =4;
        System.out.println(solveNQueens(n));
    }
}
