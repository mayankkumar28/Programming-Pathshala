/*
Idea is based on binary search. First we determine if the target is present or not
If present we check for the lowest and highest index
For lowest index we check if the number left is target or not. if it is target, it is not the lowest and assign that as low
To prevent index out of bounds, we first check if the position is the starting position or not
In middle we check if we have found the target by if checking ans array has changed from -1
Similarly for highest we first check if it is the last index, if not we check the index after it is target, if yes we assign that as high
 */

public class Searching_Leetcode_34_PosInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};  //default array when target is not found
        int low=0,high= nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target) low= mid+1;
            else if (nums[mid]>target) high=mid-1;
            else {
                //checking the lowest index
                if(mid==0) {
                    ans[0]=0; //lowest target found at 0 index
                    low=0;
                    break;
                }
                else if (nums[mid-1]!=target) {
                    low=mid;
                    ans[0]=mid;  //lowest target found
                    break;
                }
                else high=mid-1; //not the lowest
            }
        }
        if (ans[0]== -1) return ans;  //target not found

        //Checking the highest index
        high= nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target) low= mid+1;
            else if (nums[mid]>target) high=mid-1;
            else {
                if (mid== nums.length-1){
                    ans[1]= nums.length-1;  //highest found at last index
                    break;
                }
                else if (nums[mid+1] != target){
                    ans[1]=mid; //highest found
                    break;
                }
                else low=mid+1; //not the highest index
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums={5,7,7,8,8,10};
        int target=1;
        int[] temp= searchRange(nums,target);
        for (int i :temp) System.out.print(i +" ");
    }
}
