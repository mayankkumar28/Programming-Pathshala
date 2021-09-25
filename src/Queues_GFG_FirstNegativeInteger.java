import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
We take a queue of size k
we then search for negative elements in our first window, if found we add them to our queue
we then slide the window, and if our queue is empty it means no negative elements are present, so we push 0 to our ans array
else we push the front num in our queue to ans array
Next we check if our front is in our current window or not, if not we pop it out
 */
public class Queues_GFG_FirstNegativeInteger {
    public static long[] printFirstNegativeInteger(long[] A, int N, int K){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Long> ans = new ArrayList<>();

        for (int i =0;i<K;i++){
            if (A[i] < 0) q.add(i);  //first window
        }
        for (int i = K;i<N;i++){
            if (q.isEmpty()) ans.add(0L);
            else ans.add(A[q.peek()]);

            if (!q.isEmpty() && i-K== q.peek()) q.remove();  //checking front in current window

            if (A[i]<0) q.add(i);
        }
        if (q.isEmpty()) ans.add(0L);  //addition of last window
        else ans.add(A[q.peek()]);
        return ans.stream().mapToLong(i -> i).toArray();
    }


    public static void main(String[] args) {
        long[] A = {-8, 2, 3, -6, 10};
        int k = 2;
        long[] temp = printFirstNegativeInteger(A,A.length,k);
        for (long i : temp) System.out.print(i +" ");
    }
}