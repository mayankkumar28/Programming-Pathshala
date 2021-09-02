/*
We choose a pivot element (first num), and then break the arrays into two, one containing lesser and other containing greater elements
Similar to merge sort, we keep dividing till we reach a single element, therefore, TC will be Nlogn only when pivot is in middle of sorted array
For dividing, We maintain two pointers, one left and one right from each end
we increment left when we keep finding nums lesser or equal to the pivot element
we decrement right when we keep finding nums greater to the pivot element
when we find a larger element on left and smaller element on right, we swap them
we then put our pivot element in the middle (dividing point) of the array by swapping
 */

public class Sorting_GFG_QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low<high){
            int p = partition(arr,low,high);   //pivot index
            quickSort(arr,low,p-1);      //dividing based on pivot
            quickSort(arr,p+1,high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = low;
        int left =low+1;
        int right = high;
        while (left <= right){
            while(left <= high && arr[left] <= arr[pivot]){   //nums lesser equal to pivot on left side of array
                left++;
            }
            while(right >=low && arr[right] > arr[pivot]){  //nums greater than pivot on right side of array
                right--;
            }
            if (left<right) swap(arr,left,right);  //swap when obstacle comes
        }
        swap(arr,pivot,right);  //swapping pivot to it's correct position
        return right;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        quickSort(arr,0,arr.length-1);
        for (int temp : arr) System.out.print(temp+" ");
    }
}
