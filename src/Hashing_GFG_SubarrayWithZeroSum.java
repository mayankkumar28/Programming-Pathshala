import java.util.HashMap;
/*
if a construct a prefix array of sum, if the values of prefix sum at some two points is equal,
it means sum between the points will be 0
so we start putting prefix sum in a hashmap and check if the same value has occurred or not, if yes return true
We handle a edge case where all elements combined have sum zero by taking a prefix sum of zero first
 */

public class Hashing_GFG_SubarrayWithZeroSum {
    public static boolean findsum(int arr[],int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix_sum=0;
        map.put(0,1);
        for (int i =0;i<n;i++){
            prefix_sum += arr[i];
            if (map.containsKey(prefix_sum)) return true;
            map.put(prefix_sum,1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4 ,2, -3, 1, 6};
        System.out.println(findsum(arr, arr.length));
    }
}
