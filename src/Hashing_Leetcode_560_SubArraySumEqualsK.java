import java.util.HashMap;
/*
Here we have to find number of continuous sub-arrays containing sum k
For a prefix sum, we have to find prefix sum -k, which when added will give us the value k
now to determine number of sub-arrays, we need a count of number of times, prefix sum-k has occurred before
for example if it has occurred two times before, ew have to inc. the count by 2
 */

public class Hashing_Leetcode_560_SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int count  =0;
        int prefix_sum =0;
        HashMap<Integer,Integer> map  = new HashMap<>();
        map.put(0,1);
        for (int i =0;i< nums.length;i++){
            prefix_sum += nums[i];
            if (map.containsKey(prefix_sum-k)){
                count += map.get(prefix_sum-k);
            }
            map.put(prefix_sum,map.getOrDefault(prefix_sum,0)+1); //inc. freq of the prefix sum
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,-1,0};
        int k = 3;
        System.out.println(subarraySum(nums,k));
    }
}
