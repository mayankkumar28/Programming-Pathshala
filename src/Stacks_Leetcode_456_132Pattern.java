import java.util.Stack;

/*
for index s1,s2,s3 we have to find three nums such that s1<s3<s2
it is easier to find s3 first, which will be smaller than s2, and then compare s3 to s2
so iterating from right, if we maintain a stack which will keep the highest value i.e s2
so if we find a greater value than s2, we assign that to s2 and assign previous value of s2 to s3
in this process, if we find a s1 < s3 , we have found our 132 pattern
 */

public class Stacks_Leetcode_456_132Pattern {
    public static boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < s3) {
                return true;
            }
            else {
                while (!stack.isEmpty() && nums[i] > stack.peek()){
                    s3 = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,0,-1,-2,-3,-1,-2};
        System.out.println(find132pattern(nums));
    }
}
