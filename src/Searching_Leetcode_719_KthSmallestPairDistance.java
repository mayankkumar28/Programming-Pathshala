/*
A very good question in kth smallest as we have to optimize for counting too using sliding window
Logic is similar to all other kth smallest problems, we find out the range, do binary search, don't terminate till we get low==high
which means that loop doesn't terminate on less than or equal to, we keep increasing our low till we get exact no. == k which is one more than no < k
For counting we use sliding window, using two pointers left and right, to make this work we have to sort the array first
We start fix our right and keep shifting left towards higher numbers till we get difference less than or equal to mid
at this point we have count of all diff less than mid, by using right -left
we repeat this step for all indexes, that is fix right from 0 to array length. and keep incrementing count for each fixed right
a live working is described below the code
 */

import java.util.Arrays;

public class Searching_Leetcode_719_KthSmallestPairDistance {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low =0, high = nums[nums.length-1]-nums[0];
        while (low<=high){
            int mid = low + (high-low)/2;
            if (count(nums,mid) < k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    public static int count (int[] nums, int mid){
        int left = 0, count =0;
        for (int right =0;right<nums.length;right++){
            while (nums[right]-nums[left] > mid) left++;
            count += right-left;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,5,8,9};
        int k = 5;
        System.out.println(smallestDistancePair(nums,k));
    }
}

/*
lo: 0, hi: 7, mid: 3            # mid is 3, let's count how many distances are 3 or less
count: 5, k: 5, possible? yes  # There are 5 distances <= our guess '3'
hi (7) becomes mid (3)          # OK so 3 is the upper bound, why guess higher than '3'?
                                 # No point as it might add more distances than we want
lo: 0, hi: 3, mid: 1
count: 2, k: 5, possible? no  # Only 2 distances are less than our new guess '1'
                              # This means our guess is bad: it's too low.
                              # Guess higher, by setting the guess space higher by
                              # moving `lo` to one higher than our guess.
lo (0) becomes mid+1 (2)
lo: 2, hi: 3, mid: 2
count: 3, k: 5, possible? no  # New guess is still too low
lo (2) becomes mid+1 (3)
lo is the answer: 3     # Notice we had guessed '3' before: at the start, but now
                         # we narrowed it down to a point where `mid` as a guess
                          # is too low, but mid+1 is perfect. mid+1 happens to be `hi` that was set
                         # in the very first step: it was waiting for `lo` to reach it.
 */
