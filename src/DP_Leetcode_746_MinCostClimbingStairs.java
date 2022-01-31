public class DP_Leetcode_746_MinCostClimbingStairs {

    // =====  DP Top Bottom Solution =======
    //Start from the top, and formulate dp array as we go to the bottom using min cost of the two steps to be taken

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        return Math.min(calCost(cost,dp,n-1), calCost(cost,dp,n-2));
    }

    public int calCost (int[] cost, int[] dp, int n){
        if (n<0) return 0;
        if (n==0 || n==1) return cost[n];
        if (dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(calCost(cost,dp,n-1), calCost(cost,dp,n-2));
        return dp[n];
    }

    //========= o(1) space solution similar to fibonacci ======
    //first takes two steps and second take one step, we compare them and proceed for the min
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n<=2) return Math.min(first, second);
        for (int i=2; i<n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }


}
