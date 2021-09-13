/*
we cannot left or right shift here as the length is very large ~500, otherwise it would be easy
here we have to do all operations on string only
so even we encounter an even num, we just have to remove the last digit to mimic left shift
for odd num, we have to add 1, which means right shift, for which we have to make first 0, 1 on the left side & remove last digit

To mimic this we have to use carry:
1. We haven't encountered any 1. Every char adds one operation.
2. We encounter our first 1. We set carry to 1 and add two operations.
3. The rest:
3A. Every 1 needs one operation (carry makes it 0). carry is still 1 due to addition.
3B. Every 0 needs two operations (carry makes it 1). carry is still 1 as we need to add 1 in this case.

 */

public class BitManipulation_Leetcode_1404_StepsToReduceToOne {
    public static int numSteps(String s) {
        int n = s.length();
        int count = 0;
        int carry = 0;
        for (int i=n-1;i>0;i--){
            if (s.charAt(i)-'0' + carry == 1) {
                carry=1;
                count++;
            }
            count++;
        }
        return count+carry;
    }

    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }
}

