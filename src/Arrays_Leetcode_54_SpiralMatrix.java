import java.util.ArrayList;
import java.util.List;

public class Arrays_Leetcode_54_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ans = new ArrayList<Integer>();
        int col_end = matrix[0].length-1; //no of columns
        int row_end= matrix.length-1; //now of rows
        int row_start=0, col_start=0;
        //int m1=col_end+1,n1=row_end+1; //for printing

        while(row_start<=row_end && col_start<=col_end){

            for (int i =col_start;i<=col_end;i++){
                ans.add(matrix[col_start][i]);
            }
            row_start++;
            for (int i =row_start;i<=row_end;i++){
                ans.add(matrix[i][col_end]);
            }
            col_end--;
            if (row_start<=row_end) {
                for (int i = col_end;i>=col_start;i--){
                    ans.add(matrix[row_end][i]);
                }
            }
            row_end--;
            if (col_start<=col_end) {
                for (int i = row_end; i >= row_start; i--) {
                    ans.add(matrix[i][col_start]);
                }
            }
            col_start++;
        }

        //Print
//        for (int i=0;i<(m1*n1);i++){
//            System.out.println(ans.get(i));
//        }
        return ans;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] matrix = {{1},{2},{3},{4}};
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }
}
