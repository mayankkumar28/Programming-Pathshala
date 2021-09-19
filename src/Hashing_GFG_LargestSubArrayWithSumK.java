import java.util.HashMap;
/*
Here we compute prefix sum of the array, for sum = k, we would need a prefix-k that must have occurred before.
So, in case of multiple sub-array having sum k, we store the first index of sub-array as value and prefix sum as key
if we encounter the same prefix sum again, we take maximum of the first index-this index, and previous answer
 */

public class Hashing_GFG_LargestSubArrayWithSumK {
    public static int lenOfLongSubarr(int[] A,int K){
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix_sum = 0;
        int ans = 0;
        map.put(0,-1);
        for (int i =0;i<A.length;i++){
            prefix_sum += A[i];
            if (map.containsKey(prefix_sum-K)){   //prefix sum-k has occurred before
                ans = Math.max(ans,i-map.get(prefix_sum-K));  //taking max distance
            }
            if (!map.containsKey(prefix_sum)) map.put(prefix_sum,i);  //first time prefix sum has come,storing it's first index
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(lenOfLongSubarr(arr,k));
    }
}
