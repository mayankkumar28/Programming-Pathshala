import java.util.Scanner;

//Logic same as Leetcode 980

public class Backtracking_Codechef_MM1803 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //test cases
        while (t!=0){
            int n =sc.nextInt();  //Size of matrix
            int[][] maze = new int[n][n];  //Input matrix
            for (int i = 0 ;i<n ; i++){
                for (int j = 0; j<n ; j++){
                    maze[i][j]= sc.nextInt();
                }
            }
            backtrack(maze,0,0,n,"");
            System.out.println();
            t--;
        }
    }
    public static void backtrack(int[][] maze,int i,int j,int n,String temp){
        if (i== n-1 && j== n-1){ //Reached end of matrix
            System.out.print(temp +" ");
            return;
        }

        maze[i][j]=0;  //Marking visited

        //Down
        if (isSafe(maze,i+1,j,n)) backtrack(maze,i+1,j,n,temp+"D");

        //Right
        if (isSafe(maze,i,j+1,n)) backtrack(maze,i,j+1,n,temp+"R");

        //Left
        if (isSafe(maze,i,j-1,n)) backtrack(maze,i,j-1,n,temp+"L");

        //Up
        if (isSafe(maze,i-1,j,n)) backtrack(maze,i-1,j,n,temp+"U");

        maze[i][j]=1; //Marking un-visited

    }

    public static boolean isSafe(int[][] maze,int i,int j,int n){
        if (i>=0 && i<n && j>=0 && j<n && maze[i][j] == 1){ //Matrix limits and no visited
            return true;
        }
        return false;
    }
}
