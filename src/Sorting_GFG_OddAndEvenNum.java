import java.util.Arrays;

/*
Use two pointer approach from quickSort to divide even on left and odd on right side
Then, use sorting in range to sort to divided even and odd values
 */

public class Sorting_GFG_OddAndEvenNum {
    public static void segregateEvenOdd(int arr[], int n) {
        int left = 0;
        int right = n-1;
        while (left<=right){
            while(left<=n-1 && arr[left] %2 ==0 ){
                left++;
            }
            while(right >= 0 && arr[right] %2 !=0 ){
                right--;
            }
            if (left<right) swap(arr,left,right);
        }


        //last element not included in sorting
        Arrays.sort(arr,0,left);
        Arrays.sort(arr,left,n);
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 45, 9, 8, 90, 3};
        segregateEvenOdd(arr, arr.length);
        for (int i : arr) System.out.print(i+" ");
    }
}
