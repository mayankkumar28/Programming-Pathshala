//Same logic as unique paths except using a loop to execute the jumps

public class Backtracking_GFG_RatMazeMultipleJumps {
    public static int[][] ShortestDistance(int[][] matrix){
        int n = matrix.length;  //Matrix size
        int[][] ans = new  int[n][n];  //output answer matrix
        System.out.println(ans[2][2]);
        int jump=matrix[0][0];//number of jumps available on starting point
        matrix[n-1][n-1]=1;  //marking destination as un-blocked
        int[][] empty ={{-1}};
        if(backtrack(matrix,ans,0,0,n,jump)) return ans; //paths available
        else return empty; //for no paths available
    }

    public static boolean backtrack(int[][] matrix,int[][] ans,int i,int j,int n,int jump){
        if (i == n-1 && j == n-1){   //Reached destination
            ans[i][j]=1;
            System.out.println("return " +i +" " +j);
            return true;
        }

        for (int k=1;k<=jump;k++){   //Using a loop to execute all jumps

            //right
            if (j+k < n && i<n){   //Checking matrix boundaries
                if (matrix[i][j+k]!=0 ){  //Checking if step is blocked
                    ans[i][j] = 1;  //Marking footprint
                    System.out.println(i + " " + j);
                    System.out.println("right ");
                    if(backtrack(matrix, ans, i, j + k, n, matrix[i][j + k])) return true;  //Finding next step
                    ans[i][j]=0;  //Un-marking footprint

                }
            }

            //down
            if (i+k < n && j<n){
                if (matrix[i+k][j] !=0) {
                    ans[i][j] = 1;
                    System.out.println(i + " " + j);
                    System.out.println("down");
                    if(backtrack(matrix, ans, i + k, j, n, matrix[i + k][j])) return true;//Finding next step
                    ans[i][j]=0; //Un-marking footprint
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 0, 0}, {3, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 0, 1}};
        //int[][] matrix={{2,0,1,4},{0,1,0,3},{0,0,2,1},{3,2,4,0}};
        //int[][] matrix={{2,0,2,2},{4,3,3,2},{0,1,3,2},{1,4,0,4}};
        int[][] answer= ShortestDistance(matrix);
        print(answer);
    }

    public static void print(int[][] answer){
        for (int i = 0 ;i< answer.length ; i++){
            for (int j = 0; j< answer.length ; j++){
                System.out.print(answer[i][j] +" ");
            }
            System.out.println();
        }
    }
}