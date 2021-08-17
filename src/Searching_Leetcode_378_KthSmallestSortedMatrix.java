/*
Similar to finding smallest kth element
we find the count of number smaller than the mid by searching in a 2d sorted array
if the count is less we shift the low (range not elements) to the right side otherwise we shift the high
the loop will only terminate when we reach low == high we will occur only when we have the exact value of k
because for greater values we will keep shifting high
For counting we need to start from top right, if the element is smaller we update count and shift down (all elements left will be smaller too)
else we keep shifting left. Loop terminates when we go out of boundaries
 */

public class Searching_Leetcode_378_KthSmallestSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low<=high){
            int mid = low+(high-low)/2;
            int count = getCount(matrix,mid);
            if (count < k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    //Searching in a sorted 2D matrix
    public static int getCount(int[][] matrix, int val){
        int res =0;
        int j = matrix.length-1;
        int i=0;
        while(j>=0 && i<matrix.length){
            if (matrix[i][j] > val) j--;
            else {
                res += j+1;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix,k));
    }
}
