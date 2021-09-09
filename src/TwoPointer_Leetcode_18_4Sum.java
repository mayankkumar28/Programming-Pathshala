import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//similar to Leetcode 15 Threesome, just using one extra pointer at start and reminder will be target - diff

public class TwoPointer_Leetcode_18_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int reminder;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i =0;i<n;i++){
            if (i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1;j<n; j++){
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                reminder = target - (nums[i]+nums[j]);
                int p1 = j+1, p2 = n-1;
                while (p1<p2){
                    if (nums[p1] + nums[p2] < reminder) p1++;
                    else if (nums[p1] + nums[p2] > reminder) p2--;
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[p1]);temp.add(nums[p2]);
                        ans.add(temp);
                        if (nums[p1]==nums[p2]) break;
                        int x = nums[p1]; int y = nums[p2];
                        while(nums[p1]==x) p1++;
                        while(nums[p2]==y) p2--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums,target));
    }
}
