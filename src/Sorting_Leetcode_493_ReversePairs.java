/*
We use merge sort to solve this problem. Logic is as follows-
We keep dividing the array into two parts till we reach single element, we use merge sort function for this
We then start comparing the two arrays one by one (both sorted) and merge them into single array, using a temp array
Before this process, we compare for each i in array1, the 2*arr[j] value, till we reach more than equal to
it will mean that all the values greater than i in array1 will also be greater, so we add to count=> length- i
 */


public class Sorting_Leetcode_493_ReversePairs {
    static int count;
    static int[] temp;
    public static int reversePairs(int[] nums) {
        count=0;
        temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return count;
    }

    public static void mergeSort(int[] nums, int i, int j){
        if(i==j) return;
        int mid = i+(j-i)/2;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j);
        merge(nums,i,mid,mid+1,j);
    }

    public static void merge(int[] nums, int s1,int e1,int s2,int e2){
        int l = s1;
        int i =s1,j=s2,c=s1;
        for (int r = s2; r<=e2; r++){
            while (l<=e1 && nums[l] <= (long) 2*nums[r]){
                l++;
            }
            count += e1-l+1;
        }
        while(i<=e1 && j<=e2){
            if (nums[i] <= nums[j]) temp[c++] = nums[i++];
            else temp[c++] = nums[j++];
        }
        while (i<=e1) temp[c++] = nums[i++];
        while (j<=e2) temp[c++] = nums[j++];
        for (int x = s1; x<=e2; x++) nums[x] = temp[x];

    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }
}