/*
Using &1 as mask to find out whether a bit is 1 or 0 for all three a,b,c
if a and b is 1 and c is 0, it means we have to change a and b to 0
if a and b is 0 and c is 1, it means we have to change one a or b to 1
if all three are 0, we don't have to change anything
 */

public class BitManipulation_Leetcode_1318_MinFlipsAorBToC {
    public static int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i=0;i<32;i++){
            int bit_a =0,bit_b=0,bit_c=0;
            if (((a>>i)&1)>0) bit_a =1;
            if (((b>>i)&1)>0) bit_b =1;
            if (((c>>i)&1)>0) bit_c =1;
            if (bit_c == 0 && (bit_a | bit_b) ==1) ans += bit_a+bit_b;
            else if (bit_c == 1 && (bit_a | bit_b) ==0) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFlips(8,3,5));
    }
}
