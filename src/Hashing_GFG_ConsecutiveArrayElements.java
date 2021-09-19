import java.util.HashMap;

//Simply storing all nums in a hashmap and iterating from the min num to the max numb, if the nums are not continuous, return false

public class Hashing_GFG_ConsecutiveArrayElements {
    public static boolean areConsecutives(long[] arr, int N) {
        HashMap<Long,Integer> map = new HashMap<>();
        long min = Long.MAX_VALUE;
        for (int i =0;i<N;i++){
            map.put(arr[i],1);
            min = Math.min(min,arr[i]);
        }
        for (long i = min;i < min+N;i++){
            if (!map.containsKey(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long[] arr = {5, 4, 2, 1, 3};
        System.out.println(areConsecutives(arr,arr.length));
    }
}
