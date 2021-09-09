/*
We can flip k times if we have a zero, therefore while in a window, we can encounter only k zeros
we use two pointers, low and high, we iterate till high reaches the end of the array
We keep a count of zeros as we iterate, and a length, which is the largest length possible till now
for a specific iteration, if it is less than k we keep moving forward, and update the length
else if it becomes more than k, we move our low, and if low was sitting on zero, we dec count of zeros of our window
 */

public class TwoPointer_Leetcode_1004_MaxConsecutiveOnes3 {
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int length=0;
        int low =0, high = 0;
        int count_zero=0;
        while (high<n){
            if (nums[high]==0) count_zero++;
            if (count_zero<=k) {
                length= Math.max(length,high-low+1);
            }
            else {
                if (nums[low]==0) count_zero--;
                low++;
            }
            high++;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }
}
