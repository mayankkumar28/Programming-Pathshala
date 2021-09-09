/*
Following program works for all values of k, where k is the number of accepted duplication
Consider j as the index of a new array, since j<=i always, the replacement will be in-place without extra space
we start from left to right, if count is acceptable, we use the same num and inc. j
and if count is not acceptable, we keep inc. count and keep index j constant till we find a new element and place it at j
and then reset the counter
 */

public class TwoPointer_Leetcode_80_RemoveDuplicateTwice {
    public static int removeDuplicates(int[] nums) {
        int k = 2;  //no. of duplicates allowed
        if (nums.length<k) return nums.length;
        int j = 1;  //left pointer of new array
        int count = 1; //no. of times a num has occurred

        for (int i = 1;i<nums.length;i++){
            if (nums[i] == nums[i-1]){
                if (count<k){
                    nums[j] = nums[i];  //acceptable count, copy the same num at j
                    j++;
                }
                count++;  
            }
            else {
                count=1;
                nums[j] = nums[i];   //place new element and reset counter
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i =0;i<len;i++) System.out.print(nums[i] +" ");
    }
}
