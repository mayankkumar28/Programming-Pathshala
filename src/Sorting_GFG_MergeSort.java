/*
We keep dividing the array into two parts till we reach single element, then compare and merge them into single array
We then start comparing the two arrays one by one (both sorted) and merge them into single array, using a temp array
we do this till we have sorted all the elements in the array
 */

public class Sorting_GFG_MergeSort {

    public static void merge (int[] arr, int s1, int e1,int s2,int e2){
        int[] temp = new int[arr.length];
        int i = s1, j =s2, c= s1;
        while(i <= e1 && j <= e2){
            if (arr[i] <= arr[j]) temp[c++] = arr[i++];
            else temp[c++] = arr[j++];
        }
        while (i <= e1){
            temp[c++] = arr[i++];
        }
        while (j <=e2) {
            temp[c++] = arr[j++];
        }
        for (int x = s1; x<=e2; x++){
            arr[x] = temp[x];
        }
    }

    public static void mergeSort(int[] arr, int i, int j) {
        if (i==j) return;
        int mid = (i+j)/2;
        mergeSort(arr,i,mid);
        mergeSort(arr,mid+1,j);
        merge(arr,i,mid,mid+1,j);
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        mergeSort(arr,0,arr.length-1);
        for (int x : arr) System.out.print(x +" ");
    }
}
