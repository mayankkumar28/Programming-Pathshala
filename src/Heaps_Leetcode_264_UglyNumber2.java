import java.util.PriorityQueue;

//we basically add 2,3,5 to a priority q and then keeping adding their multiples
//but to handle duplicates (like 2*3 and 3*2) we keep polling if a duplicate is found
//after n-1 loops we will have arrived at the value, because we started with 1 which is also valid
//we can also use hashmap to keep track of duplicates

public class Heaps_Leetcode_264_UglyNumber2 {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1L);
        int[] primes = new int[]{2, 3, 5};

        for (long i = 1; i < n; i++) {
            long multiple = q.poll();
            while (!q.isEmpty() && q.peek() == multiple) multiple = q.poll();

            for (int j : primes) q.add(j * multiple);
        }
        return q.poll().intValue();
    }
}
