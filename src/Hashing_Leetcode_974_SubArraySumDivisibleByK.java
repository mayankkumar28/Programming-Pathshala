import java.util.HashMap;
/*
When we will calculate diff in prefix sums, if the diff is divisible by k, then we will inc. the count by freq of prefix-k
for being divisible by k, it should be a multiple of k i.e. k * something
as we can't check for all somethings,so we take the modulo of the sum of nums in the prefix array
for a specific remainder in prefix array, if the same remainder has occurred before, their diff will be divisible by k
as on two points on prefix array, remainder is same, which means sum of all nums between them must be divisible by k
the number of sub-arrays possible will be the number of times that remainder has occurred before i.e freq of it
for taking care of negative nums, the prefix sum is inc. by k, which doesn't affect the answer as we are taking mod
at last we increase the freq of prefix sum
 */
public class Hashing_Leetcode_974_SubArraySumDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int count  =0;
        int prefix_sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i =0;i< nums.length;i++){
            prefix_sum = (prefix_sum+nums[i])%k;//calculating prefix sum array of remainders
            if (prefix_sum<0) prefix_sum += k;  //if sum becomes negative,we add k, which doesn't affect %k
            if (map.containsKey(prefix_sum)){  //same remainder available or not
                count += map.get(prefix_sum);  //checking freq of same remainder and adding to count
            }
            map.put(prefix_sum,map.getOrDefault(prefix_sum,0)+1);  //inc. freq
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums,k));
    }
}
