/*
Failed a lot of times because mid*mid was going beyond the range of int
logic is to find mid*mid, if it is greater than x we shift our high
otherwise if mid*mid is low there are two possibilities, that mid is low than sq root, then we shift our low
other is that as we are returning int, decimal is not considered and floor is returned.
so we check if next number is greater than root, if so we return that
 */

public class Searching_Leetcode_69_SqrtX {
    public static int mySqrt(int x) {
        if (x==0) return 0;  //to avoid division by zero we take care separately
        int low=1,high=x;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (mid > x/mid) high=mid-1;
            else {
                if (mid+1 > x/(mid+1)) return mid;
                else low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int x = 1000000;
        System.out.println(mySqrt(x));
    }
}
