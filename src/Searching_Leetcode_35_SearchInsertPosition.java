public class Searching_Leetcode_35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            if (nums[mid]==target) return mid;
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return low;
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 4;
        System.out.println(searchInsert(nums,target));
    }

}