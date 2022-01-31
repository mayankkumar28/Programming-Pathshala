public class Heaps_GFG_HeapSort {
    public void buildHeap(int arr[], int n) {
        int start = (n/2)-1;
        for(int i = start;i>=0;i--){
            heapify(arr,n,i);
        }
    }

    //Heapify function to maintain heap property.
    public void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<n && arr[l] > arr[largest]) largest = l;
        if(r<n && arr[r] > arr[largest]) largest = r;
        if(largest!=i){
            int tmp = arr[largest];
            arr[largest]  = arr[i];
            arr[i] = tmp;
            heapify(arr,n,largest);
        }
    }

    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        buildHeap(arr,n);
        for(int i=n-1;i>=0 ;i--){
            int tmp = arr[0];
            arr[0]  = arr[i];
            arr[i] = tmp;
            heapify(arr,i,0);
        }
    }
}
