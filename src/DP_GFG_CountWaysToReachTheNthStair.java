import java.util.Arrays;

/**
 * Top to bottom dp, first we calculate number of ways we can reach top from the top-1 and top-2 position
 * we store it in an array and use it to calculate the total ways for the bottom stairs
 */


public class DP_GFG_CountWaysToReachTheNthStair {
    int countWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return totalWays(0,dp,n);
    }

    int totalWays(int i, int[] dp, int n){
        if (i>n) return 0;
        if (i==n) return 1;
        if (dp[i] != -1) return dp[i];
        dp[i] = totalWays(i+1,dp,n)+totalWays(i+2,dp,n);
        return dp[i];
    }
}
