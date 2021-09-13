/*
For a specific bit, count the number of ones, and no. of zeros will be n-ones
Using product rule, the number of combinations will be x*y where x is no. of ones and y is no. of ones
We do this for all the bits
 */

public class BitManipulation_Leetcode_477_TotalHammingDistance {
    public static int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        long mask = (1L<<31);
        for (int i = 31; i>=0; i--){
            int count = 0;
            for (int j = 0; j<n; j++){
                if ((mask&nums[j])>0) count++;
            }
            ans += count*(n-count);
            mask>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,14,2};
        System.out.println(totalHammingDistance(nums));
    }
}
