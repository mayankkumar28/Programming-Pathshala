/*
Similar to kth smallest element in matrix except constructing matrix will give memory limit exceeded
so instead of matrix, we can directly multiply terms to construct each value in real-time
Logic will be similar to search in a 2d matrix, except the matrix is 1 indexed so limits will be accordingly.
 */


public class Searching_Leetcode_668_KthNumInMulTable {
    public static int findKthNumber(int m, int n, int k) {
        int low= 1,  high = m*n;
        while(low<=high){
            int mid = low+(high-low)/2;
            int count = count(mid,m,n);
            if(count < k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    public static int count(int mid,int m,int n){
        int i = 1; int j = n;   //starting from top right of the imaginary matrix
        int count=0;
        while (i <= m && j>=1){
            if (i*j > mid) j--;
            else {
                count += j;  //as soon as we hit a number less than mid, we increment count & shift down
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 2, n= 3, k=6;
        System.out.println(findKthNumber(m,n,k));
    }
}
