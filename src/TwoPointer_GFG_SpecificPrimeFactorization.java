/*
There are three ugly numbers, 2,3,5 and we have to find nth number having only 2,3,5 as their prime factors
By default 1 will always be a factor because n1^0 * n2^0 * n3^0
So we maintain three pointers each corresponding to one fo the ugly number
each pointer will tell, till what number we have taken its multiple, suppose p2 is at 5, it means we yet have to take 5*3=15
in order to maintain order, we take min. of the three pointers multiplied by their ugly numbers and then place it first in array
 */

public class TwoPointer_GFG_SpecificPrimeFactorization {
    public static long getNthUglyNo(int n) {
        long[] arr = new long[n];
        arr[0]=1;
        int n1 = 2, n2 = 3, n3 = 5;
        int p1=0, p2=0, p3=0;
        for (int i =1; i<n; i++){
            long val = Math.min(arr[p1]*n1,Math.min(arr[p2]*n2, arr[p3]*n3));
            arr[i]=val;
            if (val == arr[p1]*n1) p1++;
            if (val == arr[p2]*n2) p2++;   //if arr[n1]*p1 == arr[n2]*p2 is same, it avoids duplicity
            if (val == arr[p3]*n3) p3++;
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(getNthUglyNo(n));
    }
}
