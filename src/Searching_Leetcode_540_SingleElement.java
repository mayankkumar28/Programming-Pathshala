/*
We can find the non repeating element by using indexes. Normally first index will be even and second will be odd
If is not, a single element has occurred on or before it. So set high before it.
we return when an element is unequal to both it's indexes
Edge cases should be checked too
 */

public class Searching_Leetcode_540_SingleElement {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length==1) return nums[0];
        int ans = -1;

        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (mid==0) {  //Edge case
                if (nums[0] != nums[1]) return nums[0];
                else low = mid+1;
            }
            else if (mid== nums.length-1) {  //edge case
                if (nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
                else high=mid-1;
            }

            else if (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];  //found!
            else {
                //assigning first element
                int fo;
                if (nums[mid]==nums[mid+1]){
                    fo = mid;
                }
                else {
                    fo = mid-1;
                }
                if (fo%2==0) low=mid+1; //if first element is even, single element has not occurred
                else high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
