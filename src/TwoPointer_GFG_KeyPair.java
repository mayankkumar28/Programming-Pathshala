import java.util.Arrays;

/*
Two pointers here work only on sorted array
Using one from start and one from end, we compare there sum and accordingly take action
if sum is smaller, we need larger num, we inc. i++, if sum is larger, we need smaller num, dec. j--
return true when we reach sum
 */

public class TwoPointer_GFG_KeyPair {
    public static boolean hasArrayTwoCandidates(int[] arr, int n, int x) {
        Arrays.sort(arr);
        int i = 0, j=n-1;
        while(i<j){
            int sum = arr[i]+arr[j];
            if (sum > x) j--;
            else if (sum < x) i++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        System.out.println(hasArrayTwoCandidates(arr, arr.length,16));
    }
}
