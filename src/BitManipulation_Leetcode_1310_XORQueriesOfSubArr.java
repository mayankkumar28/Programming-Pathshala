// computing a prefix array will do the work in O(n) time

public class BitManipulation_Leetcode_1310_XORQueriesOfSubArr {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix_arr = new int[arr.length];
        int[] ans = new int[queries.length];
        prefix_arr[0] = arr[0];
        for (int i =1;i<arr.length;i++){
            prefix_arr[i]= prefix_arr[i-1]^arr[i];
        }
        for (int i =0;i<queries.length;i++){
            int l = queries[i][0]; int r = queries[i][1];  //obtaining values of start and end from 2d matrix
            if (l==0) ans[i] = prefix_arr[r];
            else ans[i] = prefix_arr[r]^prefix_arr[l-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int[] temp = xorQueries(arr,queries);
        for (int i : temp) System.out.print(i+" ");
    }
}
