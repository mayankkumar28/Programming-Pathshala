import java.util.PriorityQueue;

//first take the two min ropes and sum and add them into the priority queue

public class Heaps_GFG_MinimumCostOfRopes {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long a : arr) pq.add(a);
        long cost = 0;
        int step = n-1;
        while (step>0){
            long f = pq.poll();
            long s = pq.poll();
            cost += f+s;
            pq.add(f+s);
            step--;
        }
        return cost;
    }
}
