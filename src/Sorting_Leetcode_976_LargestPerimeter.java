import java.util.Arrays;
/*
Sort the array in ascending order
start from the right side of array (greatest num), if the triangle is valid i.e. the sum of 2 nums left>num, return ans
 */
public class Sorting_Leetcode_976_LargestPerimeter {
    public static int largestPerimeter(int[] nums) {
        int n = nums.length;
        if (n<3) return 0;
        Arrays.sort(nums);
        int ans= 0;
        for (int i = n-1;i>1;i--){
            if (isValid(nums,i)){   //sum of two lesser sides > third greatest side
                ans = nums[i]+nums[i-1]+nums[i-2];
                break;
            }
        }
        return ans;
    }

    public static boolean isValid (int[] nums, int i){
        if (nums[i-1]+nums[i-2]>nums[i]) return true;
        else return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,18,3,8,4,4};
        System.out.println(largestPerimeter(nums));
    }
}
