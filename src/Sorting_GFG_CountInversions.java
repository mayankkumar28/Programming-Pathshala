//Similar to merge sort, just keeping a count of inversions whenever arr[i]>arr[j] during merge sort process

public class Sorting_GFG_CountInversions {
    static long count;
    static long[] temp;
    public static long inversionCount(long[] arr, long N) {
        count=0;
        temp = new long[arr.length];
        mergeSort(arr,0, (int) (N-1));
        return count;
    }

    public static void mergeSort (long[] arr, int i, int j){
        if (i==j) return;
        int mid = (i+j)/2;
        mergeSort(arr,i,mid);
        mergeSort(arr,mid+1,j);
        merge(arr,i,mid,mid+1,j);
    }

    public static void merge (long[] arr,int s1,int e1,int s2, int e2){
        int i = s1,j= s2,c=  s1;
        while (i<=e1 && j <= e2){
            if (arr[i] <= arr[j]) temp[c++] = arr[i++];
            else {
                temp[c++] = arr[j++];
                count += e1-i+1;
            }
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

    public static void main(String[] args) {
        long[] nums = {5,2,6,1};
        System.out.println(inversionCount(nums,nums.length));
    }
}
