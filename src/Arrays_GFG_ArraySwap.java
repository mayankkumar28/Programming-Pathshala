//Problem - https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

public class Arrays_GFG_ArraySwap {
    public static int minSwap (int[] arr, int n, int k){
        int swaps =Integer.MAX_VALUE;
        int terms = 0;
        int count=0;
        if (n<=2) return 0;

        //Finding terms less than equal to k;
        for (int i =0;i<n;i++){
            if (arr[i]<=k){
                terms++;
            }
        }

        //===== O(N) Approach ==========
        //First sliding window, finding terms greater equal to k;
        for (int i=0; i<terms; i++){
            if (arr[i]>k){
               count++;
            }
        }
        swaps= Math.min(swaps,count);

        //Next sliding windows, finding terms greater equal to k and taking minimum of them
        for (int i=terms; i<n; i++){
            if (arr[i-terms]>k){
                count--;
            }
            if (arr[i]>k){
                count++;
            }
            swaps=Math.min(swaps,count);
        }
        return swaps;

        /* ============ O(N2) Approach ================

        int s=0;
        int e=terms;
        while (e<=n){
            int count = 0;
            for (int j=s; j<e;j++){
                if(arr[j]>k){
                    count++;
                }
            }
            s++;e++;
            swaps=Math.min(swaps,count);
        }
        return swaps;
        */
    }

    public static void main(String[] args){
        int[] arr = {4,11,6,5,11,20,19,14,14,2,9,20,11,11,15,1,7,12,19,9};
        System.out.println(minSwap(arr,arr.length,14));
        //answer=4
    }
}