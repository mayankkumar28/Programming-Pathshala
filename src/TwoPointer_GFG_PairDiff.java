import java.util.Arrays;
/*
Here we take two pointers, one from zero and other one place after it
if the diff is smaller than we want, we increase the range, i.e. j++
if diff is larger then we want, we decrease the range,  move i closer to j,i.e. i++
there is a edge case here when i can be equal to j, in that case we inc. j++
we check each diff till j reach the end of array and return true if we find it
 */

public class TwoPointer_GFG_PairDiff {
    public static boolean findPair(int[] arr, int size, int n) {
        Arrays.sort(arr);
        int i =0, j=1;
        while (j<size){
            int sum =  Math.abs(arr[j]-arr[i]);
            if (sum < n) j++;
            else if (sum > n){
                i++;
                if (i==j) j++;  //edge case
            }
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 5, 80};
        System.out.println(findPair(arr, arr.length, 78));
    }
}
