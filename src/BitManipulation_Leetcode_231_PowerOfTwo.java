/*
Works for positive n
if it is a power of 2, it's base2 will be 10000 or 100 or something like that
so we can take 1 less than that no. which will be 01111 or 011
So we can take the and of 10000 & 01111 which will be zero which means it is a power of 2 and return true
 */

public class BitManipulation_Leetcode_231_PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }
}
