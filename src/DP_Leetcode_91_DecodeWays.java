import java.util.Arrays;

public class DP_Leetcode_91_DecodeWays {
    //====== Top to bottom approach ========
    //So we break the string into 2 parts,of single and double chars as number cannot be greater than 26
    //for single char we check if it is valid and then recursively find the ways of decoding for next chars (i+1)
    //for 2 chars we gain check for isValid and then, recursively find ways for next chars(i+2)
    // we return 1 when we reach the end of the string
    // as we will calculate a char multiple times we can store it in an array for future use
    // note : number of ways only increase when we find a pair i.e in 2,3,4, 4 doesn't contribute to inc. ways, 2,3 does

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return decodeString(s, n, 0, dp);
    }

    public int decodeString(String s, int n, int i, int[] dp) {
        if (i >= n) return 1;
        if (dp[i] != -1) return dp[i];
        dp[i] = 0;
        if (isValid(s.charAt(i) - '0', 1)) dp[i] += decodeString(s, n, i + 1, dp);
        if (i < n - 1 && isValid((s.charAt(i) - '0') * 10 + s.charAt(i + 1) - '0', 2))
            dp[i] += decodeString(s, n, i + 2, dp);
        return dp[i];
    }

    public boolean isValid(int code, int length) {
        if (length == 1) return code >= 1 && code <= 9;
        return code >= 10 && code <= 26;
    }

    //====== Bottom to top approach ========
    // first calculate the answers for first two lengths
    // using a loop starting from 2, calculate no. of ways using the previous two values
    // if the single char is valid, we know how many ways are there till last char, so we add the last answer,
    // if the double char is valid (char including i-1) , we add the i-2 answer on top of that
    // we return the ans when we reach the end
    //

    public int decodeString2(String s, int n, int[] dp) {
        dp[0] = isValid(s.charAt(0) - '0', 1) ? 1 : 0;
        if (n == 1) return dp[0];
        dp[1] = 0;
        if (isValid(s.charAt(1) - '0', 1)) dp[1] += dp[0];
        if (isValid((s.charAt(0) - '0') * 10 + s.charAt(1) - '0', 2)) dp[1]++;  //2 ways
        for (int i = 2; i < n; i++) {
            dp[i] = 0;
            if (isValid(s.charAt(i) - '0', 1)) dp[i] += dp[i - 1];
            if (isValid((s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0', 2)) dp[i] += dp[i - 2];
        }
        return dp[n - 1];
    }
}