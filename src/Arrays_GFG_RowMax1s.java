//https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
/*
We are finding row with maximum number of 1's
we start from top right as we can determine next possible direction from there. bottom left is possible too
If the present position has one in it. we continue left otherwise shift down
Loop ends when we reach the last row or last col
 */
public class Arrays_GFG_RowMax1s {
    static int rowWithMax1s(int[][] arr, int n, int m) {
        int row = 0;
        int col = m-1;
        int index=-1;
        while(row<=n-1 && col>=0){   //Keeping in boundaries
            if (arr[row][col]==1){   //Found one
                col--;   //Shifting left
                index=row;  //new ans index
            }
            else {
                row++;   //didn't found 1, shifting down
            }
        }
        return index; 
    }
    public static void main(String[] args){
        int[][] arr = {{0, 1, 1, 1},
                       {0, 0, 1, 1},
                       {0, 1, 1, 1},
                       {0, 0, 0, 0}};
        int n = arr.length;
        int m = arr[0].length;
        System.out.println(rowWithMax1s(arr,n,m));
    }
}
