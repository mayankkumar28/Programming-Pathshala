public class Leetcode_240_Search2DMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while (i<=matrix.length-1 && j>=0){
            if(matrix[i][j] == target){
                return true;
            }
            else if (matrix[i][j]>target){
                j--;
            }
            else if (matrix[i][j]<target){
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1}};
        int target = 1;
        System.out.println(searchMatrix(matrix,target));
    }
}
