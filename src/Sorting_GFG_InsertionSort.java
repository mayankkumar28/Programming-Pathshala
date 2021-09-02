public class Sorting_GFG_InsertionSort {
    public static void insert(int arr[],int i)  {
        while(i>0 && arr[i-1]>arr[i]){
            //swapping the two index
            int temp = arr[i-1];
            arr[i-1]=arr[i];
            arr[i]=temp;
            i--;
        }
    }
    //Function to sort the array using insertion sort algorithm.
    public static void insertionSort(int arr[], int n) {
        for (int i =0;i<n;i++){
            insert(arr,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        insertionSort(arr, arr.length);
        for (int i : arr) System.out.print(i+" ");
    }
}
