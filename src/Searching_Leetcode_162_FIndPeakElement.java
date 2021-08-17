/*
Problem rests on the logic that if we find a mid, then the side greater than the mid which have a peak for sure
it is because either it will keep increasing till the end or will go down. both results give peak (as arr[-1] = arr[n] = -infinity
 so it's just a matter of finding the greater adjacent side and handling edge cases
 */

public class Searching_Leetcode_162_FIndPeakElement {
    public static int findPeakElement(int[] nums) {
        //edge cases
        if (nums.length==1) return 0;   //array of of size 1
        if (nums[0]>=nums[1]) return 0; //left side case
        else if (nums[nums.length-1]>= nums[nums.length-2]) return nums.length-1;  //right side edge case

        //now peak must rest in the middle, where it will be greater than both the sides
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
            else if (nums[mid+1]>nums[mid]) low=mid+1;  //choosing right as higher side
            else high=mid-1;  //choosing left as higher side
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums={1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
}
