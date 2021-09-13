/*
Taking n and n-1 in base 2 will be 1011 & 1010, whenever we do one '&' of the two, one '1' disappears
we then count the no. of disappearances, which will only last till n != 0
1011 & 1010 = 1010 , 1010 & 1001 = 1000, 1000 & 0001 = 0000 , 3 iterations, 3 one's
 */

public class BitManipulation_Leetcode_191_NumberOf1Bits {
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = (n &(n-1));
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

}
