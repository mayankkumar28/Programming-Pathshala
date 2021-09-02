/*
We can find the next lexicographic permutations as follows:
Start from the right side of the array and continue if the array is increasing.
we will find a num X when it will stop increasing (else next perm. not possible)
this num X is the smallest number we can change to calculate the next perm.
we replace this num by the next greatest num in the array which on right side of the num X
we reverse the right side of array (ascending order) using two pointers (because it is already in descending order)
 */

public class Sorting_Leetcode_31_NextPermutation {
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-1;
        while(i >0 && nums[i-1]>=nums[i]){   //finding num X
            i--;
        }
        if (i>=1){
            for (int j=n-1;j>=i;j--){
                if (nums[j]>nums[i-1]){
                    swap(nums,j,i-1);  //replacing X
                    break;
                }
            }
        }
        int start=i, end=n-1;
        while(start<end){
            swap(nums,start,end);  //making ascending order
            start++;end--;
        }
    }

    public static void swap(int[] arr,int x, int y){
        int temp = arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int i:nums) System.out.print(i +" ");
    }

}
