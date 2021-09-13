/*
we calculate overall xor of the nums, to see which bit is same or not
we divide nums into two categories, for a set bit, if the bit is set to 1 it's in cat1 otherwise cat2, based on overall xor
so all nums in cat1 & cat2 will be cancelled out because they occur 2 times except our values which will be our ans
 */

public class BitManipulation_Leetcode_260_SingleNumber3 {
    public static int[] singleNumber(int[] nums) {
        int overAllXor = 0;
        for (int i =0;i< nums.length;i++){
            overAllXor ^= nums[i];
        }
        int leastsetbit = 1;
        while((leastsetbit&overAllXor)==0) leastsetbit<<=1;
        int val[] = new int[2];
        for (int i =0;i< nums.length;i++){
            if ((nums[i]&leastsetbit)>0) val[0] ^= nums[i];
            else val[1] ^= nums[i];
        }
        return val;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] temp = (singleNumber(nums));
        for (int i : temp) System.out.print(i+" ");
    }
}
