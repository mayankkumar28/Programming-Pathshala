/*
Can't take XOR here because 3 times XOR will return the num itself => 3^3=0, 0^3=3
So here we count the number of each bit in each num.
because all nums except one are occurring three times, their bits will be divisible by 3 when the 1 single num is not involved
So we can detect extra bit of the one num, by checking divisibility by 3, and add to ans if not divisible
 */

public class BitManipulation_Leetcode_137_SingleNumber2 {
    public static int singleNumber(int[] nums) {
        long mask = (1L<<31);
        int ans = 0;
        for (int i = 31; i>=0; i--){
            int count = 0;
            for (int j =0;j<nums.length;j++){
                if ((nums[j]&mask)>0) count++;
            }
            if (count%3!=0) ans += mask;
            mask>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
    }
}