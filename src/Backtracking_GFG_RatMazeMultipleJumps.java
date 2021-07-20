//Incomplete
//Good Q

public class Backtracking_GFG_RatMazeMultipleJumps {
    public static int[][] ShortestDistance(int[][] matrix){
        int n = matrix.length;  //Matrix size
        int[][] ans = new  int[n][n];  //output answer matrix
        int jump=matrix[0][0];//number of jumps available on starting point
        matrix[n-1][n-1]=1;
        backtrack(matrix,ans,0,0,n,jump);
        int[][] empty = {{-1}};
        if (ans[n-1][n-1]==1) return ans; //paths available
        else return empty;  //for no paths available
    }

    public static void backtrack(int[][] matrix,int[][] ans,int i,int j,int n,int jump){
        if (i == n-1 && j == n-1){   //Reached destination
            ans[i][j]=1;
            System.out.println("return " +i +" " +j);
            return;
        }

        for (int k=1;k<=jump;k++){   //Using a loop to execute all jumps

            if (ans[n-1][n-1]==1) break;  //Destination has already been reached once. No need to process further

            //right
            if (j+k < n && i<n){   //Checking matrix boundaries
                if (matrix[i][j+k]!=0 ){  //Checking if step is blocked or if it's the destination
                    ans[i][j] = 1;  //Marking footprint
                    System.out.println(i + " " + j);
                    System.out.println("right ");
                    backtrack(matrix, ans, i, j + k, n, matrix[i][j + k]);  //Finding next step
                }
            }

            //down
            if (i+k < n && j<n){
                if (matrix[i+k][j] !=0) {
                    ans[i][j] = 1;
                    System.out.println(i + " " + j);
                    System.out.println("down");
                    backtrack(matrix, ans, i + k, j, n, matrix[i + k][j]);  //Finding next step
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix={{2,1,0,0},{3,0,0,1},{0,1,0,1},{0,0,0,1}};
        //int[][] matrix={{2,0,1,4},{0,1,0,3},{0,0,2,1},{3,2,4,0}};
        //int[][] matrix={{2,0,2,2},{4,3,3,2},{0,1,3,2},{1,4,0,4}};

        //Printing answer
        int[][] answer = ShortestDistance(matrix);
        for (int i = 0 ;i< answer.length ; i++){
            for (int j = 0; j< answer.length ; j++){
                System.out.print(answer[i][j] +" ");
            }
            System.out.println();
        }
    }
}