import java.util.ArrayList;

/*
Instead of finding each pairs in sub-arrays, we find how many pairs can be formed
for this we iterate over each num and see if it is a power of 2, if it is we count++
the total no of distinct pairs that can be formed will be (2^n)-1  where n is the count of numbers
 */

public class BitManipulation_GFG_Power2Subsequences {
    public static Long numberOfSubsequences(int N, ArrayList<Long> A){
        int count = 0;
        for (int i =0; i<N;i++){
            Long temp = A.get(i);
            if (check(temp)) count++;
        }
        return (long) (Math.pow(2,count)-1)%1000000007;
    }

    public static boolean check (Long num){
        return (num & num - 1) == 0;
    }

    public static void main(String[] args) {
        ArrayList<Long> A = new ArrayList<>();
        A.add(1L);A.add(6L);A.add(2L);
        System.out.println(numberOfSubsequences(A.size(),A));
    }
}
