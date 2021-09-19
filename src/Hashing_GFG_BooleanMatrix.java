/*
first we see in which row and col 1 occurs and then mark both row and col as 1 taking separate two arrays
then we run another loop and if if specific row or col has been marked, we marked it in the main matrix
 */

public class Hashing_GFG_BooleanMatrix {
    public static void booleanMatrix(int[][] matrix){
        int[] mark_row = new int[matrix.length];
        int[] mark_col = new int[matrix[0].length];
        for (int i =0;i< matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==1){
                    mark_col[j]=1;
                    mark_row[i]=1;
                }
            }
        }
        for (int i =0;i< matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (mark_row[i]==1 || mark_col[j]==1){
                    matrix[i][j]=1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix =   {{0, 0, 0},
                            {0, 0, 0},
                            {0, 1, 0}};

        booleanMatrix(matrix);
        //printing ans
        for (int i =0;i< matrix.length;i++){
            for (int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
