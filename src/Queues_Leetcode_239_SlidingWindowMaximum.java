import java.util.ArrayDeque;
import java.util.Deque;

/*
Here we use a double ended queue - deque of size k to determine what is the current highest element in the sliding window
The populate this, we run our sliding window, if we encounter a num larger than our last element in queue,
it means that the larger num will replace the back one, and so we pop out the last elements of queue till we are getting smaller nums
we store index in our queue, if the next num is smaller, it can't replace and we add it's index to our back of queue, for future use
before inserting at back, we check if the front element is in our current window or not, by using i-k, we remove it if not
 */

public class Queues_Leetcode_239_SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int index = 0;
        Deque<Integer> d = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        for (int i =0;i<k;i++){
            insertAtBack(d,i,nums);
        }
        for (int i = k;i<n;i++){
            ans[index] = nums[d.getFirst()]; index++;
            if (d.getFirst() == i-k) d.removeFirst();  //checking if first of queue is in our current window
            insertAtBack(d,i,nums);
        }
        ans[index] = nums[d.getFirst()];  //adding result of last window
        return ans;
    }

    public static void insertAtBack(Deque<Integer> d,int index, int[] nums){
        while (!d.isEmpty() && nums[index]>=nums[d.getLast()]){
            d.removeLast();
        }
        d.addLast(index);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] temp = maxSlidingWindow(nums,k);
        for (int i : temp ) System.out.print(i+" ");
    }
}
