/*
To maintain to original order we keep a count, we inc. count if we come across a non-zero element
so, index will always be equal to count, unless we encounter a zero which increases index, but not count
We loop from start to end, and for each time index becomes greater than count, we swap the num to the count index
 */

public class Sorting_Leetcode_283_MoveZeros {
    public static void moveZeroes(int[] nums) {
        int index = 0;
        int count =0;
        for (int i =0;i<nums.length;i++){
            if (nums[i] != 0){
                if (i != count) {
                    swap(nums, i, count);
                }
                count++;
            }
        }
    }

    public static void swap (int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int i : nums) System.out.print(i+" ");
    }
}
