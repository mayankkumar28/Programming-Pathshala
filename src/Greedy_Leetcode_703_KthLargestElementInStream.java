import java.util.PriorityQueue;

//Just holding k-largest in a heap, if a larger numbers enters, we update the queue

public class Greedy_Leetcode_703_KthLargestElementInStream {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public void KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else {
            if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
