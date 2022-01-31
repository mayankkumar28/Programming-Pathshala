public class DP_GFG_AdjacentsNotAllowed {

    //Doing it in O(1) space as we require only last two costs, we can use an array to store cost too
    // we first choose the starting point, by taking max of first two points
    // then onwards, we calculate whether we skip the current num or take it
    // we update our last two values accordingly

    static int maxSum(int N, int mat[][]){
        if (N==0) return 0;
        if (N==1) return Math.max(mat[0][0],mat[1][0]);

        int cost1 = Math.max(mat[0][0],mat[1][0]);
        int cost2 = Math.max(cost1, Math.max(mat[0][1],mat[1][1]));
        for (int i = 2;i<N;i++){
            int curr_cost = Math.max(Math.max(mat[0][i],mat[1][i]) + cost1, cost2);
            cost1 = cost2;
            cost2= curr_cost;
        }
        return Math.max(cost1,cost2);
    }
}
