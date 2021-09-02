/*
Was stuck for a long time regarding how to count correctly the nums smaller to the right
Logic is similar to merge sort, we just keep a tuple of value,index to keep track of the original index to inc. count
For count, we traverse on the array1, till we find a num in array2 which larger than current num in array1
as arrays are sorted, finding a larger num on array2 means, all nums before it will be smaller
Also, right nums in array1 will also be greater than it, due to being sorted, so actually, we can traverse in single go.
 */


import java.util.ArrayList;
import java.util.List;

public class Sorting_Leetcode_315_CountOfSmallNum {
    static tuple[] temp;
    static int[] count_arr;
    public static List<Integer> countSmaller(int[] nums) {
        temp=new tuple[nums.length];
        count_arr=new int[nums.length];
        tuple[] org_arr = new tuple[nums.length];
        for (int i=0;i<nums.length;i++){
            org_arr[i] = new tuple(nums[i],i);  //keeping track of value,index
        }
        List<Integer> ans= new ArrayList<>();
        MergeSort(org_arr,0, org_arr.length-1);
        for (int res:count_arr) ans.add(res);
        return ans;
    }

    public static void MergeSort(tuple[] nums, int i, int j){
        if(i==j) return;
        int mid = i+(j-i)/2;
        MergeSort(nums,i,mid);
        MergeSort(nums,mid+1,j);
        merge(nums,i,mid,mid+1,j);
    }

    public static void merge(tuple[] nums, int s1,int e1,int s2,int e2){
        int r=s2,count=0;
        int i = s1, j=s2,c=s1;
        for (int l = s1; l<=e1;l++){
            while (r<=e2 && nums[l].x>nums[r].x){  //as array1 is sorted, r doesn't dec., so traversal is O(n)
                r++;
            }
            count_arr[nums[l].y] += r-e1-1;   //no. of nums left to the r index from start.
        }

        while(i<=e1 && j<=e2){
            if(nums[i].x <= nums[j].x) {
                temp[c++] = nums[i++];
            }
            else {
                temp[c++] = nums[j++];

            }
        }
        while(i<=e1) temp[c++] = nums[i++];
        while(j<=e2) temp[c++] = nums[j++];
        for (int x = s1;x<=e2;x++) nums[x]=temp[x];
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(countSmaller(nums));
    }
}
