
/*
Comparing one element at one time only
We start from last because we have to store all elements in nums1 (with extra zero's) and it would prevent extra space
we use a counter to track the positions we have filled and two separate counters for each array
It is possible that loop can terminate before both i and j reach zero
so we copy all left elements from array2 to array1 which are already given in sorted order, no need to do this for array1
 */

public class Sorting_Leetcode_88_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1; int j =n-1; int c = nums1.length-1;

        while (i >= 0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[c--] = nums1[i--];
            } else {
                nums1[c--] = nums2[j--];
            }
        }
        while(j>=0){
            nums1[c--] = nums2[j--];
        }
    }


    public static void main(String[] args) {
        int[] nums1= {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,nums2.length);
        for (int i : nums1) System.out.print(i +" ");
    }
}
