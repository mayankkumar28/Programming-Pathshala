/*
mask of 5 : 101
mask of 6 : 110
mask of 7 : 111
If there is any zero in the bit, the and operation will always give zero
so we can check from left side using a mask that up-to which bit, the value of same
In this case value is same for only left most bit : so, & will be 100  i.e. 4
 */

public class BitManipulation_Leetcode_201_BitwiseAndNumberRange {
    public static int rangeBitwiseAnd(int left, int right) {
        long mask = 1L<<31;
        int ans = 0;
        while (mask>0){
            if((mask&left)==(mask&right)){
                if ((mask&left)>0) ans += mask;  //shouldn't be zero to add to ans
                mask>>=1;  //to check right digit, moving 1 on right side by 1 bit
            }
            else break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5,7));
    }
}
