public class Sorting_GFG_BubbleSort {
    public static void bubbleSort(int[] arr, int n)
    {
        boolean done =false;  //break point
        while(!done){
            done=true;
            int i =0;
            while(i<n-1){
                if (arr[i]>arr[i+1]){  //bigger element present before smaller
                    swap(arr,i,i+1); //swapping them
                    done=false;   //bigger number found so check for more
                }
                i++;
            }
        }
    }

    public static void swap (int[] arr, int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {24,18,38,43,14,40,1,54};
        bubbleSort(arr,arr.length);
        for (int i:arr) System.out.print(i +" ");
    }
}
