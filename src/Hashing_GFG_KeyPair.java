import java.util.HashMap;
/*
We have to find whether sum of two pairs in arr is equal to x
so if we pick one num, we will require x-num
based on this, we search for x-num in the hashmap, which we have placed before reaching the num
if not found, we put this element in the map and move on to the next one
 */

public class Hashing_GFG_KeyPair {
    public static boolean hasArrayTwoCandidates(int[] arr, int n, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0; i< n; i++){
            if (map.containsKey(x-arr[i])){
                return true;
            }
            map.put(arr[i],0);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int x = 16;
        System.out.println(hasArrayTwoCandidates(arr, arr.length,x));
    }

}
