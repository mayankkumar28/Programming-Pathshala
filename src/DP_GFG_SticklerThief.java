import java.util.Arrays;

public class DP_GFG_SticklerThief {
    //======  Top to bottom approach========
    //We start from zero and go towards top, we return when we reach n and calculate cost while backtracking

    public int FindMaxSum(int arr[], int n){
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return findMax(arr,n,dp,0);
    }

    public int findMax (int[] arr, int n, int[] dp, int i){
        if (i>=n) return 0;
        if (dp[i] != -1) return dp[i];
        dp[i] = Math.max(arr[i] + findMax(arr,n,dp,i+2), findMax(arr,n,dp,i+1));
        return dp[i];
    }


    //======  Bottom to top approach========
    //first we find the starting point, then iterate through using previous values
    //Can be done on O(1) space as we need only last two costs only, like fibonacci
    public int FindMaxSum2(int[] arr, int n) {
        int[] costs = new int[n];
        if (n==0) return n;
        if (n==1) return arr[0];

        costs[0] = Math.max(0,arr[0]);
        costs[1] = Math.max(costs[0],arr[1]);
        int ans = 0;
        for (int i = 2;i<n;i++){
            costs[i] = Math.max(arr[i] + costs[i-2],costs[i-1]);
        }
        return costs[n-1];
    }
}
