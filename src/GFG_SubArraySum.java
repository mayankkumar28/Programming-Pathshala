//https://practice.geeksforgeeks.org/problems/sum-of-subarrays2229/1

public class GFG_SubArraySum {
    public static long subarraySum(long[] a, long n) {
        long sum = 0;
        long m = (long) Math.pow(10,9)+7;
        long contribution;
        if (n==0) return 0;

        for (int i =0; i<n;i++){
            contribution = ((i+1)%m*(n-i)%m*a[i]%m)%m;
            sum = (sum%m + contribution%m)%m;
        }
        return sum%m;
    }
    public static void main(String[] args){
        long[] a = {1,2,3};
        System.out.println(subarraySum(a,a.length));
    }
}
