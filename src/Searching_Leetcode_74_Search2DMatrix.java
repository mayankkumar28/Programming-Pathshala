//Simply run the binary search for each row in the 2-d matrix using a for loop

public class Searching_Leetcode_74_Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;

        for (int i =0;i<m;i++){
            int low=0, high= n-1;
            while (low<=high){
                int mid = low+(high-low)/2;
                if (matrix[i][mid]==target) return true;
                else if (matrix[i][mid]<target) low=mid+1;
                else high = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target =61;
        System.out.println(searchMatrix(matrix,target));
    }
}
