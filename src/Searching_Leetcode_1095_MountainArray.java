/*
Basically we have to do binary peak in a mountain array where it first increases then decreases
So, first we find the peak, the bs to the left of it first(taking min if present on both sides) and then on right
return -1 if not found
 */

public class Searching_Leetcode_1095_MountainArray {
    public static int findInMountainArray(int target, int[] arr) {
        int low=0,high=arr.length-1;
        int peak = arr.length-1;

        //Finding the peak
        while(low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid] < arr[mid+1]) low = mid+1;
            else if (arr[mid] > arr[mid+1])  high = mid-1;
            else peak=mid;
        }
        if (peak==target) return peak;

        //Searching on the left side
        low=0;high=peak;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid]<target) low = mid+1;
            else if (arr[mid]>target) high = mid-1;
            else return mid;
        }

        //Searching on the right side
        low=peak;high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (arr[mid] > target) low = mid+1;
            else if (arr[mid] < target) high = mid-1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {0,5,3,1};
        int target = 3;
        System.out.println(findInMountainArray(target,arr));
    }
}
