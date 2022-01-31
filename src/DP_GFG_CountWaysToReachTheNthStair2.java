import java.util.Arrays;

/**
 * Bottom to top dp, first we calculate number of ways we can reach bottom from the top position
 * we store it in an array and use it to calculate the total ways for the top stairs
 */

public class DP_GFG_CountWaysToReachTheNthStair2 {
    int countWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return totalWays(n,dp);
    }

    int totalWays(int i, int[] dp){
        if (i<0) return 0;
        if (i==0) return 1;
        if (dp[i] != -1) return dp[i];
        dp[i] = totalWays(i-1,dp)+totalWays(i-2,dp);
        return dp[i];
    }
}
