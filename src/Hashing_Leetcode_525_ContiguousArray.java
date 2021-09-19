import java.util.HashMap;
/*
we first convert 0 to -1 so that sum of -1 and 1 will be zero when equal number of 0 and 1 will exists
so we traverse through the array and compute a prefix sum,
if we encounter a sum for first time, we store it's first occurrence
else we compute the distance between it's first occurrence and current index to compute the length,
as array b/w them will have sum zero and that is what we want - containing equal number of 0 and 1
we return the max length of the array we find through hashmap
 */

public class Hashing_Leetcode_525_ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i =0;i<n;i++){
            if (nums[i]==0) nums[i]=-1;  //replacing 0 to -1
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);  //edge case where entire length has sum 0
        int sum = 0; int ans  =0;
        for (int i =0;i<n;i++){
            sum += nums[i];
            if (map.containsKey(sum)) ans = Math.max(ans,i-map.get(sum));  //length between first occurrence and current position
            else map.put(sum,i);   //first occurrence of sum
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,1,0,0};
        System.out.println(findMaxLength(nums));

    }
}
