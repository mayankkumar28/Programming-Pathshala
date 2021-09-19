import java.util.HashMap;
/*
we have to make a+b+c+d = 0, so we can simplify this as a+b = -(c+d)
we put all the the possible sums of a+b in the hashmap using two for loops, with it's freq of occurrence
we then run two for loops for c and d to check for sums -ve of c+d
ans will be the number of of sums present in the hashmap
 */

public class Hashing_Leetcode_454_4Sum2 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        int n = nums1.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0; i<n;i++){
            for (int j =0;j<n;j++){
                int sum = nums1[i]+nums2[j];
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }

        for (int i =0; i<n;i++){
            for (int j =0;j<n;j++){
                int sum = -(nums3[i]+nums4[j]);
                if (map.containsKey(sum)) count += map.get(sum);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        System.out.println(fourSumCount(nums1,nums2,nums3,nums4));
    }
}
