public class Leetcode_48_Rotate2dArray {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n<=1) return;

        //Swapping the elements (transpose)
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Reversing the rows
        //We can reverse the columns for anti-clockwise rotate
        for (int i=0;i<n;i++){
            int s =0;
            int e =n-1;
            while (s<e){
                int temp = matrix[i][s];
                matrix[i][s]=matrix[i][e];
                matrix[i][e]= temp;
                s++;e--;
            }
        }

        //Print
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
