import java.util.HashMap;

/*
we put all the numbers in the hashmap and keep their freq as zero
we iterate through all the nums and check if lesser element exists, if so, we skip and continue checking if lesser element exists
we then check if we have taken the same num before or not, if yes we skip else we mark it as 1(seen)
we then loop till continuous nums are present and calculate the length till which we have looped
we can store this value in ans and try to choose next starting point from remaining nums, we return the max ans we obtain
 */

public class Hashing_Leetcode_128_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i< nums.length;i++){
            map.put(nums[i],0 );
        }
        int ans =0;
        for (int i =0;i< nums.length;i++){
            if (map.containsKey(nums[i]-1)) continue;
            if (map.get(nums[i])==1) continue;
            map.put(nums[i],1);
            int length = 0;
            int temp = nums[i];
            while (map.containsKey(temp)){
                length++;
                temp++;
            }
            if (length > ans) ans = length;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
