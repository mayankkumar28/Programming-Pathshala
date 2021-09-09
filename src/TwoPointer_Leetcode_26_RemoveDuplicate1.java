import java.util.Arrays;
/*
Similar logic to leetcode 27
But here we are gonna have to sort the resulting array as swap will not given sorted one
so for optimal solution refer 2nd sol
 */

public class TwoPointer_Leetcode_26_RemoveDuplicate1 {
    public static int removeDuplicates(int[] nums) {
        int i = 0, j= nums.length-1;
        while(i<j){
            while(j>0 && nums[j]==nums[j-1]) j--;
            if (i<j && nums[i]==nums[i+1]){
                swap(nums,i,j);
                j--;
            }
            i++;
        }
        Arrays.sort(nums,0,j+1);
        return j+1;
    }
    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for (int i : nums) System.out.print(i+" ");
    }
}
