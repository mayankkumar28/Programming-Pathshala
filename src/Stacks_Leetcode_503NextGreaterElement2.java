import java.util.Arrays;
import java.util.Stack;
/*
we have to loop twice to get the circular number
for this, we can use i%n to store indexes, which can be never out of bounds
and loop till twice of size n, ie looping twice
 */
public class Stacks_Leetcode_503NextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge,-1);
        Stack<Integer> st = new Stack<>();
        for (int i =0;i<n*2;i++){
            while (!st.empty() && nums[i%n]>nums[st.peek()]){
                nge[st.pop()] = nums[i%n];
            }
            st.push(i%n);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] temp = nextGreaterElements(nums);
        for (int i :temp ) System.out.print(i+" ");
    }
}
