public class Sorting_GFG_RadixSort {
    public static void sort(int[] arr, int n){
        int[] count = new int[n];
        int[] aux = new int[n];
        //for first digit
        for (int i =0; i<n; i++){
            count[arr[i] % n]++;
        }
        for (int i =1; i<n; i++){
            count[i] += count[i-1];     //prefix count array
        }
        for (int i =n-1;i>=0;i--){
            aux[count[arr[i] % n]-1] = arr[i];  //count sort
            count[arr[i] % n]--;
        }

        for (int i =0; i<n; i++){
           arr[i] = aux[i];    //array copy
           count[i]=0;         //empty count
        }

        //for second digit
        for (int i =0; i<n; i++){
            count[(arr[i]/n) %n]++;
        }
        for (int i =1; i<n; i++){
            count[i] += count[i-1];   //prefix count array
        }
        for (int i =n-1;i>=0;i--){
            aux[count[(arr[i]/n) % n]-1] = arr[i];  //count sort
            count[(arr[i]/n) % n]--;
        }
        for (int i =0; i<n; i++){
            arr[i] = aux[i];  //array copy

        }
    }

    public static void main(String[] args) {
        int[] arr = {40, 12, 45, 32, 33, 1, 22};
        sort(arr, arr.length);
        for (int i:arr) System.out.print(i+" ");
    }
}
