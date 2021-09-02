/*
This solution uses count sort, there are simpler solutions too
We use a freq array to store freq. of 0,1,2 in the nums array, then we compute a prefix freq sum
we start from the back of the array to maintain stability
we iterate through the ans array, and start placing the index indicated in the freq array
we decrement 1 freq in the freq array so that subsequent same number can be placed at right index
 */

public class Sorting_Leetcode_75_SortColors {
    public static void sortColors(int[] nums) {
        int[] freq = new int[3];
        int[] ans = new int[nums.length];
        for (int i =0; i< nums.length;i++){
            freq[nums[i]]++;
        }
        for (int i = 1; i< freq.length;i++){
            freq[i] += freq[i-1];
        }
        for (int i = ans.length-1; i>=0;i--){
            ans[freq[nums[i]]-1] = nums[i];
            freq[nums[i]]--;
        }
        System.arraycopy(ans,0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int i : nums) System.out.print(i +" ");
    }
}
