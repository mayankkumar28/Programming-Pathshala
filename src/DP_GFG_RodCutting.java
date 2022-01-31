import java.util.Arrays;

public class DP_GFG_RodCutting {
    public int cutRod(int[] price, int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        return topBottom(n, price, ans);
    }

    // ==== Top Bottom ====
    //start from size n and break into smaller pieces
    //check if sum from smaller pieces is greater or taking whole rod of size i is greater
    // store for ans future use
    public int topBottom(int i, int[] price, int[] ans) {
        if (i == 0) return 0;
        if (ans[i] != -1) return ans[i];
        for (int j = 1; j <= i; j++) {
            ans[i] = Math.max(ans[i], price[j - 1] + topBottom(i - j, price, ans));
        }
        return ans[i];
    }

    // ==== Bottom Top ====
    // start from size 1
    // as the size increases, consult smaller sizes if they are greater than taking whole rod of length i
    public int bottomTop(int[] price, int n) {
        int[] ans = new int[n + 1];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] = Math.max(ans[i], price[j - 1] + ans[i - j]);
            }
        }
        return ans[n];
    }
}
