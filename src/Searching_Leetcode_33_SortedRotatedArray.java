/*
We are dividing the array into two parts by finding a pivot. Once we find the pivot we can search in that particular part
pivot exists where it is both less and greater than it's adjacent members
 */
public class Searching_Leetcode_33_SortedRotatedArray {
    public static int search(int[] nums, int target) {
        int ans = -1;
        int pivot = findpivot(nums);

        if (target>nums[nums.length-1]) ans = binarySearch(nums,0,pivot,target);   //search in first part of array
        else ans = binarySearch(nums,pivot+1, nums.length-1,target);  //search in second part

        return ans;
    }


    public static int findpivot(int[] nums){
        int low =0,high= nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (nums[mid]<=nums[nums.length-1]){
                high=mid-1;
            }
            else {
                if (nums[mid]>nums[mid+1]) return mid;
                else low=mid+1;
            }
        }
        return -1;
    }

    //normal binary search
    public static int binarySearch(int[] arr,int low,int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]==target) return mid;
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }


    public static void main(String[] args){
        int[] nums= {2};
        int target=1;
        System.out.println(search(nums,target));
    }
}
