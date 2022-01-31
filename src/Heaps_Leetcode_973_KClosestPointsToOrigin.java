import java.util.PriorityQueue;

//Take pq of size k in descending order, so everytime the gets bigger than k, the largest element gets polled off

public class Heaps_Leetcode_973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((b, a) -> {
            int d1 = a[0]*a[0] + a[1]*a[1];
            int d2 = b[0]*b[0] + b[1]*b[1];
            return Integer.compare(d1,d2);
        });
        for (int[] p : points){
            q.add(p);
            if (q.size() > k) q.poll();
        }
        int[][] ans = new int[k][2];
        while(k>0){
            ans[--k] = q.poll();
        }
        return ans;
    }
}
