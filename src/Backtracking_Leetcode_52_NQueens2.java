//Taking three boolean arrays to check diagonals and vertical col
//Rest is same as N queens 1

public class Backtracking_Leetcode_52_NQueens2 {
    public static int totalNQueens(int n) {
        boolean[] vertical = new boolean[n];
        boolean[] diagonal = new boolean[2 * n-1];  //Total diagonals will be 2n-1
        boolean[] anti_diagonal = new boolean[2 * n-1];
        return backtrack(vertical,diagonal,anti_diagonal,0,n);
    }

    public static int backtrack(boolean[] vertical,boolean[] left_d,boolean[] right_d,int row,int n){
        int ans=0;
        if (row==n) return 1;

        for (int col=0;col<n;col++){
            if (vertical[col] || left_d[row-col+n-1] || right_d[row+col]) continue;  //Placement not possible here
            //Placing queen
            vertical[col]=true;
            left_d[row-col+n-1]=true;
            right_d[row+col]=true;

            ans += backtrack(vertical,left_d,right_d,row+1,n);//Recursion

            //Removing Queen
            vertical[col]=false;
            left_d[row-col+n-1]=false;
            right_d[row+col]=false;
        }
        return ans;
    }

    public static void main(String[] args){
        int n =4;
        System.out.println(totalNQueens(n));
    }
}
