import java.util.Arrays;

//Similar to Leetcode 15 3Sum, just taking a sum and moving pointers on basis of it, and taking min of the result of each loop

public class TwoPointer_Leetcode_16_3SumCloset {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans  = nums[0]+nums[1]+nums[2];
        for (int i =0;i<n-2;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            int p1 = i+1, p2 = n-1;
            while(p1<p2){
                int sum = nums[p1] + nums[p2] + nums[i];
                if ( sum < target) p1++;
                else if (sum > target) p2--;
                else return sum;
                if (Math.abs(sum-target) < Math.abs(ans-target)){
                    ans = sum;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
}
