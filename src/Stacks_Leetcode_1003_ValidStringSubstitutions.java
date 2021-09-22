import java.util.Stack;
/*
We always place abc in continuous manner and this is always fixed
we can use stack to determine whether these three always occur together or not
whenever we encounter a c, it's previous two elements must be strictly b and a, if not we return false
else we pop them from our stack and iterate till we encounter next c
in this way, we stack should be empty when we reach the end because for all c's, all b's and a's must have been popped out
 */

public class Stacks_Leetcode_1003_ValidStringSubstitutions {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i =0;i< s.length();i++){
            char c = s.charAt(i);
            if (c=='c'){
                if (st.isEmpty() || st.pop()!='b') return false;
                if (st.isEmpty() || st.pop()!='a') return false;
            }
            else st.push(c);
        }
        return st.empty();
    }

    public static void main(String[] args) {
        String s = "aabcbc";
        System.out.println(isValid(s));
    }
}
