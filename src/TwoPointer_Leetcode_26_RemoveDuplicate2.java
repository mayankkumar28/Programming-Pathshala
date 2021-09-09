/*
We start from left to right on the array and maintain a count, which is the leftmost unique element
whenever we encounter a num greater than the leftmost unique element, we assign that num to one place right of it
we inc. the index of leftmost unique and return it
 */
public class TwoPointer_Leetcode_26_RemoveDuplicate2 {
    public static int removeDuplicates(int[] nums) {
        int last_unique_idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[last_unique_idx]) {
                last_unique_idx++;     //we change one place right
                nums[last_unique_idx] = nums[i];   //or we can swap, if we want to preserve duplicate nums
            }
        }
        return last_unique_idx + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for (int i : nums) System.out.print(i+" ");
    }
}
