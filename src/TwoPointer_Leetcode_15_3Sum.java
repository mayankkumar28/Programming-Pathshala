import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Keep one pointer constant and other two should be the -ve of the constant
so keep the constant fixed and using two pointers check if there sum is equal to the negative of the constant
keep incrementing constant till the end of the array, but the pointers will always be on the right side
it is because we have checked the possible combinations of the pointers before moving the constant
 */

public class TwoPointer_Leetcode_15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int reminder;
        for (int i =0;i<n;i++){
            if (i>0 && nums[i] == nums[i-1]) continue;
            else reminder = -1*nums[i];
            int p1 = i+1, p2 = n-1;
            while(p1<p2){
                if (nums[p1] + nums[p2] < reminder) p1++;
                else if (nums[p1] + nums[p2] > reminder) p2--;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[p1]); temp.add(nums[p2]);
                    ans.add(temp);
                    if (nums[p1] == nums[p2]) break;
                    else {
                        int x = nums[p1]; int y =nums[p2];
                        while (nums[p1]==x) p1++;
                        while (nums[p2]==y) p2--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
