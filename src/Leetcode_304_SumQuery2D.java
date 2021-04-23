public class Leetcode_304_SumQuery2D {
    static int[][] prefix;
    public static void NumMatrix(int[][] matrix) {
        int n =matrix.length;
        int m= matrix[0].length;
        prefix =new int[n][m];

        //initializing first column of every row for prefix sum
        for (int i =0; i<n;i++){
            prefix[i][0]= matrix[i][0];
        }

        //prefix sum rows-wise
        for (int i =0;i<n;i++){
            for (int j=1;j<m;j++){
                prefix[i][j] = prefix[i][j-1]+matrix[i][j];
            }
        }

        //prefix sum column wise
        for (int i = 1;i<n;i++){
            for (int j = 0;j<m;j++){
                prefix[i][j]= prefix[i-1][j]+prefix[i][j];
            }
        }
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        int sum;
        if (col1!=0 && row1!=0){
            sum= prefix[row2][col2]-prefix[row2][col1-1]-prefix[row1-1][col2]+prefix[row1-1][col1-1];
        }
        else if (col1!=0 && row1==0){
            sum= prefix[row2][col2]-prefix[row2][col1-1];
        }
        else if (col1==0 && row1!=0){
            sum= prefix[row2][col2]-prefix[row1-1][col2];
        }
        else {sum = prefix[row2][col2]; System.out.println("else");}
        return sum;
    }

    public static void main (String[] args){
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix(matrix);
        System.out.println(sumRegion(2, 1, 4, 3));
        System.out.println(sumRegion(1, 1, 2, 2));
        System.out.println(sumRegion(1, 2, 2, 4));
    }
}
