//The logic is to choose a direction and recurse all the directions from there onwards.
//If we reach the destination we return 1 which count as one path possible. Sum is taken and returned
//We maintain a boolean array isVisited to store all paths taken till that point so that they are not repeated and become a circle
//Limits are taken care of by isSafe function
//Int empty is counted and decremented in each step. we count the path only if empty will be -1 (zero the loop before)

public class Backtracking_Leetcode_980_UniquePaths3 {
    public static int uniquePathsIII(int[][] grid) {

        boolean[][] isVisited = new boolean[grid.length][grid[0].length]; //Array for storing visited paths
        //determining starting point and empty cells
        int empty=0;
        int start1 = 0,start2 = 0;
        for (int i = 0;i < grid.length; i++){
            for (int j = 0;j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    start1 = i;
                    start2 = j;
                }
                if (grid[i][j] == 0) empty++;
            }
        }
        System.out.println(empty);
        return backtrack(grid,isVisited,start1,start2,empty);
    }

    public static int backtrack(int[][] grid,boolean[][] isVisited,int i,int j,int empty){
        if (grid[i][j] == 2 && empty == -1) {  //Destination reached
            return 1;
        }

        int sum = 0; //sum of paths

        isVisited[i][j] = true; //Marking the cell as traveled

        //Right
        if (isSafe(grid,i,j+1) && !isVisited[i][j+1]) sum += backtrack(grid,isVisited,i,j+1,empty-1);

        //Left
        if (isSafe(grid,i,j-1) && !isVisited[i][j-1]) sum += backtrack(grid,isVisited,i,j-1,empty-1);

        //Down
        if (isSafe(grid,i+1,j) && !isVisited[i+1][j]) sum += backtrack(grid,isVisited,i+1,j,empty-1);

        //Up
        if (isSafe(grid,i-1,j) && !isVisited[i-1][j]) sum += backtrack(grid,isVisited,i-1,j,empty-1);

        isVisited[i][j] = false;  //Marking the cell as un-traveled for future loops
        return sum;
    }

    public static boolean isSafe(int[][] grid,int i,int j){
        if (i>=0 && i<grid.length && j>=0 && j<grid[0].length){ //Matrix limits
            if (grid[i][j] != -1){ //poison cell
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        //int[][] grid = {{0,1},{2,0}};
        System.out.println(uniquePathsIII(grid));
    }
}
