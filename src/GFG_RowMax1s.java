//https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1

public class GFG_RowMax1s {
    static int rowWithMax1s(int[][] arr, int n, int m) {
        int i = 0;
        int j = m-1;
        int index=-1;
        int lowest_j=j;
        while(i<=n-1 && j>=0){
            if (arr[i][j]==1){
                j--;
                if (lowest_j>j){
                    lowest_j=j;
                    index=i;
                }
            }
            else {
                j=m-1;
                i++;
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
