/*
Here we are using the fibonacci series to save on space as we require to know value of last two elements only
we can use this solution for the n stairs problem too
 */

public class DP_GFG_WaysToTileAFloor {
    static Long numberOfWays(int N) {
        long f = 1;
        long s = 2;
        if (N == 1) return f;
        for (int i = 3; i <= N; i++) {
            long temp = (f + s ) ;
            f = s;
            s = temp;
        }
        return s ;
    }
}
