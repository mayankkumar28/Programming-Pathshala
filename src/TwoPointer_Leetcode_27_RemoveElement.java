/*
Take two pointers from start and end, iterate from left to right
if we encounter a num == val, we swap them, and maintain j as the last number not equal to val
we calculate length as the first occurrence of val, if val is not found we return length of array
 */

public class TwoPointer_Leetcode_27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0, j= nums.length-1;
        while(i<j){
            while(j>0 && nums[j]==val) j--;
            if (i<j && nums[i]==val){
                swap(nums,i,j);
            }
            i++;
        }
        int length=0;
        for (int t = 0;t<nums.length;t++){
            if (nums[t] == val){
                length = t;
                break;
            }
            length=t+1;  //edge case where no val is found
        }
        return length;
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val =2;
        System.out.println(removeElement(nums,val));
        for (int i : nums) System.out.print(i +" ");
    }
}

