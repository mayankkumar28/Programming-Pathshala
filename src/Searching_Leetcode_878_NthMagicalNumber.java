/*
Magic number = n-th divisible by either number
So, to find the nth number we will have to take into account three things - no's divisible by a,b and their lcm's.
During count, we find number/a and add, number/b and add, number/lcm and subtract (lcm removes duplicates in that range).
We do binary search, on the max range possible and find the smallest possible magical nth number(similar to kth smallest no.)
Loop will only exit when low=high, which will mean that we have arrived at value one more than (less than n)
 */


public class Searching_Leetcode_878_NthMagicalNumber {
    public static int nthMagicalNumber(int n, int a, int b) {
        long low = 0; long high = Long.MAX_VALUE;
        while (low<=high){
            long mid = low+(high-low)/2;
            long count = count(a,b,mid);

            if (count < n) low =mid+1; //when count of magic numbers is less than n
            else high = mid-1;   //when count of magic nos is equal or more than n. loop exits at equal to.
        }
        return (int) (low % (1e9 + 7));
    }

    public static long count (int a, int b,long mid){
        long count = (mid/a);
        count += (mid/b);
        int lcm = lcm(a,b);
        count -= (mid/lcm);  //removing duplicates
        return count;
    }

    public static int lcm (int a, int b){
        return a*b/gcd(a,b);
    }

    public static int gcd (int a, int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println(nthMagicalNumber(3,6,4));
    }
}
