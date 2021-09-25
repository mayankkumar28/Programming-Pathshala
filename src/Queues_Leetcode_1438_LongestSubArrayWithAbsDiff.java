import java.util.ArrayDeque;
import java.util.Deque;

/*
The diff between the largest and the smallest element will determine whether the limit is exceeded or not
Here we are maintaining two deque to determine the largest and smallest element of a sub-array
we determine them by using Leetcode 239 Sliding window maximum, where we remove from last if we find a suitable num ahead
at last we take a window of right - left and if the window exceeds the limit we start removing elements from left
 */

public class Queues_Leetcode_1438_LongestSubArrayWithAbsDiff {
    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left=0; int ans =1;
        for (int right = 0;right<nums.length;right++){
            while (!maxDeque.isEmpty() && nums[right]>=maxDeque.peekLast()){
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[right]);
            while (!minDeque.isEmpty() && nums[right]<= minDeque.peekLast()){
                minDeque.removeLast();
            }
            minDeque.addLast(nums[right]);
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit){
                if (maxDeque.peekFirst() == nums[left]) maxDeque.removeFirst();
                if (minDeque.peekFirst() == nums[left]) minDeque.removeFirst();
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        System.out.println(longestSubarray(nums,limit));
    }
}
