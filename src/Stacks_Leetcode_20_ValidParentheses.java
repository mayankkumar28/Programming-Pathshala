import java.util.Stack;

/*
Till we are getting open brackets, we keep storing them in a stack
now for the first closed bracket, it should be the same as the last open bracket
the last open bracket is always there on the top of the stack
so we just compare if the last open is equal to first close, if true, move on else return false
 */

public class Stacks_Leetcode_20_ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i =0;i<s.length();i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }
            else{
                if (st.empty()) return false;
                else if (isEqual(st.peek(),s.charAt(i))) st.pop();
                else return false;
            }
        }
        return st.empty();
    }

    public static boolean isEqual(char x, char y){
        if (x=='{' && y=='}') return true;
        if (x=='[' && y==']') return true;
        if (x=='(' && y==')') return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(isValid(s));
    }
}
