
/*
We divide the array into two parts - the +ve and -ve
we find index where where separation happens i.e. greater or equal to zero, we assign start points there
by squaring, -ve part will in dec. order and +ve will be asc. order,so we change index accordingly
in case loop terminates before finishing either array, we run loops for remaining elements separately
 */


public class Sorting_Leetcode_977_SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int i= nums.length;
        for (int x = 0;x< nums.length;x++){
            if (nums[x] >=0) {
                i = x;  //found separation
                break;
            }
        }
        int j = i-1;  //end of -ve array
        int c = 0;
        int[] ans = new int[nums.length];
        while (j>=0 && i<nums.length){
            if(nums[i]*nums[i] <= nums[j]*nums[j]){
                ans[c] = nums[i]*nums[i];
                i++;c++;
            }
            else {
                ans[c] = nums[j]*nums[j];
                j--;c++;
            }
        }

        for (int p = j; p >=0 ; p--){   //filling remaining elements
            ans[c++] = nums[p]*nums[p];
        }

        for (int p = i; p < nums.length ;p++){ //filling remaining elements
            ans[c++] = nums[p]*nums[p];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] temp = sortedSquares(nums);
        for (int i : temp) System.out.print(i +" ");
    }
}